package com.hotel.management.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class HttpLoggingInterceptor implements HandlerInterceptor {
    private static final String REQUEST_URL = "Request URL: ";
    private static final String START_TIME = "startTime";

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("********** HttpInterceptor.preHandle **********");
        log.info(
                "{}{}",
                REQUEST_URL + request.getRequestURL(),
                (StringUtils.isBlank(request.getQueryString())
                        ? ""
                        : "?" + request.getQueryString()));
        log.info("Start Time: {}", startTime);
        request.setAttribute(START_TIME, startTime);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception {
        log.info("********** HttpInterceptor.postHandle **********");
        log.info(
                "{}{}",
                REQUEST_URL + request.getRequestURL(),
                StringUtils.isBlank(request.getQueryString())
                        ? ""
                        : "?" + request.getQueryString());
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("********** HttpInterceptor.afterCompletion ********** ");
        long startTime = (Long) request.getAttribute(START_TIME);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        log.info(
                "{}{}",
                REQUEST_URL + request.getRequestURL(),
                StringUtils.isBlank(request.getQueryString())
                        ? ""
                        : "?" + request.getQueryString());
        log.info("Response Status: {}", response.getStatus());
        log.info("End Time: {}", endTime);
        log.info("Time Taken: {}", timeTaken);
    }
}
