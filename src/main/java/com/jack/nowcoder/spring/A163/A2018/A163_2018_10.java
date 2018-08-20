package com.jack.nowcoder.spring.A163.A2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangta on 1/8/2018.
 * 一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d,
 * 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 有一个长度为n的数列x,想把x变为一个等差数列
 * 允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次
 * 有些数列通过交换还是不能变成等差数列,判别一个数列是否能通过交换操作变成等差数列
 * 输入包括两行:
 * 第一行包含整数n(2 ≤ n ≤ 50),即数列的长度
 * 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数
 * 如果可以变成等差数列输出"Possible",否则输出"Impossible"
 * 输入例子
 * 3
 * 3 1 2
 * 输出例子
 * Possible
 */
public class A163_2018_10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num ;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        boolean flag = true;
        int d = arr[1] - arr[0];
        for(int i = 2;i<arr.length;i++){
            if(arr[i] - arr[i-1] != d){
                flag = false;
            }
        }
        if(flag){
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");
        }
    }
}
