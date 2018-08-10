package com.zhousz.ms.redis;

public class SysUserKey extends BasePrefix{

    private SysUserKey(String prefix) {
        super(prefix);
    }

    public static SysUserKey getListPrefix = new SysUserKey("SYSUSERLIST");
    public static SysUserKey getById = new SysUserKey("id");
    public static SysUserKey getByName = new SysUserKey("name");

}
