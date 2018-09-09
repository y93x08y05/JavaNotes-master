package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/8 22:35
 * LeetCode 347
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 例1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 例2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class TopKFrequent {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        findTopK(arr,k);
    }
    private static List<Integer> findTopK(int []arr,int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int val:arr) {
            if (map.containsKey(val))
                map.put(val,map.get(val)+1);
            else
                map.put(val,1);
        }
        List<Integer>[]bucket=new List[arr.length+1];
        for (int key:map.keySet()) {
            int count=map.get(key);
            if (bucket[count]==null)
                bucket[count]=new ArrayList<>();
            bucket[count].add(key);
        }
        List<Integer> result=new ArrayList<>();
        for (int i=arr.length;i>0;i--) {
            if (bucket[i]!=null&&result.size()<k)
                result.addAll(bucket[i]);
        }
        return result;
    }
}