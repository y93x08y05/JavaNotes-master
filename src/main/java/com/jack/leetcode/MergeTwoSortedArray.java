package com.jack.leetcode;

/**
 * Created by Jack on 8/2/2018 8:43 PM
 * LeetCode 88
 * 给定两个有序整数数组 nums1 和 nums2，
 * 将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        merge(arr1, 3, arr2, 3);
    }
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int l1 = m - 1, l2 = n - 1;
        int len = l1 + l2 + 1;
        while(l2 >= 0){
            arr1[len--] = (l1 >= 0 && arr1[l1] > arr2[l2]) ? arr1[l1--] : arr2[l2--];
        }
    }
}
