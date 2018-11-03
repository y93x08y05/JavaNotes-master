package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 14:57
 * LeetCode 645
 * 集合S包含从1到n的整数。
 * 不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
 * 导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组nums代表了集合S发生错误后的结果。
 * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，
 * 将它们以数组的形式返回。
 * 例子1：
 * 输入: num = [1,2,2,4]
 * 输出: [2,3]
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 */
public class ErrorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = findError(arr);
        System.out.println(res[0] + " " + res[1]);
    }
    private static int[] findError(int[] arr) {
        int[] temp = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                temp[0] = arr[i];
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(i + 1)) {
                temp[1] = i + 1;
            }
        }
        return temp;
    }
}