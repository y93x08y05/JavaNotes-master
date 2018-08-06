package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 3:23 PM
 * LeetCode 268
 * give a include 0,1,2,3,...,n sequence，find number which
 * not appear in sequence
 */
public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int [] arr = new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        System.out.println(missingNumber(arr));
    }
    private static int missingNumber(int [] arr) {
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i++) {
           if (arr[i] != i)
               return i;
        }
        return arr[arr.length-1]+1;
    }
}
