package com.jack.nowcoder.autumn.XunLei;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/12 18:50
 * 题目描述：
 * 勾股数，是由三个正整数组成的数组；
 * 能符合勾股定理 a*a + b*b = c*c ， (a, b, c) 的正整数解。
 * 如果 (a, b, c) 是勾股数，它们的正整数倍数，也是勾股数。
 * 如果 (a, b, c) 互质，它们就称为素勾股数。
 * 给定正整数N，计算出小于或等于N的素勾股数个数。
 * (0 < a <= b <= c <= N)
 * 输入
 * 正整数N
 * 输出
 * 小于或等于N的素勾股数个数
 * (0 < a <= b <= c <= N)
 * 样例输入
 * 10
 * 样例输出
 * 1
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findCountSuGouGuShu(n));
    }
    private static int findCountSuGouGuShu(int n) {
        if (n==1)
            return 1;
        int total=0;
        for (int i=1;i<=Math.sqrt(n/2);i++) {
            for (int j=1+1;j<=Math.sqrt(n);j++) {
                if (!(find(i,j)==1&&(i%2!=j%2)))
                    continue;
                int x=j*j-i*i;
                int y=2*j*i;
                int z=i*i+j*j;
                if (z>n)
                    break;
                if (find(x,y)==1&& find(x,z)==1&& find(y,z)==1)
                    total++;
            }
        }
        return total;
    }
    private static int find(int a, int b) {
        return b==0?a:find(b,a%b);
    }
}