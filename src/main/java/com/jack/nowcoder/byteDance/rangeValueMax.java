package com.jack.nowcoder.byteDance;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 10:27 PM
 * 给定一个整数序列，需要求出一个区间，使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数*区间中的所有数的和最后程序输出经过计算的最大值，不需要输出具体的区间，
 * 如给定序列[6,2,1]，则根据上述公式，可得到所有可以选定区间的计算值，
 * [6]=6*6=36
 * [2]=2*2=4
 * [1]=1*1=1
 * [6,2]=2*8=16
 * [2,1]=1*3=3
 * [6,2,1]=1*9=9
 * 区间内的所有数字都在[0,100]的范围内
 * 输入描述：
 * 第一行输入数组序列长度n，第二行输入数组序列
 * 输出描述：
 * 输出数组经过计算后的最大值
 * 输入例子：
 * 3
 * 6 2 1
 * 输出例子：
 * 36
 */
public class rangeValueMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        int sum;
        int temp = Integer.MIN_VALUE;
        for (int i=0;i<arr.length-1;i++) {
            sum = arr[i];
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && arr[left] > arr[i])
                sum += arr[left--];
            while (right < n && arr[right] >= arr[i])
                sum += arr[right++];
            if (sum * arr[i] > temp)
                temp = sum * arr[i];
        }
        System.out.println(temp);
    }
}
