package com.jack.leetcode;

/**
 * Created by Jack on 8/24/2018 9:44 PM
 * LeetCode 372
 * 你的任务是计算 ab 对 1337 取模，
 * a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 例1:
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 例2:
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 */
public class Pow2 {
    public static void main(String[] args) {
        int a=2;
        int [] b={1,0};
        Pow2 pow=new Pow2();
        System.out.println(pow.computeValue(a,b));
    }

    /**
     * a*b)%c = (a%c)*(b%c)%c
     * 设a/c=m,则mc+a%c =a;设b/c=n,则nc+b%c =b;于是
     * (a*b)%c = { (mc+a%c)*(nc+b%c ) }%c = {mcnc+(nc)*(a%c)+(mc)*(b%c)+(a%c)*(b%c)} % c
     * (其中 mcnc+(nc)*(a%c)+(mc)*(b%c)可以整除c)
     * (a*b)%c = (a%c)*(b%c)%c
     * @param a
     * @param b
     * @return
     */
    private int computeValue(int a,int [] b) {
        int res=1;
        for (int i=0;i<b.length;i++) {
            res=computeValue(res,10)*computeValue(a,b[i])%1337;
        }
        return res;
    }
    private int computeValue(int a,int b) {
        if (b==0)
            return 1;
        if (b==1)
            return a%1337;
        return computeValue(a%1337,b/2)*computeValue(a%1337,b-b/2)%1337;
    }
}
