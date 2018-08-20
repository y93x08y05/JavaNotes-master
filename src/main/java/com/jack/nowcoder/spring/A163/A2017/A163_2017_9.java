package com.jack.nowcoder.spring.A163.A2017;

import java.util.Scanner;

/**
 * 小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，
 * 小易现在要用他喜欢的红色去涂画棋盘。
 * 小易会找出棋盘中某一列中拥有相同颜色的最大的区域去涂画，即相同颜色的块相邻
 * 帮助小易算算他会涂画多少个棋格。
 * 输入描述
 * 输入数据包括n+1行：
 * 第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小
 * 接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色
 * 输出描述
 * 输出小易会涂画的区域大小
 * 输入
 * 3 BWW BBB BWB
 * 输出
 * 3
 */
public class A163_2017_9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = scan.next();
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                int c = 1;
                for (int i = 0; i < n - 1; i++) {
                    if (str[i].charAt(j) == str[i + 1].charAt(j)) {
                        c++;
                        count = Math.max(c, count);
                    } else {
                        c = 1;
                    }
                }

            }
            System.out.println(count);
        }
        scan.close();
    }
}