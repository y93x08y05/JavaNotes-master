package com.jack.networkProgramming.socket;

/**
 * @Author: Jack
 * @Date: 2018/9/21 23:47
 */
public class HttpUtil {
    public static String []HOSTS={"www.baidu.com","www.qq.com"};
    public static int PORT=80;
    public static String compositeRequest(String host) {
        return "GET / HTTP/1.1\r\n" +
                "Host: " + host + "\r\n" +
                "User-Agent: curl/7.43.0\r\n" +
                "Accept: */*\r\n\r\n";
    }
}