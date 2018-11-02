package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 6:40 PM
 * LeetCode 278
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，
 * 你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，
 * 所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 例：给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 *
 */
public class VersionControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        firstBadVersion(n);
    }
    private static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    private static boolean isBadVersion(int val) {
        /**
         * isBadVersion will search all version message and
         * return all version unit test result
         * is false or true use two split method to do
         * to decrease time complexity
         */
        return val == 1;
    }
}
