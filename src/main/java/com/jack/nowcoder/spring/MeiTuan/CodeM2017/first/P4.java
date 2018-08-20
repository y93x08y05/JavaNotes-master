package com.jack.nowcoder.spring.MeiTuan.CodeM2017.first;

import java.util.Scanner;

/**
 * 美团外卖的配送员用变速跑的方式锻炼身体。
 * 他们锻炼的方式是n个人排成一列，每两个人之间间隔u米，每个人正常速度均为um/s。
 * 当某个配送员排在最后的时候，他需要以当时自己的最高速度往前跑，知道超过排头的
 * 人u米，然后降回到原始速度v米/秒，每个人最初的最高速度为c[i]米每秒。每轮衰减d[i]
 * 米每秒，如果i是第j个跑的，那么他的速度就是c[i]-(j-1)*d[i] 米/秒。
 * n个人初始以随机的顺序排列，每种排序的概率完全相等，跑完一轮即每个人都追到排头一次
 * 序列恢复原始的期望需要的时间是多少
 * 输入描述：
 * 第一行整数n（<=1000）, 实数v(<=100) , 实数u(<=10)
 * 第二行n个实数每个人的速度c[i](<=50000)
 * 第三行n个实数值每个人衰减量d[i](<=10)
 * 输入数据保证每个人的速度不会衰减到<=v
 * 输出保留3位小数。
 * 输入
 * 10 37.618 0.422
 * 72.865 126.767 202.680 106.102 99.516 134.418 167.952 173.646 120.210 136.571
 * 2.941 3.664 7.363 4.161 0.246 8.046 5.521 7.473 7.178 5.649
 * 输出0.815
 */
public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double v = sc.nextDouble();
        double u = sc.nextDouble();
        double [] c = new double[n];
        double [] d = new double[n];
        for (int i=0;i<n;i++) {
            c[i] = sc.nextDouble();
        }
        for (int i=0;i<n;i++) {
            d[i] = sc.nextDouble();
        }
        double res = 0;
        for (int j=0;j<n;j++) {
            for (int i=0;i<n;i++) {
                res+=u/(c[i]-j*d[i]-v);
            }
        }
        System.out.println(String.format("%.3f",res));

    }
}