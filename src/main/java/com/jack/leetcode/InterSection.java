package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/7 23:38
 * LeetCode 349
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 例1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 例2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
public class InterSection {
    public static void main(String[] args) {
        int []num1={1,2,2,1};
        int []num2={2,2};
        intersection(num1,num2);
    }
    private static int []intersection(int []num1,int []num2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for (int i:num1)
            list1.add(i);
        for (int i:num2)
            list2.add(i);
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<list1.size();i++) {
            if (list2.contains(list1.get(i))) {
                set.add(list1.get(i));
            }
        }
        int []arr=new int[set.size()];
        int j=0;
        for (int i:set)
            arr[j++]=i;
        return arr;
    }
}