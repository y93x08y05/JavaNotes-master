package com.jack.nowcoder.spring.TTouTiao.春招2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/3/16 8:53
 */
public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i< n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(find(arr));
        }
    }
    private static int find(int[] ratings) {
        if (ratings.length == 2) {
            if (ratings[0] == ratings[1]) {
                return 2;
            }
            return 3;
        }
        int[] A = new int[ratings.length];
        Arrays.fill(A, 1);
        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i] > ratings[i - 1] || ratings[i] > ratings[i + 1]) {
                A[i] = Math.max(A[i - 1], A[i + 1]) + 1;
            }
        }
        if (ratings[0] > ratings[1] && ratings[0] > ratings[ratings.length - 1]) {
            A[0] = Math.max(A[1], A[ratings.length - 1]) + 1;
        } else if (ratings[0] > ratings[1]) {
            A[0] = A[1] + 1;
        } else if (ratings[0] > ratings[ratings.length - 1]) {
            A[0] = A[ratings.length - 1] + 1;
        }
        if (ratings[ratings.length - 1] > ratings[0] && ratings[ratings.length - 1] > ratings[ratings.length - 2]) {
            A[ratings.length - 1] = Math.max(A[0], A[ratings.length - 2]) + 1;
        } else if (ratings[ratings.length - 1] > ratings[0]) {
            A[ratings.length - 1] = A[0] + 1;
        } else if (ratings[ratings.length - 1] > ratings[ratings.length - 2]) {
            A[ratings.length - 1] = A[ratings.length - 2] + 1;
        }
        return Arrays.stream(A).sum();
    }
}