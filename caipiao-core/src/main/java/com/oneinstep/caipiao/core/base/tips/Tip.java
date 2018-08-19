package com.oneinstep.caipiao.core.base.tips;

/**
 * 返回给前端的信息提示
 */
public abstract  class Tip {

    protected int code;
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
