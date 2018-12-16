package com.wdx.bio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO模型
 *
 * 服务器端
 * 1、创建ServerSocket对象，绑定监听端口
 * 2、通过accept()方法监听客户端请求
 * 3、建立连接后，通过输入流读取客户端的请求信息
 * 4、通过输出流向客户端返回响应信息
 * 5、关闭相关资源
 *
 */
public class BIOTest {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(12200);
        System.out.println("服务端启动成功，绑定12200端口");

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("服务器端监听到客户端请求....");

            InputStream in = socket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String message;
            while ((message = br.readLine()) != null) {
                System.out.println(message);
                if (message.equals("exit")) {
                    System.out.println("客户端退出连接！！！");
                    in.close();
                    br.close();
                    socket.close();
                    break;
                }
            }
        }

    }

}
