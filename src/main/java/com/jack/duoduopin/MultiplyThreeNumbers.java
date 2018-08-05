package com.jack.duoduopin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 3:31 PM
 * 给定一个无序数组，包含正数、负数和0，从中找出三个数的乘积，使得乘积最大
 * 输入描述：无序正数数组
 * 输出描述：满足条件的最大乘积
 * 输入例子
 * 3 4 1 2
 * 输出例子
 * 24
 */
public class MultiplyThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String [] str = sc.nextLine().split(" ");
        int [] arr = new int[str.length];
        for (int i=0;i<n;i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        if (n < 3) {
            return;
        } else if (n == 3) {
            System.out.println(arr[0]*arr[1]*arr[2]);
        } else {
            long max;
            long temp;
            Arrays.sort(arr);
            max = (long) arr[2]*arr[1]*arr[0];
            temp = (long) arr[arr.length-1]*arr[arr.length-2]*arr[arr.length-3];
            max = max<temp?temp:max;
            temp = (long) arr[arr.length-1]*arr[1]*arr[0];
            max = max<temp?temp:max;
            System.out.println(max);
        }
    }
}
