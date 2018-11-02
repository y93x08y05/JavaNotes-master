package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jack on 8/18/2018 12:45 PM
 * LeetCode 15
 * 给定一个包含n个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class NumberSumThree {
    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> i : findSumThree1(num))
            System.out.println(i);
        for (List<Integer> i : findSumThree2(num))
            System.out.println(i);
    }

    /**
     * time complexity O(n^3)
     * @param arr
     * @return
     */
    private static List<List<Integer>> findSumThree1(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                for (int k = j + 1; k < arr.length; k++) {
                    if (k > j + 1 && arr[k] == arr[k - 1])
                        continue;
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        lists.add(list);
                        break;
                    }
                }
            }
        }
        return lists;
    }
    private static List<List<Integer>> findSumThree2(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            while (left < right) {
                int sum = arr[left] + arr[right] + arr[i];
                if (sum == 0) {
                    lists.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }
}
