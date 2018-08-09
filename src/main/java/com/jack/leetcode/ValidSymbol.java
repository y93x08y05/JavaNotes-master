package com.jack.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jack on 8/7/2018 1:17 PM
 * LeetCode 20
 * give a string only include '(' ')' '[' ']' '{' '}'
 * and check if valid or not
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
