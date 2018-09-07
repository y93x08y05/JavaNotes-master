package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 9:21
 * LeetCode 552
 * 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。
 * 答案可能非常大，你只需返回结果mod 109 + 7的值。
 * 学生出勤记录是只包含以下三个字符的字符串：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），
 * 则该记录被视为可奖励的。
 * 例：
 * 输入: n = 2
 * 输出: 8
 * 解释：
 * 有8个长度为2的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数超过一次。
 * n 的值不会超过100000。
 * 动态规划问题
 * Total(n): 字符长度为n的符合条件的个数
 * P(n): 字符长度为n的并且最后一位为P的符合条件的个数
 * L(n): 字符长度为n的并且最后一位为L的符合条件的个数
 * A(n):字符长度为n的并且最后一位为A的符合条件的个数
 * noAP(n):字符长度为n的并且没有一个A字符而且最后一位为P的符合条件的个数
 * noAL(n):字符长度为n的并且没有一个A字符而且最后一位为L的符合条件的个数
 * 根据定义，可以得到
 * Total(n) = P(n) + L(n) + A(n); (n>=1)
 * P(n) = P(n-1) + L(n-1) + A(n-1); (n>=2)
 * 然后由于规则规定不能有三个连续一起L字符，不然判定不符合条件，所以
 * L(n) = P(n-1) + A(n-1) + P(n-2) + A(n-2); (n>=3)
 * 而且最多只能有一个A字符，因此
 * A(n) = noAP(n-1) + noAL(n-1); (n>=2)
 * 同时，
 * noAP(n) = noAP(n-1) + noAL(n-1); (n>=2)
 * noAL(n) = noAP(n-1) + noAP(n-2); (n>=3)
 * 由上面的关系式，然后我们再初始化一些条件，
 * P(1) = A(1) = L(1) = 1;
 * L(2) = 1;
 * noAL(1) = noAP(1) = 1;
 * noAL(2) = noAP(2) = 2;
 */
public class CheckRecord2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findValidRecord(n));
    }
    private static int findValidRecord(int n) {
        if (n==1)
            return 3;
        int mod=1000000007;
        int []A=new int[n+1];
        int []L=new int[n+1];
        int []P=new int[n+1];
        int []noAL=new int[n+1];
        int []noAP=new int[n+1];
        A[1]=L[1]=P[1]=1;
        L[2]=3;
        noAL[1]=noAP[1]=1;
        noAL[2]=noAP[2]=2;
        for (int i=2;i<=n;i++) {
            P[i]=((P[i-1]+A[i-1])%mod+L[i-1])%mod;
            A[i]=(noAP[i-1]+noAL[i-1])%mod;
            noAP[i]=(noAP[i-1]+noAL[i-1])%mod;
            if (i>=3) {
                L[i]=((P[i-1]+A[i-1])%mod+(A[i-2]+P[i-2])%mod)%mod;
                noAL[i]=(noAP[i-1]+noAP[i-2])%mod;
            }
        }
        return ((A[n]+P[n])%mod+L[n])%mod;
    }
}