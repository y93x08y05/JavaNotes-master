package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 14:43
 * LeetCode 205
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以被替换得到t，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 例1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 例2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 例3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 */
public class IsIsomorphic {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(isIsomorphic(s1, s2));
    }
    private static boolean isIsomorphic(String s1,String s2) {
        int []arr1=new int[128];
        int []arr2=new int[128];
        for (int i=0;i< s1.length();i++) {
            if (arr1[s1.charAt(i)]!=arr2[s2.charAt(i)]) {
                return false;
            }
            arr1[s1.charAt(i)]=arr2[s2.charAt(i)]=i+1;
        }
        return true;
    }
}