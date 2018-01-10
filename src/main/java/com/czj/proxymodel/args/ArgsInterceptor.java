package com.czj.proxymodel.args;

import com.czj.proxymodel.cglibproxy.CglibProxyKiller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by caozhiia on 2018/1/9.
 */
@Slf4j
@Component
public class ArgsInterceptor extends HandlerInterceptorAdapter implements MethodInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("容器初始化开始~~~");

        Map<String, String[]> parameterMap = request.getParameterMap();
        Enumeration<String> parameterNames = request.getParameterNames();
        Set<String> strings = parameterMap.keySet();
        for (String key:strings
             ) {
            String[] strings1 = parameterMap.get(strings);
            for (int i = 0; i < strings1.length; i++) {
                System.out.println(strings1[i]+"================asdfasdfasdf");
            }
            System.out.println(parameterMap.get(key));
        }

        System.out.println("request.getRequestURL():"+request.getRequestURL());
        System.out.println("request.getContextPath():"+request.getContextPath());
        System.out.println("request.getParameterMap():"+request.getParameterMap());
        System.out.println("request.getParameterNames():"+request.getParameterNames());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("args:"+methodProxy.getSuperName()+"==============");

        for (Object o1:objects) {
            String logs = (String)o1;
            log.info("=================>"+logs);
        }
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}
