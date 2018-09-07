package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 11:22
 * LeetCode 214
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
 * 找到并返回可以用这种方式转换的最短回文串。
 * 例1:
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 例2:
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * KMP记录最长前缀和后缀的方法
 * 将原字符串翻转以后加在原字符串的后面，
 * 其最大的前缀和后缀就是前缀的最大回文长度．
 * 还需要在这两个字符串之间加一个冗余字符，
 * 因为形如aaaaa这种字符串如果不加一个冗余字符最大前缀和后缀会变大．
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(findShortestPalindrome(s));
    }
    private static String findShortestPalindrome(String s) {
        String temp=s+"#"+new StringBuilder(s).reverse().toString();
        int []table=getTable(temp);
        return new StringBuilder(s.substring(table[table.length-1])).reverse().toString()+s;
    }
    private static int[] getTable(String s) {
        int len=s.length();
        int []table=new int[len];
        char []chars=s.toCharArray();
        for (int i=1,k=0;i<len;i++) {
            while (k>0&&chars[i]!=chars[k]) {
                k=table[k-1];
            }
            if (chars[i]==chars[k]) {
                k++;
            }
            table[i]=k;
        }
        return table;
    }
}