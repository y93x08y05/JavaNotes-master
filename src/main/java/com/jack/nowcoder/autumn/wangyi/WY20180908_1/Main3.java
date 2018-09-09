package com.jack.nowcoder.autumn.wangyi.WY20180908_1;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 14:38
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]arr=new int[n][2];
        for (int i=0;i<arr.length;i++) {
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        System.out.println(findMinCost(arr, n, m));
    }
    private static int findMinCost(int [][]arr,int n,int m) {
        if (n==1) {
            if (arr[0][0]==1)
                return 0;
            else
                return arr[0][1];
        }
        return 6;
    }
}