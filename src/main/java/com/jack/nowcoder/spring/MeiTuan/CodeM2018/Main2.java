package com.jack.nowcoder.spring.MeiTuan.CodeM2018;

import java.util.Scanner;

public class Main2 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[][] = new int[n-1][4];
        for (int i=0;i<array.length;i++) {
            for (int j=0;j<4;j++) {
                array[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int array1[][] = new int[m][2];
        for (int i=0;i<m;i++) {
            for (int j=0;j<m;j++) {
                array1[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<array1.length;i++) {
            int min = 0;
            int temp = 0;
            for (int j=0;j<array.length;j++) {
                if (array1[i][0] == array[j][0]) {
                    min+=array[j][2]*array[j][3];
                    temp = array[j][1];
                    break;
                }
            }
            if (temp == array1[i][1]) {
                System.out.println(min);
            }
        }
    }
}