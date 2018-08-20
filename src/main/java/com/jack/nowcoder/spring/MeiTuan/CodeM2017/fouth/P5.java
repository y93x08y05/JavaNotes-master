package com.jack.nowcoder.spring.MeiTuan.CodeM2017.fouth;

import java.util.Scanner;

/**
 * 美团外卖日订单量已经超过1200万，实时调度系统是背后的重要技术支撑
 * 其中涉及很多复杂的算法，下边题目是某类场景的抽象。
 * 一共n个点m条有向边的图上，有q个配送需求，需求的描述形式为( s_i , t_i , l_i , r_i )，
 * 即需要从点 s_i 送到 t_i， 在时刻 l_i 之后（包括 l_i）可以在 s_i 领取货物，
 * 需要在时刻 r_i 之前（包括 r_i）送达 t_i ，每个任务只需完成一次。
 * 图上的每一条边均有边权，权值代表外卖配送员通过这条边消耗的时间。
 * 在时刻0有一个配送员在点1上，求他最多能完成多少个配送任务。
 * 在整个过程中忽略了取餐与给客户送餐的时间，只考虑花费在路上的时间。
 * 并且允许在一个点逗留。
 * 输入描述：
 * 第一行，三个正整数 n , m , q (2 ≤ n ≤ 0, 1 ≤ m ≤ 400, 1 ≤ q ≤ 10)。
 * 接下来 m 行，每行三个正整数 u_i , v_i , c_i
 * (1 ≤ u_i,v_i ≤ n, 1 ≤ c_i ≤ 20000)，
 * 表示有一条从 u_i 到 v_i 耗时为 c_i 的有向边。
 * 接下来 q 行，每行四个正整数 s_i , t_i , l_i , r_i
 * (1 ≤ s_i,t_i ≤ n, 1 ≤ l_i ≤ r_i ≤ 10^6)，描述一个配送任务。
 * 输出描述：
 * 一个整数，表示最多能完成的任务数量。
 * 输入：
 * 5 4 3
 * 1 2 1
 * 2 3 1
 * 3 4 1
 * 4 5 1
 * 1 2 3 4
 * 2 3 1 2
 * 3 4 3 4
 * 输出：
 * 2
 */
public class P5 {
    public static int n,m,q,u,v,c;
    public static boolean [] flag = new boolean[25];
    public static int [][] dp = new int[60005][25];
    public static int [] s = new int[25];
    public static int [] nt = new int[405];
    public static int [] e = new int[405];
    public static int [] cost = new int[405];
    public static int [] f = new int [15];
    public static int [] t = new int [15];
    public static int [] l = new int [15];
    public static int [] r = new int [15];
    public static int [] a = new int [15];
    public static int [] p = new int [15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int [][] arr1 = new int[m][3];
        int [][] arr2 = new int[q][4];
        for (int i=0;i<m;i++) {
            arr1[i][0] = sc.nextInt();
            arr1[i][1] = sc.nextInt();
            arr1[i][2] = sc.nextInt();
        }
        for (int i=0;i<q;i++) {
            arr2[i][0] = sc.nextInt();
            arr2[i][1] = sc.nextInt();
            arr2[i][2] = sc.nextInt();
            arr2[i][3] = sc.nextInt();
        }

    }
}