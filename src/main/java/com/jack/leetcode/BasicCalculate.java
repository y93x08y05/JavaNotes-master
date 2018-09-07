package com.jack.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/9/7 18:39
 * LeetCode 224
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含
 * 左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格。
 * 例1:
 * 输入: "1 + 1"
 * 输出: 2
 * 例2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 例3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 */
public class BasicCalculate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(calculate(s));
    }
    private static int calculate(String s) {
        if (s==null||s.length()==0)
            return 0;
        Stack<Integer> stack=new Stack<>();
        int res=0;
        int sign=1;
        for (int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if (Character.isDigit(c)) {
                int cur=c-'0';
                while (i+1<s.length()&&Character.isDigit(s.charAt(i+1))) {
                    cur=10*cur+s.charAt(++i)-'0';
                }
                res+=sign*cur;
            } else if (c=='-') {
                sign=-1;
            } else if (c=='+') {
                sign=1;
            } else if (c=='(') {
                stack.push(res);
                res=0;
                stack.push(sign);
                sign=1;
            } else if (c==')') {
                res=stack.pop()*res+stack.pop();
                sign=1;
            }
        }
        return res;
    }
}