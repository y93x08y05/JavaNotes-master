package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 14:50
 * LeetCode 287
 * 给定一个包含n+1个整数的数组nums，其数字都在1到n之间（包括1和n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 * 例子1
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 例子2
 * 输入: [3,1,3,4,2]
 * 输出: 3
 */
public class DuplicateArrayElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findDuplicate(arr));
    }
    private static int findDuplicate(int []arr) {
        Arrays.sort(arr);
        for (int i=0;i<arr.length-1;i++) {
            if (arr[i]==arr[i+1])
                return arr[i];
        }
        return 0;
    }
}