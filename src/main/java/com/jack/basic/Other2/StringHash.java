package com.jack.basic.Other2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class StringHash {
    public static void main(String [] args){
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String localName = ip.getHostName();
            String localIp = ip.getHostAddress();
            System.out.println("本机名" + localName);
            System.out.println("本机地址" + localIp);
        } catch (UnknownHostException e) {
                e.printStackTrace();
        }
        String str = "abc";
        String s = new String("abc");
        System.out.println(str.equals(s));
        System.out.println(s.hashCode());
        System.out.println(s.charAt(0));
        System.out.println(s.isEmpty());
        System.out.println(s.length());
        System.out.println(s.compareTo("ABC"));
        System.out.println(s.split("3"));
        System.out.println(s.codePointAt(1));
        System.out.println(s.codePointCount(1, 2));
        System.out.println(s.compareToIgnoreCase("ABC"));
        System.out.println(s.contains("a"));
        System.out.println(s.getBytes());
        System.out.println(s.toCharArray());
        System.out.println(s.toUpperCase());
        System.out.println(s.trim());
        System.out.println(s.getClass());
        System.out.println(s.startsWith("a", 0));
    }
}