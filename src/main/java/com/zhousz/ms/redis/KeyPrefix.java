package com.zhousz.ms.redis;

public interface KeyPrefix {
    public int getExpireSeconds();
    public String getPrefix();
}
