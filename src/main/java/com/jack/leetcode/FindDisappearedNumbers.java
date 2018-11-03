package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/10/6 9:41
 * LeetCode 448
 * 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
 * 数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new FindDisappearedNumbers().find(arr));
    }
    private List<Integer> find(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);
        for (int i = 0; i < arr.length; i++)
            if (!set.contains(i + 1))
                list.add(i + 1);
        return list;
    }
}