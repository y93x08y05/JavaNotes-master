package com.jack.networkProgramming.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: Jack
 * @Date: 2018/9/22 0:09
 */
public class TCPClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket=new Socket("127.0.0.1",1234);
                InputStream in=socket.getInputStream();
                OutputStream out=socket.getOutputStream();
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
                bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
                bw.flush();
                BufferedReader br=new BufferedReader(new InputStreamReader(in));
                String msg=br.readLine();
                System.out.println("服务器："+msg);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}