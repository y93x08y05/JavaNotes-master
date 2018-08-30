package com.jack.nowcoder.autumn.creditCardCenter.test2019;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 2:33 PM
 * 给定一个正整数数组，第i个元素是比特币第i天的价格
 * 如果最多只允许完成一笔交易，设计算法计算所能获得的最大收益是多少
 * 输入描述
 * 正整数数组，为以空格分隔的N个数组
 * 输出描述
 * 最大利润
 * 输入
 * 7 1 5 3 6 4
 * 输出
 * 5
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(" ");
        int [] arr=new int[str.length];
        for (int i=0;i<str.length;i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(findMaxProfit(arr));
    }
    private static int findMaxProfit(int [] arr) {
        int sum = 0;
        //遍历查找最大的收益度
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[j]-arr[i]>sum)
                    sum=arr[j]-arr[i];
            }
        }
        return sum;
    }
}
