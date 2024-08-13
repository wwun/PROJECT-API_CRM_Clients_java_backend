package com.william.crm.clients.crm_clients.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.william.crm.clients.crm_clients.controllers.HandlerExceptionController;;

@Component("loggerInterceptor")
public class LoggerInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        HandlerMethod interceptedMethod = ((HandlerMethod)handler);
        String methodName = interceptedMethod.getMethod().getName();

        logger.info("LoggerInterceptor: ["+methodName+"] started");

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception{
        long endTime = System.currentTimeMillis();
        HandlerMethod interceptedMethod = ((HandlerMethod)handler);
        String methodName = interceptedMethod.getMethod().getName();

        Object startTimeObj = request.getAttribute("startTime");
        if(startTimeObj==null)
            throw new NumberFormatException("startTime is missing");
        
        try{
            long startTime = (long)startTimeObj;
            logger.info("Executing ["+methodName+"] time: "+(endTime-startTime)+" "+"ms");
        }catch(NumberFormatException ex){
            throw ex;
        }

    }

}
