package com.jack.nowcoder.autumn.weipinhui;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/15 18:58
 * N*N的矩阵中第K小的元素
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        int [][]arr=new int[n][n];
        int []arr1=new int[n*n];
        int q=0;
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[0].length;j++) {
                arr[i][j]=sc.nextInt();
                arr1[q++]=arr[i][j];
            }
        }
        Arrays.sort(arr1);
        System.out.println(arr1[k-1]);
        int a=k/n;
        int b=k%n;
        System.out.println(arr[a][b - 1]);
    }
}