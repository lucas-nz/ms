package com.zhousz.ms.service.impl;

import com.zhousz.ms.dao.MsUserMapper;
import com.zhousz.ms.domain.MsUser;
import com.zhousz.ms.exception.GlobalException;
import com.zhousz.ms.service.MsUserService;
import com.zhousz.ms.util.CodeMsg;
import com.zhousz.ms.util.MD5Util;
import com.zhousz.ms.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsUserServiceImpl implements MsUserService {

    @Autowired
    private MsUserMapper msUserMapper;

    @Override
    public MsUser getMsUserById(Long id) {
        return msUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean login(LoginVo loginVo) {
        if (null == loginVo){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        // 判断手机号码是否存在
        MsUser user = msUserMapper.selectByPrimaryKey(Long.parseLong(mobile));
        if (null == user) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        // 验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String newPass = MD5Util.formPassToDB(password, dbSalt);
        if (!newPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        return true;
    }
}
