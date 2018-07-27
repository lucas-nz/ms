package com.zhousz.ms.dao;

import com.zhousz.ms.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserDao {

    @Select("select * from sys_user")
    List<SysUser> getSysUserList();

}
