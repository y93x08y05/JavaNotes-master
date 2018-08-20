package com.jack.nowcoder.spring.A163.SpringJava0419;

/**
 * 多重背包问题，首先将需要取得L放入盒子中，假设所有的L和为least
 * 则还需要向盒子添加m-least个糖果，
 * 假设available[i]=r[i]-l[i]，表示在已经对盒子放入各种最小
 * 糖果的情况下，还能继续添加的糖果数，
 * 即在容量为m-least的背包中，选择放入背包中物品容量为available[i]，
 * 求解有多少种满足背包的情况。
 */

import java.util.Scanner;

public class Java3 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] l = new int[n];
        int [] r = new int[m];
        int least = 0;
        int [] available = new int[n];
        for (int i=0;i<r.length;i++){
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
            least += l[i];
            available[i] = r[i] - l[i];
        }
        int target = m - least;
        long [][] dp = new long[n+1][target+1];
        for (int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=target;j++){
                for (int k=0;k<=available[i-1];k++){
                    if (j-k>=0){
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }
        System.out.println(dp[n][target]);
    }
}