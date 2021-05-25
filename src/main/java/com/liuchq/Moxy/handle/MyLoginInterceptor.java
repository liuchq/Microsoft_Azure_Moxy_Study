package com.liuchq.Moxy.handle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: liuchq
 * @date: 2021/5/21 16:11
 * @description: 登录拦截器
 */
public class MyLoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LogManager.getLogger("MyLoginInterceptor");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截器进行权限验证
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("userName");
        logger.info("登录权限拦截器验证开始===登录账户:"+obj);
        if (obj != null && ("admin".equals(obj.toString()) || "test".equals(obj.toString()))){
            //暂时只允许这两个用户登录
            return true;
        }else if (obj == null){
            request.getRequestDispatcher("/interceptorError.jsp").forward(request,response);
            return false;
        }else {
            response.addHeader("REDIRECT","REDIRECT");
            response.addHeader("CONTEXTPATH","../interceptorError.jsp");
            response.addHeader("Access-Control-Expose-Headers","REDIRECT,CONTEXTPATH");
            response.setStatus(401);

            return false;
        }
    }
}
