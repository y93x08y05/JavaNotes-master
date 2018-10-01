package com.jack.nowcoder.autumn.VMware.VM20180913;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/13 18:28
 * 格瑞斯今天做数学暑假作业遇到了一道难题，
 * 题目说道：坐标平面上有n个点，进行连线，要求任意两条线段不能交叉，
 * 求最好情况下最多能连多少条线，能连成最多多少个三角形？
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        findValue(n);
    }
    private static void findValue(int n) {
        if (n==1)
            System.out.println(0+" "+0);
        else if (n==2)
            System.out.println(1+" "+0);
        else if (n==3)
            System.out.println(3+" "+1);
        else {
            System.out.println(3*(n-3)+3+" "+3*(n-3)+1);
        }
    }
}