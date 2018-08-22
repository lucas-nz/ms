package com.zhousz.ms.util;

public class CodeMsg {


    private int code;

    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(0, "success");

    /**
     *  100x 为数据库操作结果
     */
    public static CodeMsg COLL_EMPTY = new CodeMsg(1001, "查询结果为空!");

    /**
     * 500 为服务器异常
     */
    public static CodeMsg  SERVER_ERROR = new CodeMsg(500, "服务器异常!");

    /**
     * 200x 为登录异常
     */
    public static final CodeMsg BIND_ERROR = new CodeMsg(2001, "参数校验异常: %s") ;
    public static final CodeMsg MOBILE_NOT_EXIST = new CodeMsg(2002, "手机号码不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(2002, "密码错误");

    public CodeMsg fillMsg(Object...args) {
        int code = this.code;
        String msg = String.format(this.msg, args);
        return new CodeMsg(code, msg);
    }



    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
