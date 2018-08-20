package com.jack.nowcoder.spring.A163.SpringJava0617;

/**
 * 用1*3的瓷砖铺3*20的地板有几种方式？
 * 动态规划，转移方程为：f[i] = 2*f[i-3] + f[i-4] + f[i-5]，
 * 3*n的区域铺瓷砖为f(n)，
 * 如果第一列竖着，那么就是f(n-1)，
 * 如果横着铺，就是f(n-3)，
 * f(n) = f(n-1) + f(n-3),递推结果为1278。
 */
public class P6 {
    public static void main(String[] args) {
        int [] a = new int[20+5];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        a[4] = 3;
        for (int i=5;i<=20;i++) {
            a[i] = (a[i-3] << 1) + a[i-4] +a[i-5];
            System.out.println(i + " " + a[i]);
        }
    }
}