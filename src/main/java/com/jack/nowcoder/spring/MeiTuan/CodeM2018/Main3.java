package com.jack.nowcoder.spring.MeiTuan.CodeM2018;

import java.util.Scanner;

public class Main3 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        double a1 = sc.nextDouble();
        double a2 = sc.nextDouble();
        String s = sc.next();
        String s1 = String.valueOf(a1/a2);
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i) == '.') {
                s1 = s1.substring(i);
            }
        }
        for (int j=s.length()-1;j>0;j--) {
            if (s.charAt(j) != 0) {
                s = s.substring(0,j+1);
                break;
            }
        }
        if (s1.contains(s)) {
            for (int i=0;i<s1.length();i++) {
                if (s1.charAt(i) == s.charAt(0)) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}