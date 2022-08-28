package com.liuchq.moxy.service.impl;

import com.liuchq.moxy.bean.User;
import com.liuchq.moxy.bean.UserExample;
import com.liuchq.moxy.dao.UserMapper;
import com.liuchq.moxy.exception.UserException;
import com.liuchq.moxy.service.SettingService;
import com.liuchq.moxy.service.UserService;
import com.liuchq.moxy.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description: 用户操作
 * @author: liuchq
 * @create: 2021-05-17
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SettingService settingService;

    /**
     * 登录校验
     * @param userAccount
     * @param userPsw
     * @return
     * @throws Exception
     */
    @Override
    public boolean userLogin(String userAccount, String userPsw) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserAccountEqualTo(userAccount);
        //超级管理员的话，走超级管理员的校验
        if ("admin".equals(userAccount)){
            return settingService.adminLogin(userAccount,userPsw);
        }
        //普通用户
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0){
            try{
                String s = EncryptUtils.aesDecrypt(users.get(0).getUserPassword(), EncryptUtils.KEY);
                if (s.equals(userPsw)){
                    return true;
                }
            }catch (Exception e){
                throw new UserException("解析用户密码错误",e);
            }
        }
        return false;
    }
}
