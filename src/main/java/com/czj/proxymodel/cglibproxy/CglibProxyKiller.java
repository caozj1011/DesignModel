package com.czj.proxymodel.cglibproxy;

import com.czj.proxymodel.noproxy.IKiller;
import com.czj.proxymodel.noproxy.Killer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by caozhiia on 2018/1/9.
 */
@Component
public class CglibProxyKiller implements MethodInterceptor{
    @Autowired
    private Killer Killer;

    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = methodProxy.invokeSuper(o, objects);

        return result;
    }
}
