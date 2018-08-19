package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/19/2018 9:06 PM
 * LeetCode 29
 * number divide number and not use divide or multiply
 */
public class TwoNumberDivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(findDivide(m, n));
    }
    private static int findDivide(int m,int n) {
        int flag=1;
        if ((m<0&&n>0)||(m>0&&n<0))
            flag=-1;
        long a = Math.abs((long)m);
        long b = Math.abs((long)n);
        if (a==0||a<b)
            return 0;
        if (b==0)
            return Integer.MAX_VALUE;
        long res = findDivide(a,b);
        int ans;
        if (res>Integer.MAX_VALUE)
            ans=flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        else
            ans=(int)(flag*res);
        return ans;
    }
    private static long findDivide(long a,long b) {
        if (a<b)
            return 0;
        long res=1;
        long sum=b;
        while (sum+sum<=a) {
            sum+=sum;
            res+=res;
        }
        return res+findDivide(a-sum,b);
    }
}
