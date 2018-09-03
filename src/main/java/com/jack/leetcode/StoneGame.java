package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 9/2/2018 6:50 PM
 * LeetCode 877
 * 亚历克斯和李用几堆石子在做游戏。
 * 偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。
 * 每回合，玩家从行的开始或结束处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，
 * 当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前5颗或后5颗石子 。
 * 假设他取了前5颗，这一行就变成了[3,4,5] 。
 * 如果李拿走前3颗，那么剩下的是[4,5]，亚历克斯拿走后5颗赢得10分。
 * 如果李拿走后5颗，那么剩下的是[3,4]，亚历克斯拿走后4颗赢得9分。
 * 这表明，取前5颗石子对亚历克斯来说是一个胜利的举动，所以返回true。
 */
public class StoneGame {
    /**
     * 最优处理，每次只能拿两端的石头堆，考虑拿了两端之后剩下的最优情况
     * 分为子问题，两个相邻石头堆-->三个相邻石头堆
     * 设dp[i][j]为piles[i]~piles[j]Alex最多可以赢Lee的分数
     * 因此:dp[i][j]=max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1])
     * 其中piles[i]-dp[i+1][j]表示Alex取走i上的石头堆，
     * piles[j]-dp[i][j-1]表示Alex取走的是j上的石头堆。
     * 注意，为什么dp[i+1][j]表示piles[i+1]~piles[j]之间Alex最多可以赢Lee的分数，
     * 而piles[i]要减去该值而不是加上该值呢？
     * 由于我们的要求是每一步Alex和Lee采取的都是最优策略，
     * 当取piles[i]时，piles[i+1]~piles[j]中Alex和Lee的走法会调换。
     * 意即Lee走Alex的走法，Alex走Lee的走法，因此这里要做减法。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findIfWin(arr));
    }
    private static boolean findIfWin(int []arr) {
        int n=arr.length;
        int [][]dp=new int[n][n];
        for (int i=0;i<n;i++) {
            dp[i][i]=arr[i];
        }
        for (int j=1;j<n;j++) {
            for (int i=0;i<n-j;i++) {
                dp[i][i+j]=Math.max(arr[i]-dp[i+1][i+j],arr[i+j]-dp[i][i+j-1]);
            }
        }
        return dp[0][n-1]>0;
    }
}
