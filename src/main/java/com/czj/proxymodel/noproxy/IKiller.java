package com.czj.proxymodel.noproxy;

import org.springframework.stereotype.Component;

/**
 * Created by caozhiia on 2018/1/8.
 */
public interface IKiller {
    void kill(String name);
    void save(String name,String who);
}
