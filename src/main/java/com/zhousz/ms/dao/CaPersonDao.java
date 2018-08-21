package com.zhousz.ms.dao;

import com.zhousz.ms.domain.CaPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CaPersonDao {

    @Select("select * from ca_person")
    List<CaPerson> getAllCaPerson();
}
