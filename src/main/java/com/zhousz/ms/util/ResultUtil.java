package com.zhousz.ms.util;

public class ResultUtil<T> {

    private int code;

    private String msg;

    private T data;

    private ResultUtil(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private ResultUtil(CodeMsg codeMsg) {
        if (null == codeMsg) {
            return;
        }
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    /**
     * 成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> success(T data) {
        return new ResultUtil<T>(data);
    }

    /**
     * 失败时调用
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> error(CodeMsg codeMsg) {
        return  new ResultUtil<T>(codeMsg);
    }



    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}
