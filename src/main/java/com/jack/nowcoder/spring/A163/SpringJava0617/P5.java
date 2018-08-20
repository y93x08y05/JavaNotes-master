package com.jack.nowcoder.spring.A163.SpringJava0617;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr1 = new int[n][2];
        int [] arr2 = new int[m];
        for (int i=0;i<arr1.length;i++) {
            arr1[i][0] = sc.nextInt();
            arr1[i][1] = sc.nextInt();
        }
        for (int i=0;i<m;i++) {
            int max = 0;
            int temp = sc.nextInt();
            for (int j=0;j<n;j++) {
                if (temp >= arr1[j][0]) {
                    max = max > arr1[j][1] ? max : arr1[j][1];
                }
            }
            System.out.println(max);
        }
    }
}