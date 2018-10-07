package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/7 15:02
 * LeetCode 80
 * 删除排序数组中的重复项2
 * 给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素最多出现两次，返回移除后数组的新长度。
 * 例1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 例2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new RemoveDuplicates().find(arr));
    }
    public int find(int []arr) {
        if (arr == null)
            return 0;
        if (arr.length <= 2)
            return arr.length;
        int len = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != arr[len - 1] || arr[i] != arr[len - 2]) {
                arr[len] = arr[i];
                len++;
            }
        }
        return len;
    }
}