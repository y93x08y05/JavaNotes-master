package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 4:18 PM
 * LeetCode 453
 * give a array and length is n and find min move count let
 * all element equals
 * once move will let n-1 element add one
 * every optimal solution is let all less than Max add 1
 * it means that let element minus util equal Min
 */
public class MoveArrayMin1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println(findMinMove(arr));
    }
    private static int findMinMove(int [] arr) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]<min)
                min=arr[i];
            res+=arr[i];
        }
        return res-min*arr.length;
    }
}
