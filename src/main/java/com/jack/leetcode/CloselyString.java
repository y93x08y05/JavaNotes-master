package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 4:51 PM
 * LeetCode 859
 * 亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，
 * 只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * 例1：
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 例2：
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 例3:
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 例4：
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 例5：
 * 输入： A = "", B = "aa"
 * 输出： false
 */
public class CloselyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A =  sc.next();
        String B = sc.next();
        System.out.println(ifCloselyString(A, B));
    }
    private static boolean ifCloselyString(String A, String B) {
        if (A.length() != B.length())
            return false;
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        if (A.equals(B)){
            int[] count = new int[26];
            for ( char chars : charsA){
                count[chars - 'a'] ++;
            }
            for (int c : count) {
                if (c > 1) {
                    return true;
                }
            }
            return false;
        }else {
            int first = 0;
            int second = 0;
            for (int i = 0; i < charsA.length; i++){
                if (charsA[i] != charsB[i]){
                    if (first == 0){
                        first = i;
                    }else if (second == 0){
                        second = i;
                    }else {
                        return false;
                    }
                }
            }
            if (charsA[first] != charsB[second] || charsA[second] != charsB[first])
                return false;
        }
        return true;
    }
}
