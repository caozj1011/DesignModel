package com.czj.strategymodel;

import org.springframework.stereotype.Component;

/**
 * Created by caozhiia on 2018/1/10.
 */
@Component("Stragegy03")
public class Stragegy03 implements IStrategy {
    @Override
    public void startegy() {
        System.out.println("我是第三个策略~~~");
    }
}
