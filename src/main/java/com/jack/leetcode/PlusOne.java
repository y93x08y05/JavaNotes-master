package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/7/2018 9:47 AM
 * Leetcode 66
 * give a non-null array of non negative integers and add 1 and return new array
 * every element only storage one number
 */
public class PlusOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int [] arr = new int[str.length];
        for (int i=0;i<arr.length;i++)
            arr[i] = Integer.valueOf(str[i]);
        int [] temp = plusOne(arr);
        for (int i=0;i<temp.length;i++)
            System.out.print(temp[i] + " ");
        System.out.println();
    }
    private static int [] plusOne(int [] digits) {
        if (digits.length == 0)
            return null;
        int len = digits.length;
        int flag = 0;
        for (int i=len-1;i>=0;i--) {
            if (i == len - 1) {
                if (digits[i] + 1 > 9 ) {
                    digits[i] = digits[i] + 1 - 10;
                    flag = 1;
                } else {
                    digits[i] = digits[i] + 1;
                    break;
                }
                continue;
            }
            if (digits[i] + flag > 9) {
                digits[i] = digits[i] + 1 - 10;
                flag = 1;
            } else {
                digits[i] = digits[i] + 1;
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            int [] result = new int[len+1];
            result[0] = 1;
            for (int i=0;i<len;i++)
                result[i+1] = digits[i];
            return result;
        }
        return digits;
    }
}
