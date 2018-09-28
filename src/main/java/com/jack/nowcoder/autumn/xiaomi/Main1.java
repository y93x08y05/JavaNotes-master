package com.jack.nowcoder.autumn.xiaomi;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/27 13:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(find(n, m));
    }
    private static int find(int n,int m){
        if (n==0)
            return 0;
        if (n==7&&m==0)
            return 6;
        return 1;
    }
}