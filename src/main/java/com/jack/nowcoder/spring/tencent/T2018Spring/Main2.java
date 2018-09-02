package com.jack.nowcoder.spring.tencent.T2018Spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 9/1/2018 9:42 AM
 * 牛牛和羊羊正在玩一个纸牌游戏。
 * 这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出,
 * 直到纸牌被抽完。他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略,
 * 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 * 输入描述：
 * 输入包括两行
 * 第一行包括一个正整数n，表示纸牌的数量
 * 第二行包括n个正整数ai，表示每张纸牌上的数字
 * 输出描述：
 * 输出一个整数表示游戏接受后牛牛得分减去羊羊得分等于多少
 * 输入例子1：
 * 3
 * 2 7 4
 * 输出例子1：
 * 5
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findScore0(arr, n));
        System.out.println(findScore1(arr, n));
    }
    private static long findScore0(int []arr, int n) {
        Arrays.sort(arr);
        long sum=0;
        for (int i=n-1;i>=0;i--) {
            sum+=((n+i)%2*2-1)*arr[i];
        }
        return sum;
    }
    private static long findScore1(int []arr, int n) {
        Arrays.sort(arr);
        long sum=0;
        if (arr.length%2==0) {
            for (int i=1;i<arr.length;i=i+2) {
                sum+=(arr[i]-arr[i-1]);
            }
        } else {
            sum+=arr[0];
            for (int i=2;i<arr.length;i=i+2) {
                sum+=(arr[i]-arr[i-1]);
            }
        }
        return sum;
    }
}
