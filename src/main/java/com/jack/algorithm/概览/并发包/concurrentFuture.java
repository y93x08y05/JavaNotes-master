package com.jack.algorithm.概览.并发包;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zhangta on 1/8/2018.
 *任务分为实现了Runnable接口的类和实现了Callable接口的类
 * 均可被ExecutorService执行，但Runnable任务无返回值，而Callable任务有返回值
 * Callable的call()方法只能通过ExecutorService的submit(Callable<T> task) 方法来执行，
 * 并且返回一个 <T>Future<T>，是表示任务等待完成的 Future。
 * Callable中的call()方法类似Runnable的run()方法，区别同样是有返回值，后者没有。
 */
public class concurrentFuture {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();
        //创建10个任务并执行
        for (int i = 0; i < 10; i++){
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            resultList.add(future);
        }
        //遍历任务的结果
        for (Future<String> fs : resultList){
            try{
                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch(ExecutionException e){
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }
    }
}
class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，
     * 则该方法自动在一个线程上执行
     */
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        //该返回结果将被Future的get方法得到
        return "call()方法被自动调用，任务返回的结果是：" + id + "    " + Thread.currentThread().getName();
    }
}
