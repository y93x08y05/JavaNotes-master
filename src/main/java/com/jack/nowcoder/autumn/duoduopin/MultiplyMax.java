package com.jack.nowcoder.autumn.duoduopin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/5/2018 1:18 PM
 * 给定一个无序数组，包含正数，负数，0，要求从中找出三个数的乘积，
 * 使得乘积最大，要求时间复杂度为O(n)，空间复杂度为O(1)
 * 输入描述：
 * 第一行是数组大小n,第二行是无序正数数组A[n]
 * 输出描述：
 * 满足条件的最大乘积
 */
public class MultiplyMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int [] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        getMax(n,arr);
    }
    private static void getMax(int n, int [] arr) {
        if (n < 3) {
            return;
        } else if (n == 3) {
            System.out.println(arr[0]*arr[1]*arr[2]);
        } else {
            Arrays.sort(arr);
            long temp1 = (long)arr[0]*arr[1]*arr[2];
            long temp2 = (long)arr[0]*arr[1]*arr[arr.length-1];
            long temp3 = (long)arr[arr.length-3]*arr[arr.length-2]*arr[arr.length-1];
            long max = temp1>temp2?temp1>temp3?temp1:temp3:temp2>temp3?temp2:temp3;
            System.out.println(max);
        }
    }
}
