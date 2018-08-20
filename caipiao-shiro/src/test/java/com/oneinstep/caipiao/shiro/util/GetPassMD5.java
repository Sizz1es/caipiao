package com.oneinstep.caipiao.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 计算密码
 */
public class GetPassMD5 {

    public static void main(String[] args) {
        SimpleHash sh = new SimpleHash("MD5","123456","admin1o4e8et7z684r5rixi4odule1emq8el04",1024);
        System.out.println(sh.toString());
    }
}
