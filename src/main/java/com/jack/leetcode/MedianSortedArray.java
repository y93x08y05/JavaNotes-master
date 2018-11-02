package com.jack.leetcode;

/**
 * Created by Jack on 8/9/2018 1:31 PM
 * LeetCode 4
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class MedianSortedArray {
    public static void main(String[] args) {
        int[] a = {3};
        int[] b = {1, 2};
        double median = findMedianSortedArray(a, b);
        System.out.println(median);
    }
    private static double findMedianSortedArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1)
            return findKth(arr1, 0, len1, arr2, 0, len2, totalLen / 2 + 1);
        else
            return (findKth(arr1, 0, len1, arr2, 0, len2, totalLen / 2) + findKth(arr1, 0, len1, arr2, 0, len2, totalLen / 2 + 1)) / 2;
    }
    private static double findKth(int[] arr1, int begin1, int len1, int[] arr2, int begin2, int len2, int k) {
        if (len1 > len2)
            return findKth(arr2, begin2, len2, arr1, begin1, len1, k);
        if (len1 == 0)
            return arr2[begin2 + k - 1];
        if (k == 1)
            return Math.min(arr1[begin1], arr2[begin2]);
        int lenA = Math.min(k / 2, len1);
        int lenB = k - lenA;
        if (arr1[begin1 + lenA - 1] < arr2[begin2 + lenB - 1])
            return findKth(arr1, begin1 + lenA, len1 - lenA, arr2, begin2, len2, k - lenA);
        else if (arr1[begin1 + lenA - 1] > arr2[begin2 + lenB - 1])
            return findKth(arr1, begin1, len1, arr2, begin2 + lenB, len2 - lenB, k - lenB);
        else
            return arr1[begin1 + lenA - 1];
    }
}
    