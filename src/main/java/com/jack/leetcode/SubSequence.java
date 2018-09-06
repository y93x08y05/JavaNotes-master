package com.jack.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 16:34
 * LeetCode 392
 * 给定字符串s和t，判断s是否为t的子序列。
 * 你可以认为s和t中仅包含英文小写字母。
 * 字符串t可能会很长（长度~= 500,000），
 * 而s是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些
 * （也可以不删除）
 * 字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 例1:
 * s="abc", t="ahbgdc"
 * 返回 true.
 * 例2:
 * s="axc", t="ahbgdc"
 * 返回 false.
 */
public class SubSequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        System.out.println(isSubSequence0(s, t));
        System.out.println(isSubSequence1(s, t));
        System.out.println(isSubSequence2(s, t));
    }
    private static boolean isSubSequence0(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int index=0;
        for (int i=0;i>len2&&index<len1;i++) {
            if (s.charAt(index)==t.charAt(i))
                index++;
        }
        return index==len1;
    }
    private static boolean isSubSequence1(String s, String t) {
        int index1=0;
        int index2=0;
        int len1=s.length();
        int len2=t.length();
        char first1;
        char first2;
        while (index1<len1&&index2<len2) {
            first1=s.charAt(index1);
            first2=t.charAt(index2);
            if (first1==first2) {
                index1++;
                index2++;
            } else
                index2++;
        }
        return index1==len1;
    }
    private static boolean isSubSequence2(String s, String t) {
        Queue<Character> queue1=new LinkedList<>();
        Queue<Character> queue2=new LinkedList<>();
        for (int i=0;i<s.length();i++) {
            queue1.add(s.charAt(i));
        }
        for (int i=0;i<t.length();i++) {
            queue2.add(t.charAt(i));
        }
        Character first1;
        Character first2;
        while (queue1.size()!=0&&queue2.size()!=0) {
            first1=queue1.peek();
            first2=queue2.peek();
            if (first1.equals(first2)) {
                queue1.remove();
                queue2.remove();
            } else {
                queue2.remove();
            }
        }
        return queue1.size()==0;
    }
}