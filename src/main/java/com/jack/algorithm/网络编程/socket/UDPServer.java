package com.jack.algorithm.网络编程.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author: Jack
 * @Date: 2018/9/22 0:24
 */
public class UDPServer {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                DatagramSocket datagramSocket=new DatagramSocket(1234);
                byte []buffer=new byte[1024];
                DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);
                datagramSocket.receive(datagramPacket);
                System.out.println("server recv");
                String msg=new String(datagramPacket.getData(),"utf-8");
                System.out.println(msg);
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}