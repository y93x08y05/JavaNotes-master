package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180909;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 9:48
 * UTF-8
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findIfIllegal(arr));
    }
    private static int findIfIllegal(int []arr) {
        int len=arr.length;
        int res=0;
        int i=0;
        while (i<len) {
            if (res>0) {
                if (arr[i]<192&&arr[i]>=128) {
                    res--;
                } else {
                    return 0;
                }
            } else if (arr[i]>=248) {
                return 0;
            } else if (arr[i]>=240) {
                res=3;
            } else if (arr[i]>=224) {
                res=2;
            } else if (arr[i]>=192) {
                res=1;
            } else if (arr[i]>=128) {
                return 0;
            }
            i++;
        }
        if (res==0)
            return 1;
        else
            return 0;
    }
}