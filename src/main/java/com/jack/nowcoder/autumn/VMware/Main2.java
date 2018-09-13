package com.jack.nowcoder.autumn.VMware;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/13 18:28
 * 给定一个1到N的排列A1到AN，每次可以交换相邻两个数，
 * 那么至少要交换多少次才能使排列有序（从小到大或从大到小）？
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 * 第二行包含N个以空格隔开的整数A1到AN。
 * 输出
 * 输出最少交换次数。
 * 样例输入
 * 5
 * 3 1 5 2 4
 * 样例输出
 * 4
 */
public class Main2 {
    public static int count =0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        findMinSwap(arr,arr.length);
        System.out.println(count);
    }
    private static void findMinSwap(int []arr,int n) {
        int length=1;
        int []temp=new int[n];
        while (length<n) {
            findMinSwap(arr,temp,n,length);
            length*=2;
            findMinSwap(temp,arr,n,length);
            length*=2;
        }
    }
    private static void findMinSwap(int []arr,int []temp,int n,int length) {
        int i;
        for (i=0;i<=n-2*length;i+=2*length)
            findMinSwap(arr,temp,i,i+length,i+2*length-1);
        if (i+length<n)
            findMinSwap(arr,temp,i,i+length,n-1);
        else {
            for (int j=i;j<n;j++)
                temp[j]=arr[j];
        }
    }
    private static void findMinSwap(int []arr,int []temp,int left1,int right1,int right2) {
        int left2=right1-1;
        int start=left1;
        while (left1<=left2&&right1<=right2) {
            if (arr[left1]>arr[right1]) {
                temp[start++]=arr[right1++];
                count +=(left2-left1+1);
            } else
                temp[start++]=arr[left1++];
        }
        while (left1<=left2)
            temp[start++]=arr[left1++];
        while (right1<=right2)
            temp[start++]=arr[right1++];
    }
}