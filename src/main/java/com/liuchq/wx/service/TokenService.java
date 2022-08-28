package com.liuchq.wx.service;

import com.liuchq.moxy.utils.MyUtils;
import com.liuchq.wx.bean.WxToken;
import com.liuchq.wx.bean.WxTokenReturn;
import com.liuchq.wx.dao.WxTokenMapper;
import com.liuchq.wx.utils.WxUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @description: tokenService
 * @author: liuchq
 * @create: 2022-08-28
 **/
@Service
public class TokenService {

    public static final Logger logger = LogManager.getLogger("TokenService");


    @Autowired
    private WxTokenMapper wxTokenMapper;
    /**
     * 获取微信token
     * @author: liuchq
     * @date: 2022/8/28
     * @param
     * @return: java.lang.String
     */
    @Transactional
    public String getWxToken(){
        String token = wxTokenMapper.getWxToken();
        if (token != null){
            logger.info("数据库获取的token:"+token);
            return token;
        }
        //数据库获取的token为空，就进行重新获取
        WxTokenReturn wxToken = WxUtils.getWxToken();
        if (wxToken.getAccess_token() != null){
            // 存入数据库并且返回
            WxToken data = new WxToken();
            data.setId(MyUtils.getUUid());
            data.setToken(wxToken.getAccess_token());
            data.setCreateDate(new Date());
            wxTokenMapper.insert(data);
            logger.info("存入数据库token:"+wxToken.getAccess_token());
            return wxToken.getAccess_token();
        }
        // 获取token失败
        String errMsg = wxToken.getErrcode()+wxToken.getErrmsg();
        logger.error("获取token失败:"+errMsg);
        return errMsg;
    }
}
