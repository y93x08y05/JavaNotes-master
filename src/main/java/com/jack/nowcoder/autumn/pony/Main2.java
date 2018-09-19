package com.jack.nowcoder.autumn.pony;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/19 21:27
 * 将小写字母转换为大写字母，将大写字母转换为小写字母
 * 如果是数字则保持不变
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(transfer(s));
    }
    private static String transfer(String s) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if (Character.isLowerCase(c)) {
                c=Character.toUpperCase(c);
            } else if (Character.isUpperCase(c)){
                c=Character.toLowerCase(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}