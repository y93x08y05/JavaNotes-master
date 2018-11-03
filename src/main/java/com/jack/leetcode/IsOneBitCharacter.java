package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 20:57
 * LeetCode 717
 * 1比特与2比特字符
 * 有两种特殊字符。第一种字符可以用一比特0来表示。
 * 第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。
 * 问最后一个字符是否必定为一个一比特字符。
 * 给定的字符串总是由0结束。
 * 例1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 例2:
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 */
public class IsOneBitCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new IsOneBitCharacter().find(arr));
    }
    public boolean find(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }
        return i == arr.length - 1;
    }
}