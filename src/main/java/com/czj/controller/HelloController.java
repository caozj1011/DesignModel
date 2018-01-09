package com.czj.controller;

import com.czj.proxymodel.cglibproxy.CglibProxyKiller;
import com.czj.proxymodel.noproxy.IKiller;
import com.czj.proxymodel.noproxy.Killer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by caozhiia on 2018/1/8.
 */
@RestController
public class HelloController {
    @Autowired
    private CglibProxyKiller cglibProxyKiller;

    @Autowired
    private Killer killer;


    
    @RequestMapping("/hello")
    public String hello(){

//        getProxyClass(killer.getClass(),jdkKiller).kill("aaa");
//        System.out.println(cglibProxyKiller.getClass().getName());
//        System.out.println(killer.getClass().getName());
//        IKiller iKiller = (IKiller)Proxy.newProxyInstance(killer.getClass().getClassLoader(),killer.getClass().getInterfaces(),jdkKiller);
//        System.out.println(Proxy.newProxyInstance(killer.getClass().getClassLoader(),killer.getClass().getInterfaces(),jdkKiller).getClass().getName());
        Killer killer = cglibProxyKiller.getProxy(Killer.class);
        killer.kill("faxisi");
        killer.save("武松","宋江");
        return "sss";
    }
//    private IKiller getProxyClass(Class cls, JdkKillerProxy proxy) {
//        IKiller iKiller = (IKiller) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), proxy);
//        return iKiller;
//    }

}
