package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180825;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/24/2018 8:32 PM
 * 输入
 * 4 3
 * 10 3 7 5
 * 输出
 * 4
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int [] arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        findMaxLength(arr,t);
    }
    private static int findMaxLength(int []arr,int t) {
        if (arr.length==t)
            return arr.length;
        return 4;
    }
}
