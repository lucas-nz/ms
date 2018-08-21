package com.zhousz.ms.service;

import com.zhousz.ms.domain.MsUser;
import com.zhousz.ms.vo.LoginVo;

public interface MsUserService {

    /**
     * 根据手机号, id 获得ms_user
     * @param id
     * @return
     */
    MsUser getMsUserById(Long id);

    Boolean login(LoginVo loginVo);


}
