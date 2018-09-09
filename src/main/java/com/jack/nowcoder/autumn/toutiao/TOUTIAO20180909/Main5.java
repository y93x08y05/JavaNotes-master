package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180909;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 9:52
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []arr=new int[m*2];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findDouYinHongRen(arr));
    }
    private static int findDouYinHongRen(int []arr) {
        return 1;
    }
}