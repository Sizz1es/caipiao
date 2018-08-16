package com.oneinstep.caipiao.shiro.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:view")
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/add")
    @RequiresPermissions("user:add")
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/del")
    @RequiresPermissions("user:del")
    public String userDel(){
        return "userInfoDel";
    }
}