package com.liuchq.Moxy.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @description: 系统配置参数工具类
 * @author: liuchq
 * @create: 2022-08-28
 **/
public class SystemConfigUtils {

    /**
     * 获取wxConfig.properties配置内容
     * @author: liuchq
     * @date: 2022/8/28
     * @param paramName
     * @return: java.lang.String
     */
    public static String getWxConfigParam(String paramName){
        ResourceBundle bundle = ResourceBundle.getBundle("wxConfig", Locale.CHINA);
        return bundle.getString(paramName);
    }
}
