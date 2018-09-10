package com.jack.nowcoder.autumn.BaiXin;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/10 21:01
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        if (s1.contains(s2)) {
            System.out.println(s1.indexOf(s2));
        } else {
            System.out.println(-1);
        }
    }
}