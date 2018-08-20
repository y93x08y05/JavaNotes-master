package com.jack.nowcoder.spring.A163.A2017;

import java.util.Scanner;

/**
 * 小易有n块砖块，每一块砖块有一个高度。
 * 小易希望利用这些砖块堆砌两座相同高度的塔。为了让问题简单，
 * 砖块堆砌就是简单的高度相加，某一块砖只能使用在一座塔中一次。
 * 小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢
 * 输入描述
 * 输入包括两行： 第一行为整数n(1 ≤ n ≤ 50)，即一共有n块砖块
 * 第二行为n个整数，表示每一块砖块的高度height[i] (1 ≤ height[i] ≤ 500000)
 * 输出描述
 * 如果小易能堆砌出两座高度相同的塔，输出最高能拼凑的高度，
 * 如果不能则输出-1. 保证答案不大于500000。
 * 3 2 3 5
 * 5
 */
public class A163_2017_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
            sum += h[i];
        }
        int[] dp0 = new int[sum * 2 + 1];
        int[] dp1 = new int[sum * 2 + 1];
        // dp0表示上次放砖时各个位置的情况，dp1表示这次放砖时应该变成的情况
        // dp平移sum位是因为B堆-A堆高度的范围在-sum至sum之间，所以平移sum位以便存储每个的值
        // 所以也就是说j下标为sum时表示A、B堆高度相同时的情况，往左就是B堆较高的情况，往右就是A堆较高的情况
        for (int i = 0; i < sum * 2 + 1; i++)
            dp0[i] = -1;
        dp0[sum] = 0;
        for (int i = 1; i <= n; i++) {
            int hg = h[i - 1];
            // j表示B堆-A堆的高度差（由于平移的原因，sum即为0，往左一次加1，往右依次减1）
            // dp1[j]存放的值表示B目前所能存放的最大高度
            // dp1[j]是在上次的基础上（也就是dp0）进行变换的
            for (int j = 0; j < 2 * sum + 1; j++) {
                dp1[j] = dp0[j];
                if (j - hg >= 0 && dp0[j - hg] != -1) {
                    dp1[j] = Math.max(dp0[j - hg], dp1[j]);
                }
                if (j + hg <= 2 * sum && dp0[j + hg] != -1) {
                    dp1[j] = Math.max(dp0[j + hg] + hg, dp1[j]);
                }
            }
            // 交换两个数组，确保dp0一直是上次的状态
            int[] t = dp0;
            dp0 = dp1;
            dp1 = t;
        }
        // 最后一次变换完为dp0，所以对dp0进行求解
        if (dp0[sum] == 0)
            System.out.println(-1);
        else
            System.out.println(dp0[sum]);
    }
}