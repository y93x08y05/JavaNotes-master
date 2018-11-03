package com.jack.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 18:48
 * LeetCode 227
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。
 * 整数除法仅保留整数部分。
 * 例1:
 * 输入: "3+2*2"
 * 输出: 7
 * 例 :
 * 输入: " 3/2 "
 * 输出: 1
 * 例3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 */
public class BasicCalculate2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(calculate(s));
    }
    private static int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(i + 1) - '0';
                    ++i;
                }
                if ((2 == Objects.requireNonNull(list.peek()) ||
                        3 == Objects.requireNonNull(list.peek())))
                    if (!list.isEmpty()) {
                        int op = list.pop();
                        int opl = list.pop();
                        int res;
                        if (op == 2)
                            res = opl * cur;
                        else
                            res = opl / cur;
                        list.push(res);
                    } else {
                        list.push(cur);
                    }
                else {
                    list.push(cur);
                }
            } else if (c == ' ') {

            } else {
                switch (c) {
                    case '+':
                        list.push(0);
                    break;
                    case '-':
                        list.push(1);
                    break;
                    case '*':
                        list.push(2);
                    break;
                    case '/':
                        list.push(3);
                    break;
                    default:
                        return -1;
                }
            }
        }
        if (list.isEmpty())
            return 0;
        Collections.reverse(list);
        int res = Objects.requireNonNull(list.poll());
        while (!list.isEmpty()) {
            int op = Objects.requireNonNull(list.poll());
            int opr = Objects.requireNonNull(list.poll());
            if (op == 0)
                res += opr;
            else
                res -= opr;
        }
        return res;
    }
}