package com.liuchq.wx.utils;

import com.liuchq.wx.bean.WxTokenReturn;
import com.liuchq.wx.constant.WxConstants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Locale;

/**
 * @description: 微信接口工具类
 * @author: liuchq
 * @create: 2022-08-28
 **/
public class WxUtils {

    public static String getWxToken(){
        RestTemplate restTemplate = new RestTemplate();
        String url = SystemConfigUtils.getWxConfigParam(WxConstants.WXTOKENURL);
        WxTokenReturn tokenReturn = restTemplate.getForObject(url, WxTokenReturn.class);
        return "";
    }


    /**
     * 校验串
     * @author: liuchq
     * @date: 2022/8/28
     * @param token
     * @param timestamp
     * @param nonce
     * @return: boolean
     */
    public static boolean wxCheckSignature(String token,String timestamp,String nonce,String signature){
        String[] arr = new String[] { token, timestamp, nonce };
        Arrays.sort(arr);
        // 数组拼接字符串并且sha1加密
        byte[] bytes = DigestUtils.sha1(StringUtils.join(arr, ""));
        String tmpStr = byteToStr(bytes);
        return tmpStr.toLowerCase(Locale.ROOT).equals(signature);
    }

    /**
     * 将字节数组转换为十六进制字符
     * @author: liuchq
     * @date: 2022/8/28
     * @param byteArray
     * @return: java.lang.String
     */
    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符
     * @author: liuchq
     * @date: 2022/8/28
     * @param mByte
     * @return: java.lang.String
     */
    public static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
