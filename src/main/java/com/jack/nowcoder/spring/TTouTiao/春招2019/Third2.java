package com.jack.nowcoder.spring.TTouTiao.春招2019;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/3/22 21:10
 * 发奖品问题。n个人的分数围成一个环，
 * 任何一个人获得的奖品数量都比左右两个分数比自己低的人多，分数相等的话没有要求，
 * 求最小需要多少个奖品。设dp[i]表示给i发的最小奖品，
 * 首先扫一遍数组，将两侧分数均比中间高的位置，奖品数置1，
 * 然后再扫一遍对没有赋值的位置进行递归记忆化搜索。
 * 复杂度O(N)
 */
public class Third2 implements Runnable{
    private final int max = 100005;
    private int[] arr = new int[max], dp = new int[max];
    public static void main(String[] args) {
        new Thread(null, new Third2(), "thread-1", 1024 * 1024 * 10).start();
    }
    @Override
    public void run() {
        try {
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                dp[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (arr[(j + 1) % n] >= arr[j] && arr[(j - 1 + n) % n] >= arr[j]) {
                    dp[j] = 1;
                }
            }
            long ans = 0;
            for (int j = 0; j < n; j++) {
                if (dp[j] == 0) {
                    dfs(j, n);
                }
                ans += dp[i];
            }
            System.out.println(ans);
        }
    }
    private void dfs(int k, int n) {
        int pre = (k - 1 + n) % n, next = (k + 1) % n;
        if (arr[pre] < arr[k] && dp[pre] == 0) {
            dfs(pre, n);
        }
        if (arr[next] < arr[k] && dp[next] == 0) {
            dfs(next, n);
        }
        if (arr[pre] < arr[k]) {
            dp[k] = Math.max(dp[k], dp[pre] + 1);
        }
        if (arr[next] < arr[k]) {
            dp[k] = Math.max(dp[k], dp[next] + 1);
        }
    }
}