package com.jack.algorithm.网络编程.socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Jack
 * @Date: 2018/9/21 23:56
 * 启动的线程数：CPU密集型为N+1，IO密集型为2N+1。N为CPU核数
 */
public class Application {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (String host : HttpUtil.HOSTS) {
            Thread thread = new Thread(() -> new SocketHttpClient().start(host, HttpUtil.PORT));
            service.submit(thread);
            new SocketHttpClient().start(host, HttpUtil.PORT);
        }
    }
}