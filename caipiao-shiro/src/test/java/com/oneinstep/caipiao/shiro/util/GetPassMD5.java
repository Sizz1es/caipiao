package com.oneinstep.caipiao.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 计算密码
 */
public class GetPassMD5 {

    public static void main(String[] args) {
        SimpleHash sh = new SimpleHash("MD5","123456","admind3c59d25033dbf980d29554025c23a75",1024);
        System.out.println(sh.toString());
    }
}
