package com.jack.nowcoder.spring.MeiTuan.CodeM2017.first;

import java.util.Scanner;

/**
 *
 * 给出一个长度为 n 的数列 { a[1] , a[2] , a[3] , ... , a[n] }，以及 m 组询问 ( l[i] , r[i] , k[i])
 * 求数列下标区间在 [ l[i] , r[i] ] 中有多少数在该区间中的出现次数与
 * k[i] 互质（最大公约数为1）。
 * 输入描述：
 * 第一行，两个正整数n,m(1 ≤ n, m ≤ 50000)
 * 第二行，n 个正整数 a[i] (1 ≤ a[i] ≤ n)描述这个数列
 * 接下来 m 行，每行三个正整数 l[i] , r[i] , k[i]
 * (1 ≤ l[i] ≤ r[i] ≤ n, 1 ≤ k[i] ≤ n)，描述一次询问。
 * 输入m行，即每次询问的答案。
 * 输入
 * 10 5
 * 1 1 1 1 1 2 2 2 2 2
 * 4 7 2
 * 4 7 3
 * 4 8 2
 * 4 8 3
 * 3 8 3
 * 输出
 * 0
 * 2
 * 1
 * 1
 * 0
 */
public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] a = new int[n+1];
        int max = -1;
        int min = 50000;
        for (int i=1;i<=n;i++) {
            a[i] = sc.nextInt();
            max = max>a[i]?max:a[i];
            min = min<a[i]?min:a[i];
        }
        for (int i=1;i<=m;i++) {
            int [] vis = new int[max+1];
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            for (int j=l;j<=r;j++) {
                vis[a[j]]+=1;
            }
            int res = 0;
            for (int p=0;p<vis.length;p++) {
                if (vis[p] == 0)
                    continue;
                if (gcd(vis[p],k)==1)
                    res+=1;
            }
            System.out.println(res);
        }
    }
    private static int gcd(int a,int b) {
        while (b>0) {
            int t = a%b;
            a = b;
            b = t;
        }
        return a;
    }
}