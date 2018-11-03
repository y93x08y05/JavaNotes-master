package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 8:06 PM
 * LeetCode 40
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 例1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 例2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();
        System.out.println(findAllCombination(arr, n).size());
    }
    private static List<List<Integer>> findAllCombination(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(arr);
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] > target)
                break;
            while (i > 0 && i < length && arr[i] == arr[i - 1])
                i++;
            if (i >= length)
                break;
            temp.add(arr[i]);
            DiGui(res, i + 1, arr[i], temp, arr, target);
            temp.clear();
        }
        return res;
    }
    private static void DiGui(List<List<Integer>> res, int index, int count, List<Integer> temp, int[] arr, int target) {
        if (count >= target) {
            if (count == target) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }
        for (int i = index; i < arr.length; i++) {
            while (i > index && i < arr.length && arr[i] == arr[i - 1])
                i++;
            if (i >= arr.length)
                break;
            if (count +  arr[i] > target)
                break;
            temp.add(arr[i]);
            DiGui(res, i + 1, count + arr[i], temp, arr, target);
            temp.remove(temp.size() - 1);
        }
    }
}
