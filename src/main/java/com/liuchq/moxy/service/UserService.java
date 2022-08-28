package com.liuchq.moxy.service;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description:
 * @author: liuchq
 * @create: 2021-05-17
 **/
public interface UserService {
    /**
     * 登录校验
     * @param userAccount
     * @param userPsw
     * @return
     * @throws Exception
     */
    boolean userLogin(String userAccount,String userPsw) throws Exception;
}
