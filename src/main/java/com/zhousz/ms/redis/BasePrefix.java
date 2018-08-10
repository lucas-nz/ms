package com.zhousz.ms.redis;

public abstract class BasePrefix implements KeyPrefix{

    private int expireSeconds;

    private String prefix;

    public BasePrefix(String prefix) {
        this.expireSeconds = 0; //0代表永不过期
        this.prefix = prefix;
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    public String getPrefix(){
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }

    public int getExpireSeconds(){
        return expireSeconds;
    }




}
