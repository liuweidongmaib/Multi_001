package com.lwd.sync001;

public class SyncThread extends Thread{
    /**
     *  成员变量
     */
    private int count = 5;
    /**
     *  多线程对同一个任务对象操作的时候
     *   count--  非原子性操作  count -- 操作  是先读 在写   多线程操作的时候  每个线程会读取当前成员变量count的5 拷贝到各自的工作空间
     *   当操作的时候并不会去操作共享空间数据  各自操作工作空间数据  各个线程之间的操作是互不干扰的
     *
     *   解决这个问题方案  加锁  synchronized
     *    多线程在调用run 方法的时候 多线程会采用抢占试 获取当前run 方法上的锁 这时候只有一个线程会获取到锁资源  其它线程会阻塞到队列中 顺序是根据
     *    cup 分配的顺序定的
     *
     *    多线程获取锁的方式：
     *    1 尝试获取锁
     *    2 当获取到锁后会执行 会执行方法内部的内容  执行完毕释放锁  如果没有获取到锁 那么多线程会不断尝试获取锁资源（存在锁竞争问题）
     *
     */
    @Override
    public synchronized void run() {

        //执行--操作
        count--;

        System.out.println(Thread.currentThread().getName()+"--------"+count);
    }


    public static void main(String[] args) {
        //一个任务对象
        SyncThread myThread = new SyncThread();
        //多个线程
        Thread t1 = new Thread(myThread,"t1");
        Thread t2 = new Thread(myThread,"t2");
        Thread t3 = new Thread(myThread,"t3");
        Thread t4 = new Thread(myThread,"t4");
        Thread t5 = new Thread(myThread,"t5");

        t1.start();
        System.out.println("d");
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
