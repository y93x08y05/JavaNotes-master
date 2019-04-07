package com.jack.nowcoder.spring.A163.SpringJob2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/4/7 13:17
 * 电话号码个数统计，
 * 题目描述：
 * 有一批电号码有重复，不超过一亿个。每个号码为8位数字，请设计一个
 * 高效算法来统计不同号码的个数。
 * 输入描述：
 * 第一行是号码的总个数，后边每一行是一个8位的号码。
 * 输出描述：
 * 去重后的号码个数。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0 ) {
            System.out.println(0);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                if (!list.contains(value))
                    list.add(value);
            }
            System.out.println(list.size());
        }
    }
}