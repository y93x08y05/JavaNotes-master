package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/13/2018 11:22 AM
 * LeetCode 443
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 例1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 例2：
 * 输入：
 * ["a"]
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * 说明：
 * 没有任何字符串被替代。
 * 例3：
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 */
public class StringCompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [] chars = new char[n];
        for (int i=0;i<n;i++) {
            chars[i] = sc.next().charAt(0);
        }
        System.out.println(compressString(chars));
    }
    private static int compressString(char [] chars) {
        int i=0;
        int j=0;
        int n=chars.length;
        while (j<n) {
            if (j==n-1||chars[j]!=chars[j+1])
                chars[i++]=chars[j++];
            else {
                chars[i++]=chars[j];
                int k=j;
                while (j<n&&chars[j]==chars[k])
                    j++;
                String s = String.valueOf(j-k);
                for (int q=0;q<s.length();q++)
                    chars[i++] = s.charAt(q);
            }
        }
        return i;
    }
}