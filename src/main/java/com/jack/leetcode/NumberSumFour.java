package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jack on 8/18/2018 1:34 PM
 * LeetCode 18
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 答案中不可以包含重复的四元组。
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class NumberSumFour {
    public static void main(String[] args) {
        int [] arr = {1,0,-1,0,-2,2};
        int target = 0;
        for (List<Integer> i : findSumFour(arr,target))
            System.out.println(i);
    }
    private static List<List<Integer>> findSumFour(int [] arr,int target) {
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        if (arr.length<=3)
            return lists;
        Arrays.sort(arr);
        int sum;
        for (int i=0;i<arr.length-3;i++) {
            for (int j=i+1;j<arr.length-2;j++) {
                int low=j+1;
                int high=arr.length-1;
                while (low<high) {
                    sum=arr[i]+arr[j]+arr[low]+arr[high];
                    if (sum==target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[low]);
                        list.add(arr[high]);
                        if (!set.contains(list)) {
                            set.add(list);
                            lists.add(list);
                        }
                        low++;
                        high--;
                    } else {
                        if (sum<target)
                            low++;
                        else
                            high--;
                    }
                }
            }
        }
        return lists;
    }
}
