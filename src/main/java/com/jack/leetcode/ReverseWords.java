package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/29 14:43
 * LeetCode 151
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 例1：
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(new ReverseWords().find(s));
    }
    private String find(String s){
        if (s.equals(""))
            return "";
        String []str=s.split("\\s+");
        int len=str.length;
        if (len==0)
            return "";
        StringBuilder sb=new StringBuilder();
        for (int i=len-1;i>=0;i--){
            if (!str[i].equals("")){
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb.toString();
    }
}