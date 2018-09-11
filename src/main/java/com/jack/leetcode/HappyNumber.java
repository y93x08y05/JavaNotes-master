package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 17:48
 * LeetCode 202
 * 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * 例：
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isHappy(n));
    }
    private static boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        if(n < 1) {
            return false;
        }
        int count = 0;
        while(n != 1) {
            String s = n+"";
            char [] arr = s.toCharArray();
            int sum = 0;
            for(int i=0;i<arr.length;i++) {
                sum += Math.pow(Integer.parseInt(arr[i]+""),2);
            }
            n = sum;
            count++;
            if(count > 1000) {
                return false;
            }
        }
        return true;
    }
}