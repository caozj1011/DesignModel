//package com.czj.proxymodel.jdkproxy;
//
///**
// * Created by caozhiia on 2018/1/8.
// */
//
//import com.czj.proxymodel.noproxy.IKiller;
//import com.czj.proxymodel.noproxy.Killer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
///**
// *
// */
//@Component("jdkKiller")
//public class JdkKillerProxy implements InvocationHandler{
//    @Autowired
//    private IKiller killer;
//
//    public JdkKillerProxy() {
//    }
//
//    public JdkKillerProxy(IKiller killer) {
//        this.killer = killer;

//    }
//
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("我是动态代理杀手");
//        for (Object arg:args) {
//            String s = (String) arg;
//            System.out.println(s+"======");
//        }
//        return method.invoke(killer,args);
//    }
//    // b
//    public static void main(String[] args) {
//        JdkKillerProxy jdkKillerProxy = new JdkKillerProxy(new Killer());
//        IKiller iKiller = (IKiller) Proxy.newProxyInstance(new Killer().getClass().getClassLoader(), new Killer().getClass().getInterfaces(), jdkKillerProxy);
//        iKiller.kill("法西斯");
//
//    }
//}
