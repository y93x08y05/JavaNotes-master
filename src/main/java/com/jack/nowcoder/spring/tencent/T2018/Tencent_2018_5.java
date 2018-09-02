package com.jack.nowcoder.spring.tencent.T2018;

import java.util.Arrays;
import java.util.Scanner;

public class Tencent_2018_5 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] times = new int[n];
        int [] levels = new int[n];
        int [] ts = new int[m];
        int [] ls = new int[m];
        for (int i=0;i<n;i++){
            times[i] = sc.nextInt();
            levels[i] = sc.nextInt();
        }
        Arrays.sort(times);
        for (int i=0;i<m;i++){
            ts[i] = sc.nextInt();
            ls[i] = sc.nextInt();
        }
        Arrays.sort(ts);
        if (times[n-1] > ts[m-1]){
            System.out.println(0+ " " + 0);
        }
    }
}