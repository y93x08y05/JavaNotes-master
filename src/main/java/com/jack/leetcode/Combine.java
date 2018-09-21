package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/21 22:53
 * LeetCode 77
 * 给定两个整数n和k，返回1---n中所有可能的k个数的组合
 * 例1：
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(find(n, k));
    }
    private static List<List<Integer>> find(int n,int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        dfs(res,temp,n,k,1);
        return res;
    }
    private static void dfs(List<List<Integer>> res,List<Integer> temp,int n,int k,int m) {
        if (k==0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=m;i<=n;i++) {
            temp.add(i);
            dfs(res,temp,n,k-1,i+1);
            temp.remove(temp.size()-1);
        }
    }
}