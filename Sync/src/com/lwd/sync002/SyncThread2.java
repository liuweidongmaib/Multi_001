package com.lwd.sync002;

/**
 *  类锁
 */
public class SyncThread2 {

    public synchronized void printNum(String name){

        if("a".equals(name)){
            try {
                System.out.println("a执行完成");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("b执行完成");
        }

    }

    public static void main(String[] args) {
        //两个不同对象
       final SyncThread2 syncThread1 = new SyncThread2();
       final SyncThread2 syncThread2 = new SyncThread2();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a开始执行");
                syncThread1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("b开始执行");
                syncThread2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}
