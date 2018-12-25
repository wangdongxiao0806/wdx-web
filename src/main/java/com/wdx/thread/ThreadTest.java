package com.wdx.thread;

public class ThreadTest {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        //当前主线程的状态为RUNNABLE
        System.out.println(Thread.currentThread().getName() +":" +Thread.currentThread().getState().name());
        Processor processor = new Processor();
        Thread thread =new Thread(processor);
        //创建的子线程开始时NEW状态
        System.out.println(thread.getName() +":" +thread.getState().name());
        thread.start();
        Thread.sleep(1000);
        //子线程调用了wait()方法后，状态为WAITING
        System.out.println(thread.getName() +":" +thread.getState().name());
        synchronized (obj) {
            obj.notify();
        }
        Thread.sleep(1000);
        //子线程结束后，变成TERMINATED
        System.out.println(thread.getName() +":" +thread.getState().name());
        Thread.sleep(10000000);
    }

    public static class Processor implements Runnable {
        @Override
        public void run () {
            //子线程调用start()后，状态为RUNNABLE
            System.out.println(Thread.currentThread().getName() +":" +Thread.currentThread().getState().name());

            synchronized (obj) {
                try {
                    obj.wait();
                    //main线程调用了notify()后，线程状态变为RUNNABLE
                    System.out.println(Thread.currentThread().getName() +":" +Thread.currentThread().getState().name());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
