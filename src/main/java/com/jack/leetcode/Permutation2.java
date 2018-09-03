package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 9/2/2018 5:56 PM
 * LeetCode 47
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Permutation2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        permuteUnique0(arr);
        permuteUnique1(arr);
    }
    private static List<List<Integer>> permuteUnique0(int []arr) {
        List<List<Integer>> lists=new ArrayList<>();
        if (arr==null||arr.length==0)
            return lists;
        boolean []used=new boolean[arr.length];
        List<Integer> list=new ArrayList<>();
        Arrays.sort(arr);//利于判断重复值
        dfs0(arr,used,list,lists);
        return lists;
    }
    private static void dfs0(int []arr, boolean []used, List<Integer> list, List<List<Integer>> lists) {
        if (list.size()==arr.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<arr.length;i++) {
            if (used[i])//如果该元素已经被使用过则继续遍历
                continue;
            //下一个重复值只有在前一个重复值被使用的情况下才可以使用
            if (i>0&&arr[i-1]==arr[i]&&!used[i-1])
                continue;
            used[i]=true;
            list.add(arr[i]);
            dfs0(arr,used,list,lists);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
    private static List<List<Integer>> permuteUnique1(int []arr) {
        List<List<Integer>> lists=new ArrayList<>();
        if (arr.length==0)
            return null;
        Arrays.sort(arr);
        dfs1(lists,arr, new ArrayList<>(),0,new int[arr.length]);
        return lists;
    }
    private static void dfs1(List<List<Integer>> lists,int []arr,List<Integer> list,int num,int []pos) {
        if (num==arr.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<arr.length;i++) {
            if (pos[i]==0) {
                list.add(arr[i]);
                pos[i]=1;
                dfs1(lists,arr,list,num+1,pos);
                pos[i]=0;
                list.remove(num);
                //判断是否有重复的数字
                while (i<arr.length-1&&arr[i]==arr[i+1])
                    i++;
            }
        }
    }
}
