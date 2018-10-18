package com.jack.nowcoder.autumn.shangtangkeji;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/15 18:46
 * 有一天小商和小汤发现了一个藏宝地点，宝藏埋在该地地下M米的地方。
 * 为了在尽可能节省体力的情况下挖到宝藏，小商和小汤约定挖一个只允许一人
 * 通行的洞，然后两个人轮流向下挖。由于小商和小汤天生的体质差异。
 * 小商每次只能连续向下挖最多A米，小汤每次只能连续向下挖最多B米，
 * 两个人每次挖的深度一定是一个正整数，因为小商认为先挖的人有优势
 * 他抢着成为了第一个挖到宝藏的人，但是你能用科学的计算方式告诉他
 * 他是不是一定能挖到宝藏？
 * 输入描述：
 * 首先第一行两个以空格分隔的正整数A和B，A和B<=10000
 * 然后第二行是一个正整数K，代表有K组测试数据，K<=100000
 * 接下来第三行有K个以空格分隔的正整数Mi，每个正整数代表宝藏埋在地下Mi米的情况
 * Mi<=100000000
 * 输出描述：
 * 一行以空格分隔的整数Ni，表示对于每个Mi，输出谁一定能先挖到宝藏。
 * 1代表小商，-1代表小汤，0代表不能确定谁先挖到。
 * 最后一个结果输出不需要添加空格和回车
 * 输入：
 * 1 1
 * 4
 * 1 2 3 4
 * 输出：
 * 1 -1 1 -1
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();
        int [] arr = new int[K];
        for (int i = 0; i < K; i++)
            arr[i] = sc.nextInt();
        if (A == 0 || B == 0)
            System.out.print(0);
        else
            find(A, B, arr);
    }
    public static void find(int A, int B, int []arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {
                find(A, B, arr[i]);
            } else {
                find(A, B, arr[i]);
                System.out.print(" ");
            }
        }
    }
    public static void find(int A, int B, int val) {
        int sum = A + B;
        if (val % sum == 0) {
            if (val >= sum) {
                System.out.print(-1);
            } else {
                if (val <= A)
                    System.out.print(1);
                else
                    System.out.print(-1);
            }
        } else {
            int yu = val % sum;
            if (yu <= A)
                System.out.print(1);
            else
                System.out.print(-1);
        }
    }
}