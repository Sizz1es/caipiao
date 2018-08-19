package com.oneinstep.caipiao.shiro.util;


import com.oneinstep.caipiao.core.util.ToolUtil;
import com.oneinstep.caipiao.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;

/**
 * shiro工具类
 */
public class ShiroKit {

    /**
     * 获取当前Subject
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取随机盐值
     * @param length
     * @return
     */
    public static String getRandomSalt(int length) {
        return ToolUtil.getRandomString(length);
    }

    /**
     * 获取User
     */
    public static User getUser() {
        if (isGuest()) {
            return null;
        } else {
            return (User) getSubject().getPrincipals().getPrimaryPrincipal();
        }
    }

    /**
     * 验证当前用户是否为“访客”，即未认证（包含未记住）的用户。用user搭配使用
     */
    public static boolean isGuest() {
        return !isUser();
    }

    /**
     * 认证通过或已记住的用户。与guset搭配使用。
     */
    public static boolean isUser() {
        return getSubject() != null && getSubject().getPrincipal() != null;
    }

    /**
     * 对原密码进行md5加盐多次加密
     * @param source
     * @param salt
     * @return
     */
    public  static  String getMd5Pass(String source,String salt){
        SimpleHash sh = new SimpleHash("MD5",source,salt,1024);
        return  sh.toString();
    }
}
