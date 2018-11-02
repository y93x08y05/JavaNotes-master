package com.jack.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Jack
 * @Date: 2018/9/7 9:02
 * LeetCode 847
 * 给出 图 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
 * 图.length = N，且只有节点 i 和 j 连通时，
 * j != i 在列表 图[i] 中恰好出现一次。
 * 返回能够访问所有节点的最短路径的长度。
 * 你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * 例1：
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 例2：
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 */
public class ShortestPathLength {
    public static void main(String[] args) {
        int[][] arr = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        System.out.println(shortestPathLength(arr));
    }
    private static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        Queue<Pair> pairs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 999);
            pairs.offer(new Pair(i, 1 << i));
            dp[i][1 << i] = 0;
        }
        int endStatus = (1 << n) - 1;
        while (!pairs.isEmpty()) {
            Pair pair = pairs.poll();
            int head = pair.head;
            int d = dp[head][pair.status];
            if (pair.status == endStatus)
                return d;
            for (int i = 0; i < graph[head].length; i++) {
                int temp = graph[head][i];
                int tempStatus = pair.status | (1 << temp);
                if (d + 1 < dp[temp][tempStatus]) {
                    dp[temp][tempStatus] = d + 1;
                    pairs.offer(new Pair(temp, tempStatus));
                }
            }
        }
        return 0;
    }
    static class Pair {
        public int head, status;
        public Pair(int head, int status) {
            this.head = head;
            this.status = status;
        }
    }
}