package com.liuchq.Moxy.controller;

import com.liuchq.Moxy.bean.WxCheckData;
import com.liuchq.Moxy.utils.SystemConfigUtils;
import com.liuchq.Moxy.utils.WxUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @description: 微信消息
 * @author: liuchq
 * @create: 2022-08-27
 **/
@RequestMapping(value = "/WxMessage")
@Controller
public class WxMessageController {

    public static final Logger logger = LogManager.getLogger("WxMessageController");

    @RequestMapping(value = "/checkWxData",method = RequestMethod.GET)
    public @ResponseBody String checkWxData(String signature, String timestamp, String nonce, String echostr){
        String result = null;
        try {
            WxCheckData data = new WxCheckData(signature,timestamp,nonce,echostr);
            logger.info("请求参数："+data.toString());
            String token = SystemConfigUtils.getWxConfigParam("wx.token");
            //校验
            if (WxUtils.wxCheckSignature(token,timestamp,nonce,signature)){
                result = echostr;
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return result;
    }
}
