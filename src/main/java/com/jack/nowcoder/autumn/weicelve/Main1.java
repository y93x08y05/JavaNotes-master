package com.jack.nowcoder.autumn.weicelve;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/17 14:42
 * 输入一个数n，输出从2到n之间包含的数中所有的质数，包含n
 * 如果不存在质数，则输出0。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(countPrimes(n));
    }
    private static String countPrimes(int n) {
        if(n <= 1) {
            return "0";
        }
        boolean [] notPrime = new boolean [n+1];
        notPrime[0] = true;
        notPrime[1] = true;
        for(int i=2;i*i<=n;i++) {
            if(!notPrime[i]) {
                for(int j=2*i;j<=n;j+=i) {
                    notPrime[j] = true;
                }
            }
        }
        int result = 0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<notPrime.length;i++) {
            if(!notPrime[i]) {
                sb.append(i).append(",");
                result++;
            }
        }
        if (result>0)
            return sb.substring(0,sb.length()-1);
        return "0";
    }
}