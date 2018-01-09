package com.czj.proxymodel.staticproxy;

/**
 * Created by caozhiia on 2018/1/8.
 */

import com.czj.proxymodel.noproxy.IKiller;
import com.czj.proxymodel.noproxy.Killer;

/**
 * 但是想杀人者想想这样做好像不太妥当，不安全，不想暴露了自己。所以想找个杀手来代替我来做这件事。
 * 那么用代理的方式该如何体现呢？
 * 首先是静态代理：
 * 1.代理者和被代理者都要实现一个公共的接口。也就是IKiller接口。接口里有一个待实现的杀人方法。
 * 2.在代理类中注入被代理对象
 *
 * 疑问：可能代码看起来并没有什么难度，但是接下里我们考虑这个问题，这个KillerProxy代理类只能做杀人
 * 的代理，并不能完成其他事情的代理，也就是他只能代理杀人。如果有别人想做别的事想找代理人去完成，就
 * 得重新创建一个代理，这样做是不是有些麻烦。那么，我就会想，如果我能有一个万能代理，什么都可以做
 * 那该有多好，这里就出现了动态代理。那么，首先先看jdk动态代理是如何完成的。
 */
public class KillerProxy implements IKiller{
    private IKiller killer;

    public KillerProxy(IKiller killer) {
        this.killer = killer;
    }

    @Override
    public void kill(String name) {
        System.out.println("我是代理杀手");
        killer.kill(name);
    }

    @Override
    public void save(String name, String who) {

    }

    public static void main(String[] args) {
        KillerProxy killerProxy = new KillerProxy(new Killer());
        killerProxy.kill("法西斯");
    }
}
