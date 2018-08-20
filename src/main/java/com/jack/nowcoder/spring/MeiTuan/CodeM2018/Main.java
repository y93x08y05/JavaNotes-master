package com.jack.nowcoder.spring.MeiTuan.CodeM2018;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int max = 0;
        for (int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        for (int j=0;j<n;j++) {
            b[j] = sc.nextInt();
        }
        for (int i=0;i<a.length;i++) {
            boolean is1 = false;
            if (a[i] == 1) {
                if (i != 1) is1 = true;
                for (int j=0;j<b.length;j++) {
                    if (b[j] == 1) {
                        if (is1) {
                            if (j == 0) {
                                max += i;
                            } else {
                                max += i+j;
                            }
                            b[j] = 0;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}