package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/7/2018 9:47 AM
 * Leetcode 66
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 例1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 例2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
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
