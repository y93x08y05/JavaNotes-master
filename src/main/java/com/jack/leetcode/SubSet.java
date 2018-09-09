package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 13:32
 * LeetCode 78
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class SubSet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        findAllSubSet(arr);
    }
    private static List<List<Integer>> findAllSubSet(int []arr) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        if (arr.length==0||arr==null)
            return res;
        helper(res,temp,arr,0);
        return res;
    }
    private static void helper(List<List<Integer>> lists,List<Integer> list,int []arr,int index) {
        lists.add(new ArrayList<>(list));
        for (int i=index;i<arr.length;i++) {
            list.add(arr[i]);
            helper(lists,list,arr,i+1);
            list.remove(list.size()-1);
        }
    }
}