package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/8 13:07
 * LeetCode 90
 * 给定一个可能包含重复元素的整数数组 nums，
 * 返回该数组所有可能的子集（幂集）。
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubSetWithDup {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findSubSet1(arr));
        System.out.println(findSubSet2(arr));
    }
    private static List<List<Integer>> findSubSet1(int []arr) {
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(arr);
        helper(lists,new ArrayList<>(),arr,0);
        return lists;
    }
    //链表超时
    private static List<List<Integer>> findSubSet2(int []arr) {
        List<List<Integer>> res=new LinkedList<>();
        res.add(new ArrayList<>());
        int len=arr.length;
        Arrays.sort(arr);
        for (int i=0;i<len;) {
            LinkedList<List<Integer>> temp=new LinkedList<>();
            for (List<Integer> list:res) {
                List<Integer> list1=new ArrayList<>(list);
                list1.add(arr[i]);
                temp.add(list1);
            }
            i++;
            while (i<len&&arr[i]==arr[i-1]) {
                int size=temp.size();
                while (size-->0) {
                    List<Integer> current=temp.removeFirst();
                    res.add(current);
                    List<Integer> moreCurrent=new ArrayList<>(current);
                    moreCurrent.add(arr[i]);
                    temp.add(moreCurrent);
                }
            }
            res.addAll(temp);
        }
        return res;
    }
    private static void helper(List<List<Integer>> lists,List<Integer> list,int []arr,int start) {
        lists.add(new ArrayList<>(list));
        for (int i=start;i<arr.length;i++) {
            if (i>start&&arr[i]==arr[i-1])
                continue;
            list.add(arr[i]);
            helper(lists,list,arr,i+1);
            list.remove(list.size()-1);
        }
    }
}