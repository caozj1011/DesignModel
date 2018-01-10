package com.czj.controller;

import com.czj.strategymodel.UseStragegyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caozhiia on 2018/1/10.
 */
@RestController
public class StragegyController {
    @Autowired
    private UseStragegyService useStragegyService;

    @RequestMapping("/stragegy")
    public String stragegy(){
        useStragegyService.stragegy();
        return "aaa";
    }
}
