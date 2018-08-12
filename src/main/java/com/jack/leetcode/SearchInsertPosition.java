package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 6:20 PM
 * LeetCode 35
 * give a sorted array and target and find if exist target in array
 * if exist return index else return should insert index
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findPosition(arr, target));
    }
    private static int findPosition(int [] arr,int target) {
        int m = Arrays.binarySearch(arr,target);
        if (m<0)
            return Math.abs(m+1);
        else
            return m;
    }
}
