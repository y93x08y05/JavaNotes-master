package com.jack.nowcoder.autumn.beijing360;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Jack on 8/27/2018 4:36 PM
 * [‎8/‎27/‎2018 9:16 PM]
 * 输入两个数n,m;(1<=n<=2000,1<=m<=100);分别表示n次看花，m表示一共有m朵花儿。
 * 接下来输入n个数a[1]~a[n]，a[i]表示第i次，小明看的花的种类;
 * 输入一个数Q(1<=Q<=1000000);表示小红的问题数量。
 * 输入Q行 每行两个数 l,r(1<=l<=r<=n); 表示小红想知道在第l次到第r次，小明一共看了多少不同的花儿。
 */
public class FlowerSum1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        int q=sc.nextInt();
        int [][]arr2=new int[q][2];
        for (int i=0;i<q;i++) {
            arr2[i][0]=sc.nextInt();
            arr2[i][1]=sc.nextInt();
        }
        findCount(arr,arr2);
    }
    private static void findCount(int []arr1,int [][]arr2) {
        if (arr1==null||arr2==null||arr1.length==0||arr2.length==0)
            return;
        for (int i=0;i<arr2.length;i++) {
            int n=arr2[i][0];
            int m=arr2[i][1];
            Set<Integer> set=new HashSet<>();
            for (int j=n-1;j<m-1;j++) {
                set.add(arr1[j]);
            }
            System.out.println(set.size());
        }
    }
}
