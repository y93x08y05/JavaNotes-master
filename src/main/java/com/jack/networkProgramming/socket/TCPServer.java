package com.jack.networkProgramming.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Jack
 * @Date: 2018/9/22 0:14
 */
public class TCPServer {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                ServerSocket serverSocket=new ServerSocket(1234);
                while (true) {
                    System.out.println("启动服务器.......");
                    Socket socket=serverSocket.accept();
                    System.out.println("客户端："+socket.getInetAddress().getHostAddress()+"已经连接到服务器");
                    BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg=br.readLine();
                    System.out.println("客户端："+msg);
                    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.write(msg+"\n");
                    bw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}