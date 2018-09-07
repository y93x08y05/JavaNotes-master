package com.jack.nowcoder.autumn.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 16:33
 * 华老师的n个学生参加了一次模拟测验，考出来的分数很糟糕，
 * 但是华老师可以将成绩修改为[0,100]中的任意值，
 * 所以他想知道，如果要使所有人的成绩的平均分不少于X分，
 * 至少要改动多少个人的分数？
 * 输入
 * 第一行一个数T，共T组数据（T≤10）
 * 接下来对于每组数据：
 * 第一行两个整数n和X。（1≤n≤1000, 0≤X≤100）
 * 第二行n个整数，第i个数Ai表示第i个学生的成绩。（0≤Ai≤100）
 * 输出
 * 共T行，每行一个整数，代表最少的人数。
 * 样例输入
 * 2
 * 5 60
 * 59 20 30 90 100
 * 5 60
 * 59 20 10 10 100
 * 样例输出
 * 1
 * 2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);;
        int T=sc.nextInt();
        for (int i=0;i<T;i++) {
            int n=sc.nextInt();
            int X=sc.nextInt();
            int []arr=new int[n];
            for (int j=0;j<n;j++) {
                arr[j]=sc.nextInt();
            }
            System.out.println(findStudentCount(arr, X));
        }
    }
    private static int findStudentCount(int []arr,int X) {
        Arrays.sort(arr);
        int res=0;
        int sum=Arrays.stream(arr).sum();
        if (sum/arr.length>=X)
            return res;
        else {
            for (int i=0;i<arr.length;i++) {
                if ((sum+100-arr[i])/arr.length>=X) {
                    return i+1;
                } else {
                    sum+=(100-arr[i]);
                }
            }
        }
        return res;
    }
}