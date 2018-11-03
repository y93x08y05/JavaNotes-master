package com.jack.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Jack
 * @Date: 2018/9/7 12:37
 * LeetCode 547
 * 班上有N名学生。其中有些人是朋友，有些则不是。
 * 他们的友谊具有是传递性。
 * 如果已知A是B的朋友，B是C的朋友，那么我们可以认为A也是C的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 * 给定一个N*N的矩阵M，表示班级中学生之间的朋友关系。
 * 如果M[i][j]=1，表示已知第i个和j个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 * 例1:
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 例2:
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，
 * 所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 深度优先遍历，广度优先遍历，图的连通性。
 */
public class FriendCircle {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findFriendCircleNum1(arr));
        System.out.println(findFriendCircleNum2(arr));
        System.out.println(findFriendCircleNum0(arr));
    }
    //利用并查集进行处理
    private static int findFriendCircleNum0(int[][] M) {
        if (M.length == 0)
            return 0;
        int[] pre = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            pre[i] = i;
        }
        int group = M.length;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    int x1 = find(i, pre);
                    int x2 = find(j, pre);
                    if (x1 != x2) {
                        pre[x1] = x2;
                        group--;
                    }
                }
            }
        }
        return group;
    }
    private static int findFriendCircleNum1(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                bfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private static int findFriendCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private static int find(int x, int[] pre) {
        if (pre[x] == x)
            return x;
        else
            return find(pre[x], pre);
    }
    public static Queue<Integer> queue = new LinkedList<>();
    private static void bfs(int[][] M, int[] visited, int i) {
        queue.offer(i);
        visited[i] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int j = 0; j < M.length; j++) {
                if (visited[j] == 0 && M[node][j] == 1) {
                    queue.offer(j);
                    visited[j] = 1;
                }
            }
        }
    }
    private static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}