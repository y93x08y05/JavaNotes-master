package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/10/6 9:51
 * LeetCode 442
 * 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）,
 * 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 */
public class FindDuplicatesNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
    }
    public List<Integer> find(int []arr) {
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<arr.length;i++) {
            if (set.contains(arr[i]))
                list.add(arr[i]);
            else
                set.add(arr[i]);
        }
        return list;
    }
}