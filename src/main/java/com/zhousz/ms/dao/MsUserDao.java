package com.zhousz.ms.dao;

import com.zhousz.ms.domain.MsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MsUserDao {

    @Select("select * from ms_user where id = #{id}")
    MsUser getMsUserById(@Param("id")Long id);
}
