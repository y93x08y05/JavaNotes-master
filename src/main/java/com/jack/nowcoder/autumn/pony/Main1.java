package com.jack.nowcoder.autumn.pony;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/19 21:27
 * 输入正整数N，输出所有小于等于N的质数的平方和
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findSquareSum(n));
    }
    private static int findSquareSum(int n) {
        int sum=0;
        if(n <= 1) {
            return 0;
        }
        boolean [] feiZhiShu = new boolean [n+1];
        feiZhiShu[0] = true;
        feiZhiShu[1] = true;
        for(int i=2;i*i<=n;i++) {
            if(!feiZhiShu[i]) {
                for(int j=2*i;j<=n;j+=i) {
                    feiZhiShu[j] = true;
                }
            }
        }
        for(int i=0;i<feiZhiShu.length;i++) {
            if(!feiZhiShu[i]) {
                sum+=Math.pow(i,2);
            }
        }
        return sum;
    }
}