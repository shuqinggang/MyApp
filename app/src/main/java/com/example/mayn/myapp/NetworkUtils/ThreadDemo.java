package com.example.mayn.myapp.NetworkUtils;

import android.util.Log;

/**
 * Created by shuqinggang on 2018/6/22.
 * 实现Runnable接口相比继承Thread类有如下好处：
 *1、避免继承的局限，一个类可以继承多个接口。
 *2、适合于资源的共享。
 * synchronized 放在普通方法上，内置锁就是当前类的实例。
 * synchronized 放在静态方法上，内置锁就是当前类的Class字节码对象
 *如果一个代码块被synchronized修饰了，当一个线程获取了对应的锁，并执行该代码块时，其他线程便只能一直等待，等待获取锁的线程释放锁。这种特性又被称为互斥锁
*而这里获取锁的线程释放锁只会有两种情况：
 *1）获取锁的线程执行完了该代码块，然后线程释放对锁的占有。
 *2）线程执行发生异常，此时JVM会让线程自动释放锁。
 */

public class ThreadDemo {

    class MyThread extends Thread{
        public MyThread(String name){
            super(name);
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                Log.e(Thread.currentThread().getName(),"第"+i+"次打印");
            }
        }
    }
    class MyRunnable implements Runnable{

        int TotalNumber=20;
        @Override
        public synchronized void run() {
            for(int i=0;i<50;i++){
                Log.e(Thread.currentThread().getName(),"第"+i+"次购买");
            }
        }
    }

    public void test(){
        MyRunnable myRunnable1=new MyRunnable();
        MyRunnable myRunnable2=new MyRunnable();
        MyRunnable myRunnable3=new MyRunnable();
        Thread thread1=new Thread(myRunnable1,"第一个窗口");
        Thread thread2=new Thread(myRunnable2,"第二个窗口");
        Thread thread3=new Thread(myRunnable3,                                                                                                                                                                                                                    "第三个窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
