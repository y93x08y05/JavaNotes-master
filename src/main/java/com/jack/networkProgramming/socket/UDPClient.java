package com.jack.networkProgramming.socket;

import java.io.IOException;
import java.net.*;

/**
 * @Author: Jack
 * @Date: 2018/9/22 0:20
 */
public class UDPClient {
    public static void main(String[] args) {
        new Thread(() -> {
            byte []arr="Hello Server".getBytes();
            try {
                InetAddress address=InetAddress.getLocalHost();
                DatagramSocket datagramSocket=new DatagramSocket();
                DatagramPacket datagramPacket=new DatagramPacket(arr,arr.length,address,1234);
                datagramSocket.send(datagramPacket);
                System.out.println("send end");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}