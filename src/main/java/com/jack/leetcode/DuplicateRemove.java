package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 3:52 PM
 * LeetCode 26
 * give a sorted array, delete duplicate element and let every
 * element only appear once and return new length of array
 */
public class DuplicateRemove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int [] arr = new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        System.out.println(removeDuplicate(arr));
    }
    private static int removeDuplicate(int [] arr) {
        if (arr == null)
            return 0;
        int res = 0;
        int [] p = arr;
        for (int i=0;i<arr.length;i++) {
            if (p[i] == arr[res]) {

            } else {
                arr[++res] = p[i];
            }
        }
        return res+1;
    }
}
