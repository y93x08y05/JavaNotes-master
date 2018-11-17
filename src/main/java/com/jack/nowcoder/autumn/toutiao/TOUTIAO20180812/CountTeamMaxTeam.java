package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180812;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 9:42 AM
 * 世界杯开幕式会在球场C举行，球场C的球迷看台可以容纳M*N个球迷
 * 在球场售票完成后，现有官方想统计此次开幕式一共有多少个球队
 * 球迷群体，最大的球队球迷群体有多少人。
 * 经调研发现，球迷群体在选座时有如下特性：
 * 同球队的球迷群体会选择相邻座位，不同球队的球迷群体会选择
 * 不相邻的作为，相邻包括前后相邻、左右相邻、斜对角相邻
 * 给定一个M*N的二维球场，0代表该位置上没有坐人，1代表该位置
 * 已经有球迷，希望输出球队群体个数P，最大的球队群体人数Q
 * 输入描述：
 * 第一行，2个数字，M和N，使用英文逗号分割，
 * 接下来M行，每行N个数字，使用英文逗号分割
 * 例子：M=10，N=10
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,1,1,0,1,0,0,0]
 * [0,1,0,0,0,0,0,1,0,1]
 * [1,0,0,0,0,0,0,0,1,1]
 * [0,0,0,1,1,1,0,0,0,1]
 * [0,0,0,0,0,0,1,0,1,1]
 * [0,1,1,0,0,0,0,0,0,0]
 * [0,0,0,1,0,1,0,0,0,0]
 * [0,0,1,0,0,1,0,0,0,0]
 * [0,1,0,0,0,0,0,0,0,0]
 */
public class CountTeamMaxTeam {
    public static int[][] arr1 = new int[1005][1005];
    public static int[][] arr2 = new int[1005][1005];
    public static int p = 0, q = 0;
    public static int sum, n, m;
    public static int[][] location = {{1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] num = str.split(",");
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(num[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i][j] == 1 && arr2[i][j] == 0) {
                    sum = 0;
                    p++;
                    DFS(i, j);
                    q = Math.max(q, sum);
                }
            }
        }
        System.out.println(p + "," + q);
    }
    private static void DFS(int h, int l) {
        sum++;
        arr2[h][l] = 1;
        for (int i = 0; i < 8; i++) {
            int h1 = location[i][0] + h;
            int l1 = location[i][1] + l;
            if (check(h1, l1))
                DFS(h1, l1);
        }
    }
    private static boolean check(int h2, int l2) {
        return h2 >= 0 && h2 < n && l2 >= 0 && l2 < m && arr1[h2][l2] == 1 && arr2[h2][l2] == 0;
    }
}
