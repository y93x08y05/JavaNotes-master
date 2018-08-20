package com.jack.nowcoder.spring.Aiqiyi;

/**
 * 牛牛养了n只奶牛,牛牛想给每只奶牛编号
 * 每个奶牛对于数字都有自己的喜好,第i只奶牛想要一个1和x[i]之间的整数(其中包含1和x[i])。
 * 牛牛需要满足所有奶牛的喜好,请帮助牛牛计算牛牛有多少种给奶牛编号的方法,
 * 输出符合要求的编号方法总数
 * 输入描述
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示奶牛的数量
 * 第二行为n个整数x[i](1 ≤ x[i] ≤ 1000)
 * 输出描述
 * 输出一个整数,表示牛牛在满足所有奶牛的喜好上编号的方法数。
 * 因为答案可能很大,输出方法数对1,000,000,007的模。
 * 输入例子
 * 4
 * 4 4 4 4
 * 输出例子
 * 24
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ai_2018_1 {
    public static void main(String[] args){
        long max = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] x = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
        }
        Arrays.sort(x);
        for (int i = 0; i < n; i++) {
            max = max * (x[i] - i);
            /**
             * 第i只奶牛想要一个在1和i之间的整数
             * 但是因为后边的i个整数之间已经选择了x[i]-i个
             */
            if(max > 1000000007)
                max = max%1000000007;
        }
        System.out.println(max);
    }
}