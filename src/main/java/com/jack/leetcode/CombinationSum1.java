package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 7:46 PM
 * LeetCode 39
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 例1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 例2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [] arr = new int[m];
        for (int i=0;i<m;i++)
            arr[i] = sc.nextInt();
        System.out.println(findAllCombination(arr, n).size());
    }
    private static List<List<Integer>> findAllCombination(int [] arr,int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(arr);
        DiGui(res,0,0,temp,arr,target);
        return res;
    }
    private static void DiGui(List<List<Integer>> res,int currentIndex,int count,List<Integer> temp,int [] arr,int target) {
        if (count>=target) {
            if (count==target)
                res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=currentIndex;i<arr.length;i++) {
            if (count+arr[i]>target)
                break;
            temp.add(arr[i]);
            DiGui(res,i,count+arr[i],temp,arr,target);
            temp.remove(temp.size()-1);
        }
    }
}
