package com.oneinstep.caipiao.shiro.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oneinstep.caipiao.core.base.controller.BaseController;
import com.oneinstep.caipiao.core.base.tips.SuccessTip;
import com.oneinstep.caipiao.core.exception.MyException;
import com.oneinstep.caipiao.core.exception.MyExceptionEnum;
import com.oneinstep.caipiao.core.util.ToolUtil;
import com.oneinstep.caipiao.shiro.entity.User;
import com.oneinstep.caipiao.shiro.service.IUserService;
import com.oneinstep.caipiao.shiro.util.ShiroKit;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    /**
     * 用户相关页面目录前缀
     */
    private static String PREFIX = "/user/";

    /**
     * 重定向到用户列表
     */
    private  static String USERLIST = REDIRECT + PREFIX + "list";

    /**
     * 操作成功提示信息
     */
    protected static SuccessTip SUCCESS_TIP = new SuccessTip();

    @Resource
    IUserService userService;

    @RequestMapping("")
    public String index() {
        return  PREFIX + "/list";
    }

    /**
     * 用户分页列表显示
     * @return
     */
    @ApiOperation(value = "用户列表显示",notes = "分页显示用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pn",value = "当前页数",paramType = "query",required = true,dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "ls",value = "每页显示数据条数",paramType = "query",required = true,dataType = "Integer",defaultValue = "3")
    })
    @GetMapping("/list")
    @RequiresPermissions("user:view")
    public String list(@RequestParam(value="pn",defaultValue="1")Integer pn,@RequestParam(value="ls",defaultValue="3")Integer ls,Model model){
        //pn-->当前页码，默认为1
        //ls-->每页显示数量，默认为3
        PageHelper.startPage(pn,ls);//设置分页信息
        List<User> users = userService.list();//查询出所有的结果
        PageInfo pager = new PageInfo(users);//将查询结果放入分页信息中
        model.addAttribute("pager",pager);
        return PREFIX + "list";
    }

    /**
     * 跳转到用户添加页面
     * @return
     */
    @GetMapping("/toAdd")
    @RequiresPermissions("user:add")
    public String toAdd() {
        return PREFIX + "userAdd";
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping("/add")
    @RequiresPermissions("user:add")
    public String add(User user){
        String salt = ToolUtil.getRandomString(32);
        String credentialsSalt = user.getUsername() + salt;
        String password = ShiroKit.getMd5Pass(user.getPassword(),credentialsSalt);
        user.setSalt(salt);
        user.setPassword(password);
        userService.save(user);
        return USERLIST;
    }

    /**
     * 跳转到用户编辑页面
     * @param model
     * @param uid
     * @return
     */
    @GetMapping("/toEdit")
    @RequiresPermissions("user:edit")
    public String toEdit(Model model,Integer uid) {
        User user = userService.findById(uid);
        model.addAttribute("user", user);
        return PREFIX + "userEdit";
    }

    /**
     * 修改用户其他信息
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户信息",notes="用户名和uid不可修改")
    @PostMapping("/edit")
    @RequiresPermissions("user:edit")
    public String edit(@RequestBody @ApiParam(name = "用户对象",value = "传入json格式",required = true) User user) {
        userService.update(user);
        return USERLIST;
    }

    /**
     * 跳转到修改密码界面
     */
    @GetMapping("/toChPwd")
    public String chPwd() {
        return PREFIX + "chpwd";
    }

    /**
     * 修改密码
     * @param oldPass 旧密码
     * @param newPass 新密码
     * @param rePass 重复密码
     * @return
     */
    @ApiOperation(value = "修改当前用户密码",notes = "修改当前用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="oldPass",value = "旧密码",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name="newPass",value = "新密码",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name="rePass",value = "重复密码",paramType = "query",required = true,dataType = "String")
    })
    @PostMapping("/chPwd")
    public Object updatePass(String oldPass,String newPass,String rePass){
        if(!rePass.equals(newPass)){
            throw new MyException(MyExceptionEnum.TWO_PWD_NOT_MATCH);
        }
        User user = ShiroKit.getUser();
        Integer uid = user.getUid();
        String oldMd5 = ShiroKit.getMd5Pass(oldPass,user.getCredentialsSalt());//原密码加密后
        if(oldMd5.equals(user.getPassword())){
            String newMd5 = ShiroKit.getMd5Pass(newPass,user.getCredentialsSalt());//新密码加密后
            if(userService.updatePass(uid,newMd5)){
                return  SUCCESS_TIP;
            }else {
                return ERROR;
            }
        }else {
            throw  new MyException(MyExceptionEnum.OLD_PWD_NOT_RIGHT);
        }
    }

    /**
     * 删除用户
     * @return
     */
    @ApiOperation(value = "删除指定用户",notes = "根据id删除单个用户")
    @ApiImplicitParam(name = "uid",value = "用户id",required = true,paramType = "query",dataType = "Integer")
    @DeleteMapping("/delete/{uid}")
    @RequiresPermissions("user:del")
    public String delete(@PathVariable("uid") Integer uid){
        userService.delete(uid);
        return USERLIST;
    }

}