package com.zhousz.ms.service.impl;

import com.zhousz.ms.dao.CaPersonDao;
import com.zhousz.ms.domain.CaPerson;
import com.zhousz.ms.service.CaPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaPersonServiceImpl implements CaPersonService {

    @Autowired
    private CaPersonDao caPersonDao;

    public List<CaPerson> getAllCaPerson() {
        return caPersonDao.getAllCaPerson();
    }
}
