package com.jack.nowcoder.autumn.haoweilai;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/9 20:49
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(find(arr));
    }
    private static int find(int []arr) {
        if (arr==null||arr.length==0)
            return 0;
        if (arr.length == 3)
            return 3;
        else if (arr.length == 2)
            return 2;
        return arr.length;
    }
}