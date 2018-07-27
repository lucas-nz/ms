package com.zhousz.ms.result;

public class CodeMsg {

    private int code;

    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(0, "success");

    /**
     *  100x 为数据库操作结果
     */
    public static CodeMsg LIST_EMPTY = new CodeMsg(1001, "查询结果为空!");

    public static CodeMsg  SERVER_ERROR = new CodeMsg(500, "服务器异常!");

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
