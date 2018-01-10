package com.czj.strategymodel;

import org.springframework.stereotype.Component;

/**
 * Created by caozhiia on 2018/1/10.
 */
@Component("Stragegy02")
public class Stragegy02 implements IStrategy{
    @Override
    public void startegy() {
        System.out.println("我是第二个策略");
    }
}
