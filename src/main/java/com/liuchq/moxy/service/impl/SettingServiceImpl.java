package com.liuchq.moxy.service.impl;

import com.liuchq.moxy.bean.Setting;
import com.liuchq.moxy.bean.SettingExample;
import com.liuchq.moxy.dao.SettingMapper;
import com.liuchq.moxy.service.SettingService;
import com.liuchq.moxy.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description: 系统设置参数
 * @author: liuchq
 * @create: 2021-05-17
 **/
@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    private SettingMapper settingMapper;


    /**
     * 管理员登录
     * @author: liuchq
     * @date: 2021/5/17 22:03
     * @param account
     * @param psw
     * @return: java.lang.Boolean
     */

    @Override
    public boolean adminLogin(String account, String psw) throws Exception {
        SettingExample settingExample = new SettingExample();
        settingExample.createCriteria().andSettingKeyEqualTo(account).andSettingValueEqualTo(EncryptUtils.aesEncrypt(psw,EncryptUtils.KEY));
        List<Setting> settings = settingMapper.selectByExample(settingExample);
        return settings.size() > 0?true:false;
    }
}
