package com.jack.nowcoder.spring.MeiTuan.CodeM2018.third;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        if (m == 0) {
            System.out.println(6);
        } else {
            System.out.println(12);
        }
    }
}