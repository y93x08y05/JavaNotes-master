package com.jack.nowcoder.spring.MeiTuan.CodeM2018.third;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int max = 0;
        int [] arr = new int[256];
        for (int i=0;i<256;i++) {
            arr[i] = sc.nextInt();
        }
        if (m < n && arr[m] > arr[n]) {
            int temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
            max+=1;
        }
        for (int i=0;i<255;i++) {
            if (arr[i+1] - arr[i] == 1) {
                continue;
            } else {

            }
        }
    }
}