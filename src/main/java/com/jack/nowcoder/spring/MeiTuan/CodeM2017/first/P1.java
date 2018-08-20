package com.jack.nowcoder.spring.MeiTuan.CodeM2017.first;

import java.util.Scanner;

/**
 * 有一个大水缸，里面水的温度为T单位，体积为C升。另有n杯水
 * 假设每个杯子的容量是无限的，每杯水的维度为t[i]单位，体积为
 * c[i]升。现在要把大水缸的水倒入n杯水中，使得n杯水的温度相同，
 * 请问这可能吗？并求出可行的最高温度，保留4位小数。
 * 一杯温度为t1单位、体积为c1升的水与另一杯温度为t2单位、体积为
 * c2升的水混合后，温度变为（t1*c1+t2*c2）/(c1+c2),体积变为c1+c2。
 * 输入描述：
 * 第一行一个整数n,1<=n<=10^5
 * 第二行两个整数T，C，其中0<=T<=10^4，0<=T<=10^9。
 * 接下来n行每行两个整数t[i]，c[i]。0<=t[i],c[i]<=10^4
 * 输出描述：
 * 如果非法，输出“Impossible”，否则第一行输出Possible，第二行输出
 * 一个保留4位小数的实数表示答案。
 * 样例解释：往第二杯水中倒0.5升水，往第三杯水中倒1升水
 * 三杯水的温度都变成了20
 * 输入
 * 3
 * 10 2
 * 20 1
 * 25 1
 * 30 1
 * 输出
 * Possible
 * 20.0000
 */
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int C = sc.nextInt();
        int [][] water = new int[n][2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            water[i][0] = sc.nextInt();
            water[i][1] = sc.nextInt();
            if (water[i][0] > max) {
                max = water[i][0];
            }
            if (water[i][0] < min) {
                min = water[i][0];
            }
        }
        if (min <= T && max >=T) {
                if (min == max) {
                    System.out.println("Possible\n"+String.format("%.4f",(double)min));
                } else {
                    System.out.println("Impossible");
                }
        } else {
            if (T < min) {
                double sum = 0;
                for (int i=0;i<n;i++) {
                    if (water[i][0] > min) {
                        sum +=(double)water[i][1]*(water[i][0]-min)/(min-T);
                    }
                    if (sum > C) {
                        break;
                    }
                }
                if (sum > C) {
                    System.out.println("Impossible");
                } else {
                    System.out.println("Possible\n"+String.format("%.4f",(double)min));
                }
            } else {
                double sum = 0;
                long sut = 0;
                long stc = 0;
                for (int i=0;i<n;i++) {
                    sut += water[i][0]*water[i][1];
                    stc += water[i][1];
                    if (water[i][0] < max) {
                        sum += (double)water[i][1] * (water[i][0] - min) / (min - T);
                    }
                    if (sum > C) {
                        break;
                    }
                }
                if (sum > C) {
                    System.out.println("Impossible");
                } else if (sum == C) {
                    System.out.println("Possible\n"+String.format("%.4f",(double)max));
                } else {
                    double res = (sut+(double)T*C)/(stc+C);
                    System.out.println("Possible\n"+String.format("%.4f",(double)res));
                }
            }
        }
    }
}