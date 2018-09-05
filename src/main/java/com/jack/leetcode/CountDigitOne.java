package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 16:06
 * LeetCode 233
 * 给定一个整数n，计算所有小于等于n的非负整数中数字1出现的个数。
 * 输入: 13
 * 输出: 6
 * 解释: 数字1出现在以下数字中:1,10,11,12,13。
 * 每10个数, 有一个个位是1, 每100个数, 有10个十位是1,
 * 每1000个数, 有100个百位是1.
 * 做一个循环, 每次计算单个位上1得总个数(个位,十位, 百位).
 * 公式
 * (a + 8) / 10 * m + (a % 10 == 1) * (b + 1)
 */
public class CountDigitOne {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findOneCount0(n));
        System.out.println(findOneCount1(n));
    }
    private static int findOneCount0(int n) {
        int one=0;
        for (long m=1;m<=n;m*=10) {
            long a=n/m;
            long b=n%m;
            one+=(a+8)/10*m;
            if (a%10==1)
                one+=b+1;
        }
        return one;
    }
    private static int findOneCount1(int n) {
        if (n<=0)
            return 0;
        int q=n;
        int x=1;
        int ans=0;
        int temp;
        do {
            temp=q%10;
            q/=10;
            if (temp==0)
                ans+=q*x;
            else if (temp==1)
                ans+=q*x+n%x+1;
            else
                ans+=(q+1)*x;
            x*=10;
        } while (q>0);
        return ans;
    }
}