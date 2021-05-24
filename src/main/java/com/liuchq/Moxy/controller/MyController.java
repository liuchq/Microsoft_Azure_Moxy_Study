package com.liuchq.Moxy.controller;

import com.liuchq.Moxy.service.SettingService;
import com.liuchq.Moxy.service.StudyService;
import com.liuchq.Moxy.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description: 控制层
 * @author: liuchq
 * @create: 2021-05-16
 **/
@RequestMapping(value = "/user")
@Controller
public class MyController {

    public static final Logger logger = LogManager.getLogger("MyController");

    @Autowired
    private UserService userService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private StudyService studyService;

    @RequestMapping(value = "/userLogin.do",method = RequestMethod.POST)
    public ModelAndView userLogin(String userAccount, String userPsw, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginError");
        String log = "用户:"+userAccount+"登录，且登录失败";
        try {
            boolean login = userService.userLogin(userAccount, userPsw);
            if (login){
                mav.setViewName("courseDetail");
                request.getSession().setAttribute("userAccount",userAccount);
                log = log.replace("失败","成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        logger.info(log);
        return mav;
    }

    @RequestMapping(value = "/studyDemo.do",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String studyDemo(HttpSession session) {
        //登录的用户
        Object userAccount = session.getAttribute("userAccount");
        studyService.startStudy(String.valueOf(userAccount));
        return "后台已经开始刷课";
    }

    @RequestMapping(value = "/test2.do",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String test2(HttpSession session) {
        //test2
        return "test2";
    }
}
