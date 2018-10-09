package com.jack.nowcoder.autumn.toutiao.TOUTIAO20181008;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/8 18:54
 * 已知从山脚到山顶一共有m个台阶，一次可爬a-b个台阶。
 * 由于多年没有修，部分台阶无法站立，已知坏的台阶共有n个，
 * 并给出所在位置，问共有多少中登山方案，如果无法登上山顶，返回0
 * 输入描述：
 * 台阶总数m，一次最少可爬台阶数a，一次最大可爬台阶数b。
 * 坏掉的台阶n，之后n行为坏掉台阶的编号。编号从1开始
 * 输出描述：
 * 一个数字，代表登山方案的个数
 * 输入：
 * 3
 * 1
 * 1
 * 0
 * 输出：
 * 1
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        if (n > 0) {
            int []arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(find(m,a,b,arr));
        } else {
            System.out.println(find(m, a, b));
        }
    }
    public static int find(int m,int a,int b) {
        return 1;
    }
    public static int find(int m,int a,int b,int []arr) {
        return 1;
    }
}