package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 8:06 PM
 * LeetCode 40
 * give a no repeated element array and target
 * find all of sum is target combination and every element only use once
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [] arr = new int[m];
        for (int i=0;i<m;i++)
            arr[i] = sc.nextInt();
        System.out.println(findAllCombination(arr, n).size());
    }
    private static List<List<Integer>> findAllCombination(int [] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(arr);
        int length = arr.length;
        for (int i=0;i<length;i++) {
            if (arr[i]>target)
                break;
            while (i>0&&i<length&&arr[i]==arr[i-1])
                i++;
            if (i>=length)
                break;
            temp.add(arr[i]);
            DiGui(res,i+1,arr[i],temp,arr,target);
            temp.clear();
        }
        return res;
    }
    private static void DiGui(List<List<Integer>> res,int index,int count,List<Integer> temp,int [] arr,int target) {
        if (count>=target) {
            if (count==target) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }
        for (int i=index;i<arr.length;i++) {
            while (i>index&&i<arr.length&&arr[i]==arr[i-1])
                i++;
            if (i>=arr.length)
                break;
            if (count+arr[i]>target)
                break;
            temp.add(arr[i]);
            DiGui(res,i+1,count+arr[i],temp,arr,target);
            temp.remove(temp.size()-1);
        }
    }
}
