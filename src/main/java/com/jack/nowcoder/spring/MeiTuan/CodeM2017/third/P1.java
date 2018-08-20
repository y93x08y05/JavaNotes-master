package com.jack.nowcoder.spring.MeiTuan.CodeM2017.third;

import java.util.Scanner;

/**
 * 有一个树状的城市网络，即n个城市由n-1条道路连接的连通图
 * 首都为1号城市，每个城市售卖价值为a_i的珠宝
 * 你是一个珠宝商，现在安排你q次行程，每次行程从u号城市前往v号城市
 * 走最短路径，保证v在u前往首都的最短路径上。在每次行程开始时，
 * 你手上有价值为c的珠宝，每次行程可能不同。并且每经过一个城市，包括
 * u和v，假如那个城市中售卖的珠宝比你手上的每一种珠宝都价值更高，
 * 那么你就会选择购买，现在想要对每一次行程求出会进行多少次购买事件。
 * 输入描述：
 * 第一行，两个正整数 n , q (2 ≤ n ≤ 10^5 , 1 ≤ q ≤ 10^5)。
 * 第二行，n 个正整数 a_i (1 ≤ a_i ≤ 10^5) 描述每个城市售卖的珠宝的价值。
 * 接下来 n-1 行，每行描述一条道路 x , y (1 ≤ x,y ≤ n)，
 * 表示有一条连接 x 和 y 的道路。
 * 接下来 q 行，每行描述一次行程 u , v , c (1 ≤ u,v ≤ n , 1 ≤ c ≤ 10^5)。
 * 输出描述：
 * 对于每次行程求出购买的次数
 * 输入
 * 5 4
 * 3 5 1 2 4
 * 1 2
 * 1 3
 * 2 4
 * 3 5
 * 4 2 1
 * 4 2 2
 * 4 2 3
 * 5 1 5
 */
public class P1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [] a1 = new int[m];
        int [][] a2 = new int[m-1][2];
        int [][] a3 = new int[n][3];
        for (int i=0;i<m;i++) {
            a1[i] = sc.nextInt();
        }
        for (int i=0;i<m-1;i++) {
            a2[i][0] = sc.nextInt();
            a2[i][1] = sc.nextInt();
        }
        for (int i=0;i<n;i++) {
            a3[i][0] = sc.nextInt();
            a3[i][1] = sc.nextInt();
            a3[i][2] = sc.nextInt();
        }
        for (int i=0;i<a3.length;i++) {
            int value = getValue(a3[i][0],a3[i][1],a3[i][2],a1,a2);
            System.out.println(value);
        }
    }
    public static int getValue(int a30,int a31,int a32,int [] a1,int [][] a2) {
        int temp = 0;
        for (int j=0;j<a2.length;j++) {
            if (a30 == a2[j][0]) {
                if (a32 < a1[a2[j][0]-1]) {
//                    a32 += a1[a2[j][0]-1];
                    temp += 1;
                }
                if (a31 == a2[j][1]) {
                    if (a32 < a1[a2[j][1]-1]) {
//                        a32 += a1[a2[j][1]-1];
                        temp += 1;
                    }
                    break;
                } else {
                    getValue(a2[j][1],a31,a32,a1,a2);
                }
            } else if (a30 == a2[j][1]) {
                if (a32 < a1[a2[j][1]-1]) {
//                    a32 += a1[a2[j][1]-1];
                    temp += 1;
                }
                if (a31 == a2[j][0]) {
                    if (a32 < a1[a2[j][0]-1]) {
//                        a32 += a1[a2[j][0]-1];
                        temp += 1;
                    }
                    break;
                } else {
                    getValue(a2[j][0],a31,a32,a1,a2);
                }
            }
        }
        return temp;
    }
}