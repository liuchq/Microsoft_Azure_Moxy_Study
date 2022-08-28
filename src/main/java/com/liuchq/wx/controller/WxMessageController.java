package com.liuchq.wx.controller;

import com.liuchq.wx.bean.WxCheckData;
import com.liuchq.wx.bean.WxTokenReturn;
import com.liuchq.wx.constant.WxConstants;
import com.liuchq.wx.service.TokenService;
import com.liuchq.wx.utils.SystemConfigUtils;
import com.liuchq.wx.utils.WxUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 微信消息
 * @author: liuchq
 * @create: 2022-08-27
 **/
@RequestMapping(value = "/WxMessage")
@Controller
public class WxMessageController {

    @Autowired
    private TokenService tokenService;

    public static final Logger logger = LogManager.getLogger("WxMessageController");

    @RequestMapping(value = "/checkWxData",method = RequestMethod.GET)
    public @ResponseBody String checkWxData(String signature, String timestamp, String nonce, String echostr){
        String result = null;
        try {
            WxCheckData data = new WxCheckData(signature,timestamp,nonce,echostr);
            logger.info("请求参数："+data.toString());
            String token = SystemConfigUtils.getWxConfigParam(WxConstants.WXTOKEN);
            //校验
            if (WxUtils.wxCheckSignature(token,timestamp,nonce,signature)){
                result = echostr;
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return result;
    }


    @RequestMapping(value = "/getWxToken",method = RequestMethod.GET)
    public @ResponseBody String getWxToken(){
        try {
            return tokenService.getWxToken();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return "";
    }
}
