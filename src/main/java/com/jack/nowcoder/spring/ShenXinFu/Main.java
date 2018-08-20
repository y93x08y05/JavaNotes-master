package com.jack.nowcoder.spring.ShenXinFu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        int [] arr1 = new int[n];
        int [] temp = new int[10];
//        boolean [] arr2 = new boolean[1000];
        for (int i=0;i<n;i++) {
            arr1[i] = sc.nextInt();
        }
//        for (int i=0;i<arr2.length;i++) {
//            arr2[i] = false;
//        }
        int m=0;
        for (int i=0;i<n;i++) {
            boolean flag = false;
            for (int j=0;j<10;j++) {
                if (arr1[i] == temp[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                num++;
                temp[m++] = arr1[i];
            }
            if (temp[9] != 0) {
                break;
            }
//            if (arr2[arr1[i]-1] == false) {
//                arr2[arr1[i]-1] = true;
//                num++;
//                temp[j++] = arr1[i];
//            } else {
//                continue;
//            }
        }
        System.out.println(num);
        for (int i=0;i<10;i++) {
            if (temp[i] != 0) {
                System.out.println(temp[i]);
            }
        }
    }
}
