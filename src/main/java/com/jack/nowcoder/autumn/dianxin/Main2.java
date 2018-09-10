package com.jack.nowcoder.autumn.dianxin;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/10 9:25
 * 读取一个自然数，求按从小到大的顺序的第n个丑数并输出，
 * 把只包含因子2,3,5的数称为丑数，例如6,8都是丑数，但14不是
 * 因为它包含因子7，1当做是第一个丑数。
 * 输入描述：
 * 输入包括一个整数N（1<=N<=1500）
 * 输出描述：
 * 每输入一个测试数据就输出第N个丑数
 * 例1：
 * 输入：3
 * 输出：3
 * 例2：
 * 输入：7
 * 输出：8
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(getUglyNumber(sc.nextInt()));
    }
    public static int getUglyNumber(int n) {
        if (n <= 0)
            return 0;
        int [] res = new int[n];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        res[0]  = 1;
        int temp;
        while (count < n - 1) {
            temp = Math.min(res[i2]*2,Math.min(res[i3]*3,res[i5]*5));
            if (temp == res[i2]*2)
                i2++;
            if (temp == res[i3]*3)
                i3++;
            if (temp == res[i5]*5)
                i5++;
            res[++count] = temp;
        }
        return res[n-1];
    }
}