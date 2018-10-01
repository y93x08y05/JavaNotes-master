package com.jack.nowcoder.autumn.VMware.VM20180930;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 8:53
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []arr1=new int[n];
        int []arr2=new int[n];
        for (int i=0;i<n;i++) {
            arr1[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++) {
            arr2[i]=sc.nextInt();
        }
        System.out.println(find(arr1, arr2, m));
    }
    private static int find(int []arr1,int []arr2,int m) {
        int []temp=new int[arr1.length+1];
        int [][]dp=new int[m][temp.length];
//        for (int i=0;i<)
        return 0;
    }
}