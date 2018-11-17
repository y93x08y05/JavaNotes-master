package com.jack.nowcoder.autumn.wangyi.WY20181117;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/11/17 13:46
 * 网易游戏2019校园招聘-产品开发工程师笔试题目
 * 《荒野行动》是网易游戏出品的一款战术竞技游戏，开局物资的获取
 * 对于玩家后续游戏发展影响很大，因此玩家都会在降落之后进行一次
 * 疯狂的物资搜集，而这些物资散落在地图的各个角落。受限于地图上
 * 建筑的阻挡，有些物资点是玩家无法到达的。假设我们用n*n的矩阵来
 * 表示地图，其中字符"."表示道路，字符"#"表示建筑，
 * 阿拉伯数字1-9表示物资，其数值表示物资的重量，例如下边的矩阵
 * 表示一个6*6的地图
 * . . 1 . # .
 * 2 # # 3 # 8
 * . # . # # .
 * . # 6 # 9 .
 * 4 # # # . .
 * . . 7 . . 5
 * 玩家降落之后在矩阵上有一个初始的位置(x,y)，其中
 * 0<=x,y<n，保证玩家不会直接降落在建筑上。此后玩家只可以进行
 * 上下左右四个方向上的移动，并且不能超出地图边界。当玩家
 * 到达物资所在地时，自动将该点的物资装入背包。假设玩家的
 * 背包容量无限大，请计算出玩家将全部可以收集到的物资都搜集完毕
 * 后，最终背包里的物资总重量。
 * 例如，玩家初始位置为(0,0)，其可以达到的位置装入背包后的重量
 * 为39。
 * 输入描述：
 * 第一行为一个整数n，表示大小为n * n的地图。
 * 接下来n行，每行为n个由".","#"和数字1-9组成的字符串
 * 所构成的物资地图。
 * 第n + 2行作为两个整数x和y，用空格分隔，表示玩家的初始位置
 * 输出描述：
 * 玩家物资搜集完毕后背包的重量
 * 输入：
 * 6
 * ..1.#.
 * 2##3#8
 * .#.##.
 * .#6#9.
 * 4###..
 * ..7..5
 * 0 0
 * 输出：
 * 39
 */
public class Main1 {
    public static int n;
    public static int sum = 0;
    public static int[][] location = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static char[][] chars;
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        chars = new char[n][n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        String[] strings = sc.nextLine().split(" ");
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        dfs(x, y);
        System.out.println(sum - count * 48);
    }
    public static int count = 0;
    private static void dfs(int h, int l) {
        arr[h][l] = 1;
        for (int i = 0; i < 4; i++) {
            int h1 = location[i][0] + h;
            int l1 = location[i][1] + l;
            if (check(h1, l1)) {
                if (Character.isDigit(chars[h][l])) {
                    count++;
                    System.out.println("result  " + chars[h][l]);
                    sum += (int) chars[h][l];
                }
                dfs(h1, l1);
            }
        }
    }
    private static boolean check(int h2, int l2) {
        return h2 >= 0 && h2 < n && l2 >= 0 && l2 < n && chars[h2][l2] != '#' && arr[h2][l2] == 0;
    }
}