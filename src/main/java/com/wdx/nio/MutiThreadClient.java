package com.wdx.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class MutiThreadClient {


    private static int THREAD_COUNT = 20;

    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

    public static void main(String[] args) throws InterruptedException {



        for(int i = 0; i < THREAD_COUNT ; i++){
            ClientThread clientThread = new ClientThread();
            new Thread(clientThread).start();
            countDownLatch.countDown();
        }

    }

    static class ClientThread implements Runnable{

        @Override
        public void run() {
            try {
                countDownLatch.await();
                Socket socket = new Socket("localhost",12200);
                Thread.sleep(60*60*1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
