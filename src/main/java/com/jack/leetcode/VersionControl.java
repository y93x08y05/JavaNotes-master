package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 6:40 PM
 * LeetCode 278
 * find first error version from deployed version list
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
        while (start<end) {
            int mid = start + (end - start)/2;
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
        return val==1;
    }
}
