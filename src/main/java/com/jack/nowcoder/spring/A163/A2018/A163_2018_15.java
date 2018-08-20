package com.jack.nowcoder.spring.A163.A2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangta on 1/8/2018.
 * 老师要求学生按照身高不递减的顺序排列
 * 定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和
 * 按照身高顺序排列的队列的疯狂值是最小的
 * 学生决定按照疯狂值最大的顺序来进行列队
 * 现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值
 * 输入包括两行：
 * 第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 * 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高
 * 输出一个整数,表示n个学生列队可以获得的最大的疯狂值
 */
public class A163_2018_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            Arrays.sort(num);
            int min = num[0];// 上一次加入疯狂队列的那个最小值
            int max = num[n - 1];// 上一次加入疯狂队列的那个最大值
            int diff = max - min;
            int minIndex = 1;// 未加入疯狂队列的最小值索引
            int maxIndex = n - 2;// 未加入疯狂队列的最大值索引
            while (minIndex < maxIndex) {
                diff += max - num[minIndex];
                diff += num[maxIndex] - min;
                min = num[minIndex++];
                max = num[maxIndex--];
            }
            // 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
            diff += Math.max(num[maxIndex] - min, max - num[minIndex]);
            System.out.println(diff);
        }
    }
}
