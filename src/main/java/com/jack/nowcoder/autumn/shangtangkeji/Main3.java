package com.jack.nowcoder.autumn.shangtangkeji;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/15 19:59
 * 在深度学习等异构高性能并行计算领域，经常面临计算资源调度问题，对系统模型进行简化
 * 一共有m台机器，每台机器包含存储和计算单元，令M_i为第i台机器的内存容量
 * 一共需要同时运行P个程序，令P_i表示第i个程序运行所需要的内存空间。
 * 给定一个矩阵表示第i台机器运行第j个程序能达到的浮点峰值性能
 * 若假设每台机器只能运行一个程序，求一个进程调度策略。同时运行P个程序
 * 即对每个程序，分配到机器上，使得系统总体浮点峰值性能达到最大。
 * 若机器内存小于程序所需要内存空间，则此程序不能在此机器上运行，若不存在这样的
 * 调度方式，则返回-1.
 * 输入描述：
 * 第一行输入整数P和M，为程序数目及机器数目。
 * 接下来P行，每行一个整数，表示第i个程序的内存占用量。
 * 接下来M行，每行一个整数，表示第j个机器的内存容量。
 * 接下来P行，每行M个整数，为第i个程序在第j个机器上运行的浮点峰值。
 * 输出描述：
 * 输出一个整数表示当前配置下，系统能达到的最高浮点峰值，返回-1表示调度方案不存在
 * 输入：
 * 2 3
 * 1
 * 1
 * 2
 * 2
 * 2
 * 10 20 30
 * 1 2 3
 * 输出：
 * 32
 * 输入：
 * 1 1
 * 2
 * 1
 * 10
 * 输出：
 * -1
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int M = sc.nextInt();
        int []arrP = new int[P];
        int []arrM = new int[M];
        for (int i = 0; i < P; i++)
            arrP[i] = sc.nextInt();
        for (int i = 0; i < M; i++)
            arrM[i] = sc.nextInt();
        int [][]arrPM = new int[P][M];
        for (int i = 0; i < P; i++)
            for (int j = 0; j < M; j++)
                arrPM[i][j] = sc.nextInt();
        System.out.println(find(arrP, arrM, arrPM));
    }
    public static int find(int []arrP, int []arrM, int [][]arrPM) {
        return -1;
    }
}