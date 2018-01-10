package com.czj.proxymodel.args;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by caozhiia on 2018/1/9.
 */

@Component
public class ArgsWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new ArgsInterceptor());
    }
}
