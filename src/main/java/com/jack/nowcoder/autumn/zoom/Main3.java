package com.jack.nowcoder.autumn.zoom;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/29 17:28
 * 三个空汽水瓶可以换一瓶汽水，手上有N个空汽水瓶，
 * 最多可以换多少瓶汽水。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        find(n);
        System.out.println(num);
    }
    public static int num=0;
    private static void find(int n) {
        if (n==1) {
            return ;
        } else if (n==2) {
            num++;
            return;
        } else if (n>=3){
            num=num+n/3;
            find(n/3+n%3);
        }
    }
}