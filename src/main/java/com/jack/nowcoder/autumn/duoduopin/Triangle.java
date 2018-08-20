package com.jack.nowcoder.autumn.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/5/2018 11:18 AM
 * 给出平面上的n个点，现在需要求出，在这n个点里选3个点能够构成一个三角形的方案有几种
 * 输入描述：
 * 第一行包含一个正整数n，表示平面上有n个点(n<=100)
 * 第2行到第n+1行，每行有两个整数，表示这个点的x坐标和y坐标。
 * (所有坐标的绝对值<=100，且所有坐标都不相同)
 * 输出描述：输出一个数表示能够构成三角形的方案数
 * 输入例子：
 * 4
 * 0 0
 * 0 1
 * 1 0
 * 1 1
 * 输出例子：
 * 4
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][2];
        for (int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int result = 0;
        for (int i=0;i<n-2;i++) {
            for (int j=i+1;j<n-1;j++) {
               for (int k=j+1;k<n;k++) {
                    result += isTriangle(arr[i],arr[j],arr[k]);
               }
            }
        }
        System.out.println(result);
    }
    private static int isTriangle(int [] x,int [] y,int [] z) {
        if (x[0] == y[0] && x[0] == z[0] || x[1] == y[1] && x[1] == z[1] ||
                ((x[0]-y[0])*(x[1]-z[1]))==(x[1]-y[1])*(x[0]-z[0]))
            return 0;
        return 1;
    }
}
