package com.jack.nowcoder.spring.DsJiang;
/**
 * 给定非负整数，数组中的每个元素值代表所能跳跃的最大长度
 * 一开始在第一个元素位置，求能跳到最后一个元素的最少
 * 跳跃次数，已知总能跳到最后一个台阶。
 */

import java.util.Scanner;

public class Main {
    public static int [] arr = {3,2,1,1,4};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int [] arr = new int[m];
        for (int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        if (jump(m,arr,0) == 1) {
            System.out.println(true);
        }
        if (jump(m,arr,0) == 0) {
            System.out.println(false);
        }
    }
    public static int jump(int n,int arr [] ,int x) {
        if (x > n-1) {
            return 1;
        }
        for (int i=arr[x];i>0;i--) {
            if (jump(n,arr,x+1) == 1) {
                return 1;
            } else {
                arr[x+1] = i;
            }
        }
        return 0;
    }
    public static int jump(int [] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        int current = arr[0];
        int next = arr[0];
        int step = 1;
        for (int i=0;i<n;i++) {
            if (current < i) {
                current = next;
                step++;
            }
            if (i+arr[i] > next) {
                next = i+arr[i];
            }
            if (current > n-1) {
                return step;
            }
        }
        return 0;
    }
}