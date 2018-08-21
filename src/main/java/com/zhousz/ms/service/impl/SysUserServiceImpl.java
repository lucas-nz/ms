package com.zhousz.ms.service.impl;

import com.zhousz.ms.dao.SysUserDao;
import com.zhousz.ms.domain.SysUser;
import com.zhousz.ms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    public List<SysUser> getSysUserList() {
        List<SysUser> sysUserList = sysUserDao.getSysUserList();
        return sysUserList;
    }
}
