package com.jack.algorithm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangta on 1/8/2018.
 */
public class concurrentExecutorService {
    public static void main(String[] args){
//      创建一个可缓存的线程池，调用execute将重用以前构造的线程（如果线程可用）。\
//      如果现有线程没有可用的，则创建一个新线   程并添加到池中。终止并从缓存中移除
//      那些已有 60 秒钟未被使用的线程
        ExecutorService executorService = Executors.newCachedThreadPool();
//      创建固定数目线程的线程池
//      ExecutorService executorService = Executors.newFixedThreadPool(5);
//      创建一个单线程化的Executor
//      ExecutorService executorService = Executors.newSingleThreadExecutor();
//      创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类
//      ExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++){
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
    }
}
class TestRunnable implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}
