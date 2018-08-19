package com.jack.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Jack on 8/18/2018 1:34 PM
 * LeetCode 18
 * add four num from array
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
