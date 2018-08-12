package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 4:52 PM
 * LeetCode 462
 * give a array and length is n and find min move count let
 * all element equals
 * once move could let one element add 1 or minus 1
 */
public class MoveArrayMin2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println(findMinMove(arr));
    }
    private static int findMinMove(int [] arr) {
        Arrays.sort(arr);
        int val = arr[arr.length/2];
        int res = 0;
        for (int i=0;i<arr.length;i++) {
            res+=Math.abs(val-arr[i]);
        }
        return res;
    }
}
