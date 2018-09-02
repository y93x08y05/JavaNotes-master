package com.jack.nowcoder.spring.tencent.T2018Spring;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Jack on 9/1/2018 9:43 AM
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，
 * 现在小Q想用这些歌组成一个总长度正好为K的歌单，
 * 每首歌最多只能在歌单中出现一次，
 * 在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
 * 输入描述：
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
 * 接下来的一行包含四个正整数，
 * 分别表示歌的第一种长度A(A<=10)和数量X(X<=100)
 * 以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 * 输出一个整数：
 * 输出一个整数,表示组成歌单的方法取模。
 * 因为答案可能会很大,输出对1000000007取模的结果。
 * 输入例子：
 * 5
 * 2 3 3 3
 * 输出例子：
 * 9
 * 杨辉三角归纳法
 * C<m,n>
 * C(n,k) = C(n-1,k) + C(n-1,k-1）
 * 01背包求方案数问题
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();
        int A=sc.nextInt();
        int X=sc.nextInt();
        int B=sc.nextInt();
        int Y=sc.nextInt();
        System.out.println(findSum0(K, A, X, B, Y));
        System.out.println(findSum1(K, A, X, B, Y));
        System.out.println(findSum2(K, A, X, B, Y));
        System.out.println(findSum3(K, A, X, B, Y));
    }
    private static long findSum0(int K, int A, int X, int B, int Y) {
        int []arr=new int[X+Y];
        for (int i=0;i<arr.length;i++) {
            if (i<X) {
                arr[i]=A;
            } else {
                arr[i]=B;
            }
        }
        long [][]dp=new long[X+Y+1][K+1];
        dp[0][0]=1;
        for (int i=1;i<dp.length;i++) {
            for (int j=0;j<dp[0].length;j++) {
                if (j>=arr[i-1]) {
                    dp[i][j]=(dp[i-1][j-arr[i-1]]+dp[i-1][j])%1000000007;
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[X+Y][K]%1000000007;
    }
    private static long findSum1(int K, int A, int X, int B, int Y) {
        long [][]can=new long[101][101];
        can[0][0]=1;
        for (int i=1;i<can.length;i++) {
            can[i][0]=1;
            for (int j=1;j<can[0].length;j++) {
                can[i][j]=(can[i-1][j-1]+can[i-1][j])%1000000007;
            }
        }
        long res=0;
        for (int i=0;i<=X;i++) {
            if (i*A<=K&&(K-i*A)%B==0&&(K-i*A)/B<=Y) {
                res+=can[X][i]*can[Y][(K-i*A)/B]%1000000007;
            }
        }
        return res;
    }
    private static BigInteger findSum2(int K, int A, int X, int B, int Y) {
        BigInteger count=new BigInteger("0");
        for (int i=0;i*A<=K&&i<=X;i++) {
            if ((K-i*A)%B==0) {
                int numberB=(K-i*A)/B;
                if (numberB>Y)
                    continue;
                else {
                    count=count.add(C(X,i).multiply(C(Y,numberB)));
                }
            }
        }
        return count.mod(BigInteger.valueOf(1000000007));
    }
    private static BigInteger A(int low,int high) {
        BigInteger result=new BigInteger("1");
        for (int i=low-high+1;i<=low;i++) {
            result=result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    private static BigInteger C(int low,int high) {
        high=high>low-high?high:low-high;
        BigInteger result=A(low,high);
        for (int i=2;i<=high;i++) {
            result=result.divide(BigInteger.valueOf(i));
        }
        return result;
    }
    private static long findSum3(int K, int A, int X, int B, int Y) {
        int row=101;
        int mod=1000000007;
        long [][]arr=getYangHuiTriangle(row,mod);
        long sum=getNum(K,A,X,B,Y,arr,mod);
        return sum;
    }
    private static long[][] getYangHuiTriangle(int row,int mod) {
        long [][]arr=new long[row][row];
        for (int i=0;i<row;i++) {
            for (int j=0;j<=i;j++) {
                if (j==0||j==i) {
                    arr[i][j]=1;
                } else {
                    arr[i][j]=(arr[i-1][j-1]+arr[i-1][j])%mod;
                }
            }
        }
        return arr;
    }
    private static long getNum(int K,int A,int X,int B,int Y,long [][]arr,int mod) {
        long sum=0L;
        for (int i=0;i<=X;i++) {
            int len=K-A*i;
            if (len>=0&&len%B==0&&len/B<=Y) {
                sum=(arr[X][i]*arr[Y][len/B])%mod;
            }
        }
        return sum;
    }
}
