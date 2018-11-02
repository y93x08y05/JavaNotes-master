package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 23:21
 * LeetCode 290
 * 单词模式
 * 给定一种 pattern(模式) 和一个字符串 str ，
 * 判断str是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如，
 * pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应模式。
 * 例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 例2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 例3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 例4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 */
public class WordPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(wordPattern(s1, s2));
    }
    private static boolean wordPattern(String s1, String s2) {
        char[] patterns = s1.toCharArray();
        Map<Character, String> map = new HashMap<>();
        String[] str = s2.split(" ");
        if (patterns.length != str.length)
            return false;
        for (int i = 0; i < patterns.length; i++) {
            char c = patterns[i];
            if (map.containsKey(c)) {
                String value = map.get(c);
                if (!value.equals(str[i]))
                    return false;
            } else {
                if (map.containsValue(str[i]))
                    return false;
                map.put(c, str[i]);
            }
        }
        return true;
    }
}