package com.jack.nowcoder.spring.MeiTuan.CodeM2018.first;

/**
 * 美团在吃喝玩乐等很多方面都给大家提供了便利。最近又增加了一项新业务：小象生鲜。
 * 这是新零售超市，你既可以在线下超市门店选购生鲜食品，也可以在手机App上下单，
 * 最快30分钟就配送到家。新店开张免不了大优惠。
 * 我们要在小象生鲜超市里采购n个物品，每个物品价格为ai，有一些物品可以选择八折优惠
 * （称为特价优惠）。
 * 有m种满减优惠方式，满减优惠方式只有在所有物品都不选择特价优惠时才能使用，
 * 且最多只可以选择最多一款。
 * 每种满减优惠描述为(bi,ci)，即满bi减ci（当消费>=bi时优惠ci）。
 * 求要买齐这n个物品（必须一单买齐），至少需要多少钱（保留两位小数）。
 * 输入描述
 * 第一行，两个整数n,m。
 * 接下来n行，每行一个整数ai，以及一个0/1表示是否可以选择特价优惠(1表示可以)。
 * 接下来m行，每行表示两个整数，bi，ci，描述一个满减优惠。
 * 1<=n,m<10
 * 1<=a1<=100
 * 1<=ci<bi<=1000
 * 输出描述
 * 一行一个实数，表示至少需要消耗的钱数(保留刚好两位小数)。
 * 实例1
 * 输入
 * 2 1
 * 6 1
 * 10 1
 * 12 2
 * 输出 12.80
 * 实例2
 * 输入
 * 2 2
 * 6 1
 * 10 1
 * 5 1
 * 16 6
 * 输出 10.00
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class P1 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int [] a1_1 = new int[a1];
        int [] a1_2 = new int[a1];
        int [] a2_1 = new int[a2];
        int [] a2_2 = new int[a2];
        double min = 0;
        int sum = 0;
        for (int i=0;i<a1;i++){
            a1_1[i] = scanner.nextInt();
            a1_2[i] = scanner.nextInt();
        }
        for (int i=0;i<a2;i++){
            a2_1[i] = scanner.nextInt();
            a2_2[i] = scanner.nextInt();
        }
        for (int i=0;i<a1;i++){
            if (a1_2[i] == 1) {
                min += (double)a1_1[i]*4/5;
                sum += a1_1[i];
            }else {
                min += (double)a1_1[i];
                sum += a1_1[i];
            }
        }
        for (int i=0;i<a2;i++){
            int temp = sum;
            if (temp >= a2_1[i]){
                temp-=a2_2[i];
                min = temp<min?temp:min;
            }
        }
        System.out.println(new DecimalFormat("######0.00").format(min));
    }
}