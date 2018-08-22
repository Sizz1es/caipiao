package com.oneinstep.caipiao.core.base.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author henry.shaw(xiaoyao)
 * 控制器的父类，封装了一些公用方法及格式转换1
 */
public class BaseController {

    public static final  String SUCCESS = "SUCCESS";

    public static  final  String ERROR = "ERROR";

    public static String REDIRECT = "redirect:";

    public static String FORWARD = "forward:";


    /**
     * 转换日期格式
     * @param binder
     */
    @InitBinder
    public void formatDate(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }


}
