package com.zhousz.ms.redis;

public class CaPersonKey extends BasePrefix {

    private CaPersonKey(String prefix) {
        super(prefix);
    }

    public static CaPersonKey getListPrefix = new CaPersonKey("CAPERSONLIST");
}
