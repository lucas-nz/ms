package com.zhousz.ms.dao;

import com.zhousz.ms.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SysUserDao {

    @Select("select * from sys_user")
    List<SysUser> getSysUserList();

}
