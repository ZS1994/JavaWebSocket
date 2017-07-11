package com.zs.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.zs.actor.Centaur;
import com.zs.websocket.WebSocketTest;


public class Monitor implements Runnable {

	WebSocketTest webSocketTest = new WebSocketTest();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public void run() {
        webSocketTest.sendMsg("当前时间:" + sdf.format(new Date()));
    }

    public void sendMsg() {
//        ScheduledExecutorService newScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
//        newScheduledThreadPool.scheduleWithFixedDelay(new Monitor(), 20, 1, TimeUnit.SECONDS);
    }
}

