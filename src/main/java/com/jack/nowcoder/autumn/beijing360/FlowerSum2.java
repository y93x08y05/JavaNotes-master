package com.jack.nowcoder.autumn.beijing360;

import java.util.Scanner;

/**
 * Created by Jack on 8/27/2018 10:18 PM
 */
public class FlowerSum2 {
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        new FlowerSum2().solve();
    }
    private void solve() {
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        int [][]dp=new int[n+1][m+1];
        for (int i=1;i<=n;i++) {
            int x=sc.nextInt();
            dp[n][x]++;
            for (int j=1;j<m;j++)
                dp[i][j]+=dp[i-1][j];
        }
        int q=sc.nextInt();
        while (q-->0) {
            int l=sc.nextInt();
            int r=sc.nextInt();
            int ans=0;
            for (int i=0;i<=m;i++) {
                if (dp[r][i]-dp[l-1][i]>0)
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
