package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/1/16 10:50
 * LeetCode 229
 * 给定一个大小为N的数组，找出其中所有出现超过[N/3]次的元素
 * 要求时间复杂度为O(n)，空间复杂度为O(1)
 * 例1：
 * 输入[3,2,3]
 * 输出[3]
 * 例2：[1,1,1,3,3,2,2,2]
 * 输出[1,2]
 */
public class MajorityElement2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MajorityElement2 majorityElement2 = new MajorityElement2();
        System.out.println(majorityElement2.find(arr));
    }
    private List<Integer> find(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int m1 = nums[0];
        int m2 = 0;
        int c1 = 1;
        int c2 = 0;
        for (int x : nums) {
            if (x == m1)
                ++c1;
            else if (x == m2) {
                ++c2;
            } else if (c1 == 0) {
                m1 = x;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = x;
                c2 = 1;
            } else {
                --c1;
                --c2;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (m1 == num)
                ++c1;
            else if (m2 == num)
                ++c2;
        }
        if (c1 > nums.length / 3)
            res.add(m1);
        if (c2 > nums.length / 3)
            res.add(m2);
        return res;
    }
}