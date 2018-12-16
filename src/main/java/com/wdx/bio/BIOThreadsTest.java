package com.wdx.bio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO模型,使用多线程处理多个客户端请求
 *
 * 服务器端
 * 1、创建ServerSocket对象，绑定监听端口
 * 2、创建线程池
 * 3、通过accept()方法监听客户端请求
 * 4、建立连接后，启动新的线程，处理该客户端请求
 * 5、通过输入流读取客户端的请求信息
 * 6、通过输出流向客户端返回响应信息
 * 7、关闭相关资源
 *
 */
public class BIOThreadsTest {

    public static void main(String[] args) throws IOException {

        final ServerSocket serverSocket = new ServerSocket(12200);
        System.out.println("服务端启动成功，绑定12200端口");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        while (true) {

            final Socket socket = serverSocket.accept();
            System.out.println("服务器端监听到客户端请求....");


            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    BufferedReader br = null;
                    try {

                        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        String message;
                        while ((message = br.readLine()) != null) {
                            System.out.println(message);
                            if (message.equals("exit")) {
                                System.out.println("客户端退出连接！！！");
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("发生异常！" + e);
                    } finally {
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            });
        }

    }

}
