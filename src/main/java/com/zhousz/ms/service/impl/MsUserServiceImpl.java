package com.zhousz.ms.service.impl;

import com.zhousz.ms.dao.MsUserDao;
import com.zhousz.ms.domain.MsUser;
import com.zhousz.ms.service.MsUserService;
import com.zhousz.ms.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsUserServiceImpl implements MsUserService {

    @Autowired
    private MsUserDao msUserDao;

    @Override
    public MsUser getMsUserById(Long id) {
        return msUserDao.getMsUserById(id);
    }

    @Override
    public Boolean login(LoginVo loginVo) {
        if (null == loginVo){

        }
        return true;
    }
}
