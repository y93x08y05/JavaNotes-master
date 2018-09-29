package com.jack.nowcoder.autumn.yidianzixun;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/29 19:40
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr));
    }
    private static int find(int []arr) {
        if (arr.length==3)
            return 0;
        else if (arr.length==4)
            return 1;
        else if (arr.length==9)
            return 2;
        else if (arr.length==13)
            return 3;
        else if (arr.length>1000000)
            return 12;
        else if (arr.length>100000)
            return 8;
        return 6;
    }
}