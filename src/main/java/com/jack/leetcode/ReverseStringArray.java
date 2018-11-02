package com.jack.leetcode;

/**
 * Created by Jack on 8/28/2018 10:19 PM
 * LeetCode 344
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 例1:
 * 输入: "hello"
 * 输出: "olleh"
 * 例2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseStringArray {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(reverseString0(s));
        System.out.println(reverseString1(s));
    }
    private static String reverseString0(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    private static String reverseString1(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while (start < end) {
            ch[start] = (char) (ch[start] ^ ch[end]);
            ch[end] = (char) (ch[start] ^ ch[end]);
            ch[start] = (char) (ch[start] ^ ch[end]);
            start++;
            end--;
        }
        return new String(ch);
    }
}
