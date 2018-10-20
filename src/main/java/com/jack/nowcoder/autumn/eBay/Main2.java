package com.jack.nowcoder.autumn.eBay;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/19 19:54
 * 有n个箱子放在地上，为了收拾它们，你打算将它们叠起来，
 * 但是第i个箱子承重量有限，其上最多放xi个箱子，那么最少需要放多少列呢
 * 输入
 * 第一行一个数n
 * 第二行n个数表示xi
 * xi<=n<=5000
 * 输出
 * 一个数表示答案
 * 样例输入
 * 3
 * 0 0 10
 * 样例输出
 * 2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(find(arr));
    }
    public static int find(int []arr) {
        if (arr.length == 0 || arr == null)
            return 0;
        if (arr.length == 1)
            return 1;
        int res = 1;
        int val = arr[0];
        int sum = 0;
        for (int i=1;i<arr.length;i++) {
            sum += arr[i];
            if (sum > val) {
                res++;
                val = arr[i];
            }
        }
        return res;
    }
}