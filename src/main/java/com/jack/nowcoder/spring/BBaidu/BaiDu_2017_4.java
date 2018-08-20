package com.jack.nowcoder.spring.BBaidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一个N个数的数组，想将数组从小到大 排好序，但是只会下面这个操作：
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序？
 * 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
 * 输出一个整数表示最少的操作次数
 * 输入
 * 4
 * 19 7 8 25
 * 输出
 * 2
 * 最快的速度就是在数组中把从小到大已经排好序之外的元素
 * 从最小到最大一次放到最后一个进行排序，这样操作的次数最小
 */
public class BaiDu_2017_4 {
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int[] sortArr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = scan.nextInt();
            sortArr[i] = arr[i];
        }
        Arrays.sort(sortArr);
        int count = 0;
        int j = 0;
        /**
         * count用来统计排序前后顺序一致的元素个数
         * j从一致的基础上加1，按照排序后的数组从前到后依次做比较
         * 其次每次把剩下的元素按照从小到大顺序依次放到最后一个位置
         */
        for(int i = 0;i < n;i++){
            if(arr[i] == sortArr[j]){
                count++;
                j++;
            }
        }
        System.out.println(n - count);
    }
}
