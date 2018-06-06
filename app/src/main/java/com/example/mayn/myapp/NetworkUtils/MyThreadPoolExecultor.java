package com.example.mayn.myapp.NetworkUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by mayn on 2018/5/17.
 *
 * 线程池工具类
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * corePoolSize，线程池里最小线程数
 * maximumPoolSize，线程池里最大线程数量，超过最大线程时候会使用RejectedExecutionHandler
 * keepAliveTime，unit，线程最大的存活时间
 * workerQueue，缓存异步任务的队列
 * threadFactory，用来构造线程池里的worker线程
 *
 */

public class MyThreadPoolExecultor {
    static ThreadPoolExecutor mThreadPoolExecutor ;
    public static MyThreadPoolExecultor myThreadPoolExecultor=null;

    public static synchronized MyThreadPoolExecultor getMyThreadPoolExecultor() {
           if(myThreadPoolExecultor==null){
               myThreadPoolExecultor=new MyThreadPoolExecultor();
               mThreadPoolExecutor = new ThreadPoolExecutor(3,5,
                       60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(3));
           }
           return myThreadPoolExecultor;
    }

    //添加线程任务
    public void addTheadTask(Runnable runnable){
       mThreadPoolExecutor.execute(runnable);
   }

   //移除任务
    public void removeTask(Runnable runnable){
       mThreadPoolExecutor.remove(runnable);
    }
    //移除全部任务
    public void removeAllTask(){
        mThreadPoolExecutor.shutdownNow();
    }
}
