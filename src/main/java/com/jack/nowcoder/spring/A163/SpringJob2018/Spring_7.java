package com.jack.nowcoder.spring.A163.SpringJob2018;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]),
 * 右上角坐标为(x2[i], y2[i])。
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的
 * (不考虑边界和角落)。
 * 请你计算出平面内重叠矩形数量最多的地方,
 * 有多少个矩形相互重叠。
 * 输入描述
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 * 输出描述
 * 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
 * 输入例子
 * 2
 * 0 90
 * 0 90
 * 100 200
 * 100 200
 * 输出例子
 * 2
 */
public class Spring_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 50 + 5;
        int[] X1 = new int[max];
        int[] Y1 = new int[max];
        int[] X2 = new int[max];
        int[] Y2 = new int[max];
        Set<Integer> xx = new TreeSet<>();
        Set<Integer> yy = new TreeSet<>();
        for(int i = 0; i < n; i++){
            X1[i] = sc.nextInt();
            xx.add(X1[i]);
        }
        for(int i = 0; i < n; i++){
            Y1[i] = sc.nextInt();
            yy.add(Y1[i]);
        }
        for(int i = 0; i < n; i++){
            X2[i] = sc.nextInt();
            xx.add(X2[i]);
        }
        for(int i = 0; i < n; i++){
            Y2[i] = sc.nextInt();
            yy.add(Y2[i]);
        }
        int ret = 1;
        for(int x : xx){
            for(int y : yy){
                int cnt = 0;
                for(int i = 0; i < n; i++){
                    if(X1[i] <= x && Y1[i] <= y && X2[i] > x && Y2[i] > y)
                        cnt++;
                }
                ret = Math.max(ret, cnt);
            }
        }
        System.out.println(ret);
    }
}