package com.oneinstep.caipiao.shiro.controller;

import com.oneinstep.caipiao.core.controller.BaseController;
import com.oneinstep.caipiao.shiro.entity.User;
import com.oneinstep.caipiao.shiro.service.IUserService;
import com.sun.net.httpserver.Authenticator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    IUserService userService;

    @RequestMapping("")
    public String index() {
        return "redirect:/list";
    }

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:view")
    public String list(Model model){
        List<User> users = userService.list();
        model.addAttribute("users",users);
        return "user/list";
    }

    /**
     * 跳转到用户添加页面
     * @return
     */
    @RequestMapping("/toAdd")
    @RequiresPermissions("user:add")
    public String toAdd() {
        return "user/userAdd";
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/add")
    @RequiresPermissions("user:add")
    public String add(User user){
        userService.save(user);
        return "redirect:/user/list";
    }

    /**
     * 跳转到用户编辑页面
     * @param model
     * @param uid
     * @return
     */
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Integer uid) {
        User user=userService.findById(uid);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    /**
     * 修改用户其他信息
     * @param user
     * @return
     */
    @RequestMapping("/edit")
    public String edit(User user) {
        userService.update(user);
        return "redirect:/user/list";
    }

    public String updatePass(String userName,String oldPass,String newPass){
        String result = "";
        User user = userService.findByNameAndPass(userName,oldPass);

        return  result;
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:del")
    public String delete(Integer uid){
        userService.delete(uid);
        return "redirect:/user/list";
    }

}