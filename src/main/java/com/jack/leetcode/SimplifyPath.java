package com.jack.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/9/30 19:04
 * LeetCode 71
 * 简化路径
 * 给定一个文档Unix-style的完全路径，进行路径简化
 * path="/home/"----"/home"
 * path="/a/./b/../../c"---"/c"
 * "/../"需要返回"/"
 * 多个斜杠时返回一个斜杠
 */
public class SimplifyPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        System.out.println(find(path));
    }
    private static String find(String path) {
        Stack<String> stack = new Stack<>();
        while (path.length() > 0) {
            int start = path.indexOf("/");
            path = path.substring(start + 1);
            int end = path.indexOf("/");
            if (end == -1)
                end = path.length();
            String part = path.substring(0, end);
            path = path.substring(end);
            if (part.equals(".") || part.equals(""))
                continue;
            if (part.equals("..")) {
                if (!stack.empty())
                    stack.pop();
            } else
                stack.push("/"+part);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.insert(0, stack.pop());
        if (result.length() == 0)
            return "/";
        return result.toString();
    }
}