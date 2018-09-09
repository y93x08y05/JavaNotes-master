package com.jack.nowcoder.autumn.yixin;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 17:33
 * 银行有编号为1到W的W个贷款窗口，且每个窗口都有一个贷款申请人。
 * 现银行提供N种贷款方式供给贷款申请人，每个申请人可以选择其中一种方式。
 * 如果相邻两个窗口的申请人的贷款方式一样，则将可能产生坏账，
 * 求有多少种状态可能产生坏账？
 * 输入
 * 输入两个整数N，W。其中1<=N<=10^8, 1<=W<10^12
 * 输出
 * 可能产生坏账的状态数除以100003后取余
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextInt();
        long W=sc.nextInt();
        System.out.println(findHuaiZhang(N, W));
    }
    private static long findHuaiZhang(long N,long W) {
        long total= (long) Math.pow(N,W);
        long unContinues=N;
        unContinues*=Math.pow(N-1,W-1);
        return (total-unContinues)%100003;
    }
    private static int findHuaiZhang2(int N,int W) {
        int mod=100003;
        int x=1;
        int y=1;
        for (int i=0;i<W;i++) {
            x*=N;
            x%=mod;
        }
        if (W%2==0) {
            for (int i=0;i<W/2;i++) {
                y*=(W/2*(N*(N-1)%mod)%mod)%mod;
            }
        } else {
            for (int i=0;i<W/2;i++) {
                y*=(W/2*(N*(N-1)%mod)%mod)%mod;
            }
            y+=N;
            y%=mod;
        }
        return x-y;
    }
}