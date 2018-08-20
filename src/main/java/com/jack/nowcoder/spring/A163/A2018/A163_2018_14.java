package com.jack.nowcoder.spring.A163.A2018;

import java.util.*;

/**
 * Created by zhangta on 1/8/2018.
 * 将n个棋子摆放在一张无限大的棋盘上，第i个棋子放在第x[i]行y[i]列
 * 同一个格子允许放置多个棋子，每一次操作可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子
 * 知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数
 * 输入包括三行：
 * 第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
 * 第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 * 第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)
 * 输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格
 * 对于1个棋子: 不需要操作
 * 对于2个棋子: 将前两个棋子放在(1, 1)中
 * 对于3个棋子: 将前三个棋子放在(2, 1)中
 * 对于4个棋子: 将所有棋子都放在(3, 1)中
 * 输入
 * 4
 * 1 2 4 9
 * 1 1 1 1
 * 输出
 * 0 1 3 10
 */
public class A163_2018_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i ++) {
                x[i] = in.nextInt();
            }
            for (int i = 0; i < n; i ++) {
                y[i] = in.nextInt();
            }
            List<Long> res = new ArrayList<>();
            long min, sum;
            for (int i = 1; i <= n; i ++) {
                min = Long.MAX_VALUE;
                for (int row = 0; row < n; row ++) {
                    for (int col = 0; col < n; col ++) {
                        sum = 0;
                        PriorityQueue<Integer> pq = new PriorityQueue<>(i, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                                return o2 - o1;
                        }
                        });
                        for (int c = 0; c < n; c ++) {
                            int xc = x[c];
                            int yc = y[c];
                            int distance = Math.abs(xc - x[row]) + Math.abs(yc - y[col]);
                            sum += distance;
                            pq.add(distance);
                            if (pq.size() > i) {
                                sum -= pq.poll();
                            }
                        }
                        min = Math.min(min, sum);
                    }
                }
                res.add(min);
            }
            for (int i = 0; i < n - 1; i ++) System.out.print(res.get(i) + " ");
            System.out.println(res.get(n - 1));
        }
    }
}
