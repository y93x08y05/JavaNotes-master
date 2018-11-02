package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/20 11:25
 * LeetCode 697
 * 数组的度
 * 给定一个非空且只包含非负数的整数数组nums,
 * 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * 例1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1],
 * [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *例2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */
public class ShortestSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findShortestSubArray1(arr));
        System.out.println(findShortestSubArray2(arr));
    }
    private static int findShortestSubArray1(int[] arr) {
        int minLength = 50000;
        int currentLength;
        int maxFrequency = 0;
        int[] frequency = new int[50001];
        int[] pos = new int[50001];
        if (arr.length == 1)
            return 1;
        for (int i = 1; i < arr.length + 1; i++) {
            if (pos[arr[i - 1]] != 0) {
                frequency[arr[i - 1]]++;
                currentLength = i - pos[arr[i - 1]] + 1;
                if (frequency[arr[i - 1]] > maxFrequency) {
                    maxFrequency = frequency[arr[i - 1]];
                    minLength=currentLength;
                } else if (frequency[arr[i - 1]] == maxFrequency) {
                    minLength = currentLength < minLength ? currentLength : minLength;
                }
            } else {
                pos[arr[i - 1]] = i;
            }
        }
        if (maxFrequency == 0) {
            return 1;
        }
        return minLength;
    }
    private static int findShortestSubArray2(int[] arr) {
        Map<Integer, Integer> mapStart = new HashMap<>();
        Map<Integer, Integer> mapEnd = new HashMap<>();
        Map<Integer, Integer> mapCount = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!mapCount.containsKey(arr[i])) {
                mapCount.put(arr[i], 0);
                mapStart.put(arr[i], i);
            }
            mapCount.put(arr[i], mapCount.get(arr[i]) + 1);
            mapEnd.put(arr[i], i);
            maxCount=Math.max(maxCount, mapCount.get(arr[i]));
        }
        int minLength = Integer.MAX_VALUE;
        for (Integer key : mapCount.keySet()) {
            if (mapCount.get(key) == maxCount) {
                minLength = Math.min(minLength, mapEnd.get(key) - mapStart.get(key) + 1);
            }
        }
        return minLength;
    }
}