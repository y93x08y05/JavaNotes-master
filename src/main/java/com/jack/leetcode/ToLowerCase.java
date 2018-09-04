package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 23:58
 * LeetCode 709
 * 接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串
 * 例1：
 * 输入: "Hello"
 * 输出: "hello"
 * 例2：
 * 输入: "here"
 * 输出: "here"
 * 例3：
 * 输入: "LOVELY"
 * 输出: "lovely"
 */
public class ToLowerCase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(toLowerCase(s));
    }
    private static String toLowerCase(String s) {
        return s.toLowerCase();
    }
}