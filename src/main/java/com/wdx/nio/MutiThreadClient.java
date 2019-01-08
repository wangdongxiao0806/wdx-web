package com.wdx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
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
                SocketChannel client = SocketChannel.open();
                client.connect(new InetSocketAddress("127.0.0.1",12200));
                if(client.isConnected()){
                    System.out.println("client连接成功");
                }

                String msg = "我是"+Thread.currentThread().getName();
                client.write(ByteBuffer.wrap(msg.getBytes()));

                Thread.sleep(60*60*1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
