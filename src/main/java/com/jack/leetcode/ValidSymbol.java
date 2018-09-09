package com.jack.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jack on 8/7/2018 1:17 PM
 * LeetCode 20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 空字符串可被认为是有效字符串。
 * 例1:
 * 输入: "()"
 * 输出: true
 * 例2:
 * 输入: "()[]{}"
 * 输出: true
 * 例3:
 * 输入: "(]"
 * 输出: false
 * 例4:
 * 输入: "([)]"
 * 输出: false
 * 例5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidSymbol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isValid(str));
    }
    private static boolean isValid(String str) {
        if (str == null || str.length() == 0)
            return true;
        boolean result = false;
        Stack stack = new Stack();
        stack.push(str.charAt(0));
        for (int i=1;i<str.length();i++) {
            char c = getChar(str.charAt(i));
            if (!stack.isEmpty()) {
                if (stack.peek().equals(c)) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return result;
    }
    private static char getChar(char ch) {
        switch (ch) {
            case '[':
                return ']';
            case ']':
                return '[';
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
                default:
                    return ' ';
        }
    }
}
