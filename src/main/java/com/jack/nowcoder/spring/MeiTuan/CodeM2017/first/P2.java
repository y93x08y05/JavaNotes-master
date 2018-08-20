package com.jack.nowcoder.spring.MeiTuan.CodeM2017.first;

import java.util.Scanner;

/**
 * 给定一个完全二分图，图的左右两边的顶点数目相同。给图中的每条边染色
 * 为红色，蓝色或者绿色，并使得任意两条红边不共享端点，同时任意两条蓝边
 * 也不共享端点，计算所有满足条件的染色的方案数，并对10^9+7取模。
 * 输入描述：
 * 二分图单边的顶点数目n
 * 输出描述
 * 输出一个整数表示所求得的答案
 * 输入 2
 * 输出 35
 */
public class P2 {
    public static int N = 10000005;
    public static int P = 1000000007;
    public static long [] fac = new long[N];
    public static long [] inv = new long[N];
    public static long [] b = new long[N];
    public static void main(String[] args) {
        int n;
        long result;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            pre(n);
            result = 0;
            for (int i=0;i<=n;i++) {
                result=(result+((i&1)==0?1:-1)*(fac[n]*fac[n]%P*inv[i]%P*inv[n-i]%P*inv[n-i]%P*b[n-i]%P*b[n-i]%P)+P)%P;
            }
            System.out.println(result);
        }
    }
    public static void pre(int n) {
        fac[0] = 1;
        for (int i=1;i<=n;i++) {
            fac[i] = fac[i-1]*i%P;
        }
        inv[n]=quickPow(fac[n], P-2);//费马小定理
        for(int i=n-1;i>=0;i--){
            inv[i]=inv[i+1]*(i+1)%P;
        }
        b[0]=1;
        b[1]=2;
        for(int i=2;i<=n;i++){//防止b[i]为负
            b[i]=(2*i*b[i-1]%P-b[i-2]*(i-1)%P*(i-1)%P+P)%P;
        }
    }
    private static long quickPow(long a,int x) {
        long ans=1;
        while(x!=0){
            if ((x&1)!=0) {
                ans=ans*a%P;
            }
            a=a*a%P;
            x>>=1;
        }
        return ans;
    }
}