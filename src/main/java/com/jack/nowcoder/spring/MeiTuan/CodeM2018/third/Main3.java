package com.jack.nowcoder.spring.MeiTuan.CodeM2018.third;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l = s.length();
        double low = 0;
        int p = 0;
        boolean flag = false;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) == '1') {
                if (!flag) {
                    p = s.length()-i;
                    flag = true;
                }
                low += Math.pow(2,s.length()-i-1);
            }
        }
        int r = (int)low;
        if (l >= r) {
            System.out.println(0);
        } else {

        }
        System.out.println(p);
        System.out.println(r);
    }
//    public static int getLow(int r,int l) {
//        if (r)
//        for (int i=s.length()-1;i>=0;i--) {
//            if (s.charAt(i) == '1') {
//                if (!flag) {
//                    p = s.length()-i;
//                    flag = true;
//                }
//                low += Math.pow(2,s.length()-i-1);
//            }
//        }
//    }
}