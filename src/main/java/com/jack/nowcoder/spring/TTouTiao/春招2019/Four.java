package com.jack.nowcoder.spring.TTouTiao.春招2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/3/16 8:53
 */
public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(find(n, m, arr));
    }
    private static float find(int n, int m, int[] arr) {
        Arrays.sort(arr);
        if (m <= n) {
            return arr[arr.length - m];
        }
        return arr[arr.length - 1] / 2;
    }
}
