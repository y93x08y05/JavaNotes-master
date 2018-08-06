package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 3:02 PM
 * LeetCode 136
 * number in array only appear once and then output
 */
public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int [] arr = new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.valueOf((str[i]));
        }
        System.out.println(singleNumber(arr));
    }
    private static int singleNumber(int [] arr) {
        Arrays.sort(arr);
        if (arr.length % 2 == 1) {
            if (arr.length == 1)
                return arr[0];
            else
                for (int i=0;i<arr.length-1;i++) {
                    if (arr[i] != arr[i+1])
                        return arr[i];
                    else
                        i++;
                }
                return arr[arr.length-1];
        }
        return 0;
    }
}
