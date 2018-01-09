package com.czj.proxymodel.noproxy;

/**
 * Created by caozhiia on 2018/1/8.
 */

import org.springframework.stereotype.Component;

/**
 * 这里引入了一个杀手的场景，某个人想要杀掉自己的仇人，在没有代理
 * 的情况下，他需要自己去杀掉那个人，所有的行动都得他自己去完成。
 * 注意：这个杀人动作是这个类（想杀人者）自己去完成的动作。
 */
@Component("killer")
public class Killer implements IKiller{

    @Override
    public void kill(String name){
        System.out.println("我拿着把水枪就把"+name+"给毙了！！");
    }

    @Override
    public void save(String name, String who) {
        System.out.println(name+"救了："+who);
    }

    public static void main(String[] args) {
        Killer killer = new Killer();
        killer.kill("法西斯");
    }
}

