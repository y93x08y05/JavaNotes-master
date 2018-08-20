package com.jack.nowcoder.spring.A163.SpringJob2018;

/**
 * 背包问题当背包较小时采用动态规划
 * 当背包较大物品个数较少时采用指数级枚举搜索
 * 往背包里装入一些零食,背包容量为w。
 * 家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 在总体积不超过背包容量的情况下,
 * 一共有多少种零食放法(总体积为0也算一种放法)。
 * 输入描述
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),
 * 表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * 输出描述
 * 输出一个正整数, 表示一共有多少种零食放法。
 * 输入例子
 * 3 10
 * 1 2 4
 * 输出例子
 * 8
 */

import java.util.Arrays;
import java.util.Scanner;

public class Spring_3 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] v = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
            sum += v[i];
        }
        if (sum <= w)
            //零食总体积小于总容量
            System.out.println(1 << n);
        else {
            Arrays.sort(v);
            if (w < v[0])
                //总容量小于最小零食体积
                System.out.println(1);
            else {
                process(0, w, v);
                System.out.println(count);
            }
        }
    }
    public static void process(int index, int w, int[] v) {
        if (index == v.length) {
            //索引达到零食总个数
            count++;
            return;
        }
        if (v[index] > w) {
            //零食单个最大容量大于零食总体积
            count++;
            return;
        }
        //递归求解避免枚举方法超时
        process(index + 1, w - v[index], v);
        process(index + 1, w, v);
    }
}