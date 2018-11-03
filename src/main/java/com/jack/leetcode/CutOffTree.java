package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/22 12:25
 * LeetCode 675
 * 为高尔夫比赛砍树
 * 你被请来给一个要举办高尔夫比赛的树林砍树.
 * 树林由一个非负的二维数组表示， 在这个数组中：
 * 0 表示障碍，无法触碰到.
 * 1 表示可以行走的地面.
 * 比1大的数 表示一颗允许走过的树的高度.
 * 你被要求按照树的高度从低向高砍掉所有的树，每砍过一颗树，树的高度变为1。
 * 你将从（0，0）点开始工作，你应该返回你砍完所有树需要走的最小步数。
 * 如果你无法砍完所有的树，返回 -1 。
 * 可以保证的是，没有两棵树的高度是相同的，并且至少有一颗树需要你砍。
 * 例1:
 * 输入:
 * [
 *  [1,2,3],
 *  [0,0,4],
 *  [7,6,5]
 * ]
 * 输出: 6
 * 例2:
 * 输入:
 * [
 *  [1,2,3],
 *  [0,0,0],
 *  [7,6,5]
 * ]
 * 输出: -1
 * 例3:
 * 输入:
 * [
 *  [2,3,4],
 *  [0,0,5],
 *  [8,7,6]
 * ]
 * 输出: 6
 * 解释: (0,0) 位置的树，你可以直接砍去，不用算步数
 */
public class CutOffTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> lists = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }
        System.out.println(find(lists));
    }
    public static int[][] direct = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static int[][] dist;
    //Java代码处理超时
    private static int find(List<List<Integer>> forest) {
        int result = 0;
        int rows = forest.size();
        int cols = forest.get(0).size();
        int[][] matrix = new int[rows][cols];
        Map<Integer, int[]> map = new TreeMap<>();
        dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = forest.get(i).get(j);
                map.put(matrix[i][j], new int[]{i, j});
            }
        }
        Set<Integer> keys = map.keySet();
        int[] start = {0, 0};
        for (int key : keys) {
            if (key > 0) {
                int[] end = map.get(key);
                minDist(start, matrix);
                int d = dist[end[0]][end[1]];
                if (d == Integer.MAX_VALUE)
                    return -1;
                result += d;
                start = end;
            }
        }
        return result;
    }
    private static void minDist(int[] start, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        dist[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : direct) {
                int x = Objects.requireNonNull(p)[0];
                int y = p[1];
                int nx = x + dir[0];
                int ny = y + dir[1];
                int[] np = {nx, ny};
                if (nx < rows && nx >= 0 && ny < cols && ny >= 0 && matrix[nx][ny] != 0 && dist[nx][ny] > dist[x][y] + 1) {
                    queue.add(np);
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
    }
}