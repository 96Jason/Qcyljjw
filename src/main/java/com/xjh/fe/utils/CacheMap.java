package com.xjh.fe.utils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by XuJinghui on 2020/2/22.
 * 用于缓存手机验证码
 */
public class CacheMap extends ConcurrentHashMap<String,String> {

    @Override
    public String put(String key, String value) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                CacheMap.super.remove(key);
            }
        }, 120000);//两分钟后执行
        return super.put(key, value);
    }
}
