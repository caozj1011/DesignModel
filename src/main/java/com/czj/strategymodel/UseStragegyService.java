package com.czj.strategymodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by caozhiia on 2018/1/10.
 */
@Service
public class UseStragegyService {
    @Qualifier("Stragegy02")
    @Autowired
    private IStrategy strategy01;

    public void stragegy(){
        strategy01.startegy();
    }
}
