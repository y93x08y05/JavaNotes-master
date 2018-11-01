package com.jack.basic.Other1;

import java.util.Random;

/**
 * @Author: Jack
 * @Date: 2018/10/26 21:45
 */
public class 四位随机数 {
    public static void main(String[] args) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char c = str.charAt(new Random().nextInt(str.length()));
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}