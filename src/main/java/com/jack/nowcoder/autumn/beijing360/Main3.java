package com.jack.nowcoder.autumn.beijing360;

import java.util.Scanner;

/**
 * Created by Jack on 8/27/2018 8:19 PM
 * 即翻转第二个数组，然后求最长公共子序列问题
 * 小红有两个长度为n的排列A和B。每个排列由[1,n]数组成，且里面的数字都是不同的。
 * 现在要找到一个新的序列C，要求这个新序列中任意两个位置(i,j)满足:
 * 如果在A数组中C[i]这个数在C[j]的后面，那么在B数组中需要C[i]这个数在C[j]的前面。
 * 请问C序列的长度最长为多少呢？
 * 样例输入
 * 5
 * 1 2 4 3 5
 * 5 2 3 4 1
 * 样例输出
 * 2
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr1=new int[n];
        int []arr2=new int[n];
        for (int i=0;i<arr1.length;i++) {
            arr1[i]=sc.nextInt();
        }
        for (int i=0;i<arr2.length;i++) {
            arr2[i]=sc.nextInt();
        }
        System.out.println(findInt(arr1, arr2));
    }
    private static int findInt(int []arr1,int []arr2) {
        String s1=String.valueOf(arr1);
        String s2=String.valueOf(arr2);
        int sum=1;
        for (int i=0;i<arr1.length;i++) {
            int a1=s1.indexOf(String.valueOf(arr1[i]));
            int a2=s2.indexOf(String.valueOf(arr1[i]));
            for (int j=i+1;j<arr2.length;j++) {
                int a3=s1.indexOf(String.valueOf(arr2[j]));
                int a4=s2.indexOf(String.valueOf(arr2[j]));
                if ((a1<a3&&a2>a4)||(a1>a3&&a2<a4))
                  sum++;
            }
        }
        return sum;
    }
}
