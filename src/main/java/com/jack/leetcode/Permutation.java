package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 9/2/2018 4:23 PM
 * LeetCode 46
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 回溯算法、递归实现
 */
public class Permutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        permute0(arr);
        permute1(arr);
        permute2(arr);
        permute3(arr);
    }
    private static List<List<Integer>> permute0(int []arr) {
        List<List<Integer>> lists=new ArrayList<>();
        dfs0(lists,arr,0);
        return lists;
    }
    private static void dfs0(List<List<Integer>> lists, int []arr, int j) {
        if (j==arr.length) {
            List<Integer> temp=new ArrayList<>();
            for (int num:arr)
                temp.add(num);
            lists.add(temp);
        }
        for (int i=j;i<arr.length;i++) {
            swap(arr,i,j);
            dfs0(lists,arr,j+1);
            swap(arr,i,j);
        }
    }
    private static void swap(int []arr,int m,int n) {
        int temp=arr[m];
        arr[m]=arr[n];
        arr[n]=temp;
        String s=new String();
    }
    private static List<List<Integer>> permute1(int []arr) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        dfs1(lists,list,arr,new boolean[arr.length]);
        return lists;
    }
    private static void dfs1(List<List<Integer>> res,List<Integer> temp,int []arr,boolean []used) {
        if (temp.size()==arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0;i<arr.length;i++) {
            if (!used[i]) {
                used[i]=true;
                temp.add(arr[i]);
                dfs1(res,temp,arr,used);
                temp.remove(temp.size()-1);
                used[i]=false;
            }
        }
    }
    private static List<List<Integer>> permute2(int []arr) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> first=new ArrayList<>();
        first.add(arr[0]);
        lists.add(first);
        for (int i=1;i<arr.length;i++) {
            List<List<Integer>> lists1=new ArrayList<>();
            for (List<Integer> temp:lists) {
                int size=temp.size()+1;
                for (int j=0;j<size;j++) {
                    List<Integer> item=new ArrayList<>(temp);
                    item.add(j,arr[i]);
                    lists1.add(item);
                }
            }
            lists=lists1;
        }
        return lists;
    }
    private static List<List<Integer>> permute3(int []arr) {
        List<List<Integer>> lists=new ArrayList<>();
        if (arr.length==0||arr==null)
            return lists;
        List<Integer> first=new ArrayList<>();
        first.add(arr[0]);
        lists.add(first);
        for (int i=1;i<arr.length;i++) {
            int size=lists.size();
            for (int j=0;j<size;j++) {
                int size2=lists.get(0).size();
                for (int k=0;k<=size2;k++) {
                    List<Integer> temp=new ArrayList<>(lists.get(0));
                    temp.add(k,arr[i]);
                    lists.add(temp);
                }
                lists.remove(0);
            }
        }
        return lists;
    }
}
