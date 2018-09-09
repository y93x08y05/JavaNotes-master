package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 3:23 PM
 * LeetCode 268
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，
 * 找出 0 .. n 中没有出现在序列中的那个数。
 * 例1:
 * 输入: [3,0,1]
 * 输出: 2
 * 例2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */
public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int [] arr = new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        System.out.println(missingNumber(arr));
    }
    private static int missingNumber(int [] arr) {
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++) {
           if (arr[i] != i)
               return i;
        }
        return arr[arr.length-1]+1;
    }
}
