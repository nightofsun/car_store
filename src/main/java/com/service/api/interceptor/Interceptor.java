package com.service.api.interceptor;

import com.service.api.constant.CommonConstant;
import com.service.api.model.rest.BaseRequest;


import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class Interceptor extends InterceptorRegistry implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Date startDate = new Date();
        BaseRequest userDetailRequest = new BaseRequest();
        userDetailRequest.setRequestDate(startDate);
        userDetailRequest.setRequestURI(request.getRequestURI());
        userDetailRequest.setBodyData(IOUtils.toString(request.getReader()));
        request.setAttribute(CommonConstant.APPLICATION_REQUEST_DETAIL,userDetailRequest);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
