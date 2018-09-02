package com.jack.nowcoder.spring.tencent.T2018Spring;

import java.util.Scanner;

/**
 * Created by Jack on 9/1/2018 9:42 AM
 * 小Q定义了一种数列称为翻转数列:
 * 给定整数n和m, 满足n能被2m整除。
 * 对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
 * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
 * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
 * 小Q现在希望你能帮他算算前n项和为多少。
 * 输入描述：
 * 输入包括两个整数n和m(2<=n<=10^5,1<=m),并且满足n能被2m整除
 * 输出描述：
 * 输出一个整数，表示前n项和
 * 输入例子：
 * 8 2
 * 输出例子
 * 8
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(compute(n, m));
    }
    private static long compute(int n,int m) {
        long sum=0;
        int i=1;
        boolean flag=false;
        int val=0;
        while (i<=n) {
            if (!flag) {
                if (val<m) {
                    sum-=i;
                    val++;
                    i++;
                } else {
                    flag=true;
                    val=0;
                }
            }
            if (flag) {
                if (val<m) {
                    sum+=i;
                    val++;
                    i++;
                } else {
                    flag=false;
                    val=0;
                }
            }
        }
        return sum;
    }
}
