package com.oneinstep.caipiao.core.util;

import java.util.Random;

/**
 * @author  henry.shaw(xiaoyao)
 * 封装了一些公共方法，例如对字符串和日期的一些操作
 */
public class ToolUtil {

    /**
     * 获取随机位数的字符串，用于生成用户的密码加密盐值等操作
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
