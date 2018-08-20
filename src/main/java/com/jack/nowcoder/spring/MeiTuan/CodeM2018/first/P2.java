package com.jack.nowcoder.spring.MeiTuan.CodeM2018.first;

import java.util.Scanner;

/**
 * 小美和小团最近沉迷可乐，可供他们选择的可乐共k种，比如可乐可乐、零度可乐等，
 * 每种可乐会带给小美和小团不同的快乐程度。
 * 他们一共要买n瓶可乐，每种可乐可以买无限多瓶，小美会随机挑选其中的m瓶喝，
 * 剩下的n-m瓶小团喝。请问应该如何购买可乐，使得小美和小团的快乐程度的和
 * 的期望值最大呢，求出购买可乐的方案。
 * 输入描述：
 * 第一行三个整数n、m、k分别表示要买的可乐数，小美喝的可乐数，和可以选择的可乐种数。
 * 接下来k行，每行两个整数a，b分别表示某种可乐分别给予小美和小团的快乐程度。
 * 对于所有数据，1<=n<=10000，0<=m<=n,1<=k<=10000,-10000<=a,b<=10000
 * 输出描述：
 * 一行k个整数，第i个整数表示购买第i种可乐的数目。如果有多解，输出字典序最小的。
 * 对于两个序列a1,a2,......,ak,b1,b2,......,bk,a的字典序列小于b，当且仅当
 * 存在一个位置i<=k满足：ai<bi且对于所有的位置j<i，aj=bj。
 * 例子1：
 * 输入：
 * 2 1 2
 * 1 2
 * 3 1
 * 输出：
 * 0 2
 * 例子说明：
 * 一共有三种购买方案：
 * （1）买两瓶第一类可乐，小美和小团各喝一瓶，期望得到的快乐程度为1+2=3；
 * （2）买1瓶第一类可乐，一瓶第二类可乐，小美和小团各有二分之一的概率喝到第一
 * 类可乐，各有二分之一概率喝到第二类可乐，期望得到的快乐程度为：
 * 1*0.5+3*0.5+2*0.5+1*0.5=3.5；
 * （3）买2瓶第二类可乐，小美和小团各喝一瓶，期望得到的快乐程度为3+1=4。
 */
public class P2 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long max = Long.MIN_VALUE;
        int pos = 0;
        for (int i=1;i<=k;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long value = 1L*m*a+1L*(n-m)*b;
            if (value>=max) {
                max = value;
                pos = i;
            }
        }
        for (int i=1;i<=k;i++) {
            System.out.printf("%d%c",i==pos?n:0,i==k?'\n':' ');
        }
    }
}