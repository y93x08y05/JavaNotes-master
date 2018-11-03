package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 9/2/2018 3:32 PM
 * LeetCode 875
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。
 * 警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，
 * 然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 */
public class EatingSpeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int h = sc.nextInt();
        System.out.println(findMinValue(arr, h));
    }
    private static int findMinValue(int[] piles, int H) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1] + 1;
        while(left < right) {
            int m = (right - left) / 2 + left;
            int w = 0;
            for(int i = 0; i < piles.length; i++) {
                w += (piles[i] + m - 1) / m;
            }
            if(w <= H) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return left;
    }
}
