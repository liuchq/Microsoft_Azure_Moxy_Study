package com.liuchq.moxy.service;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description:
 * @author: liuchq
 * @create: 2021-05-17
 **/
public interface SettingService {
    /**
     * 管理员登录
     * @author: liuchq
     * @date: 2021/5/17 22:03
     * @param account
     * @param psw
     * @return: java.lang.Boolean
     * @throws Exception
     */
    boolean adminLogin(String account,String psw) throws Exception;
}
