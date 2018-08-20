package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/6/2018.
 * 射击游戏在二维平面进行，A在坐标原点(0,0),平面上n只怪物
 * 每个怪物有坐标(x[i],y[j])
 * 一次射击会把x轴和y轴上怪物一次消灭
 * A的特权：
 * 1、让平面内的所有怪物同时向任意同一方向移动任意同一距离
 * 2、让平面内的所有怪物同时对于小易(0,0)旋转任意同一角度
 * 射击前可对特权操作任意次
 * 计算射击时最多可射击怪物数量
 * 输入包括三行
 * 第一行中有一个正整数n(1 ≤ n ≤ 50),表示平面内的怪物数量
 * 第二行包括n个整数x[i](-1,000,000 ≤ x[i] ≤ 1,000,000),表示每只怪物所在坐标的横坐标,以空格分割
 * 第二行包括n个整数y[i](-1,000,000 ≤ y[i] ≤ 1,000,000),表示每只怪物所在坐标的纵坐标,以空格分割
 * 输出一个整数表示A最多能消灭多少只怪物
 * 输入
 * 5
 * 0 -1 1 1 -1
 * 0 -1 -1 1 1
 * 输出
 * 5
 */
public class A163_2018_8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = scan.nextInt();
        for (int i = 0; i < n; i++)
            y[i] = scan.nextInt();
        scan.close();
        int maxShoot = 0;//在坐标轴上的点
        if (n < 4)
            maxShoot = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int X1 = x[j] - x[i];
                int Y1 = y[j] - y[i];
                for (int k = 0; k < n; k++) {
                if (k == i || k == j)
                    continue;
                    int count = 3;
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k)
                            continue;
                        int X2 = x[l] - x[k];
                        int Y2 = y[l] - y[k];
                        int X3 = x[l] - x[i];
                        int Y3 = y[l] - y[i];
                        if (X1 * X2 + Y1 * Y2 == 0 || X1 * Y3 == X3 * Y1)
                            count++;
                    }
                    if (count > maxShoot)
                        maxShoot = count;
                }
            }
        }
        System.out.println(maxShoot);
    }
}

