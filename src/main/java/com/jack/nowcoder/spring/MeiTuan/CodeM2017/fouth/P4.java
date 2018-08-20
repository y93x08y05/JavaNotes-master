package com.jack.nowcoder.spring.MeiTuan.CodeM2017.fouth;

import java.util.Scanner;

/**
 * 输入两个字符串a和b，合并成一个字符串c，属于a或b的字符在c中保持
 * 位置不变，如"ACG"和"UT"可以被组合成"AUCTG"或"ACUGT"等。
 * 定义字符串c的价值如下，令n为字符串c的长度，分界线k(1<=k<=n-1)
 * 将c分为两个子串u=c[1..k]，v=c[k+1..n]。u、v中字符的任意排列，
 * 使得u、v中的最长公共前缀最大，此即分界线k的价值，而所有分界线k
 * 价值最大的一个为字符串c的价值。比如，
 * 字符串c=ACGTTTGCAT的价值为5，
 * 因为将该串分成两半得到u=ACGTT，V=TGCAT，重新排列后可以使得
 * u=v，即最长公共前缀为5。
 * 求出所有可能的c中价值最大的字符串，输出这个最大价值即可。
 * 输入描述：
 * 第一行一个整数T(T ≤ 500)
 * 接下来2T行，每行一个字符串，每两行代表一对字符串a和b
 * （|a|,|b|<=100,000；∑(|a|+|b|)<=500,000），
 * 字符串的字符集为{A,C,G,T}。
 * 对于每组数据输出一个整数表示最大的c的价值
 * 输入
 * 2
 * ACGT
 * ACGT
 * AACCGGTT
 * ACACAGAT
 * 输出
 * 4
 * 7
 */
public class P4 {
    public static char [][] c = new char[2][100000];
    public static int [] m = new int[2];
    public static int ans = 0;
    public static int [][][] sum = new int[2][4][100000];
    public static String [] str = new String[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            str[0] = sc.next();
            m[0] = str[0].length();
            str[1] = sc.next();
            m[1] = str[1].length();
            for (int p=0;p<str.length;p++) {
                for (int j=0;j<str[p].length();j++) {
                    for (int s=0;s<4;s++) {
                        sum[p][s][j+1]=sum[p][s][j];
                    }
                    sum[p][change(str[p].charAt(j))][j+1]++;
                }
            }
            int ch = 0;
            ans = 0;
            for (int q=0;q<=m[0];q++) {
                int min;
                int max;
                if (q==0) {
                    min = 0;
                    max = m[1];
                } else {
                    min = Math.max(0,ch-300);
                    max = Math.min(m[1],ch+300);
                }
                int awp = 0;
                for (int p=min;p<max;p++) {
                    int now = 0;
                    for (int s=0;s<4;s++) {
                        now+=Math.min(sum[0][s][q]+sum[1][s][p],sum[0][s][m[0]]-sum[0][s][q]+sum[1][s][m[1]]-sum[1][s][p]);
                    }
                    if (awp < now) {
                        awp = now;
                        ch = p;
                    }
                }
                if (ans < awp) {
                    ans = awp;
                }
            }
            System.out.println(ans);
        }
    }
    public static int change(char c) {
        if (c=='A') {
            return 0;
        }
        if (c=='T') {
            return 1;
        }
        if (c=='G') {
            return 2;
        }
        if (c=='C') {
            return 3;
        }
        return -1;
    }
}