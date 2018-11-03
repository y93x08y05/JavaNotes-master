package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/21 22:02
 * LeetCode 17
 * 电话号码的字母组合
 * 定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 例1：
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(find(s));
    }
    private static List<String> find(String digit) {
        String[] ans = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digit.equals("") || digit.length() == 0)
            return res;
        res.add("");
        int[] num = new int[digit.length()];
        for (int i = 0; i < digit.length(); i++) {
            num[i] = digit.charAt(i) - '0';
        }
        for (int k = 0; k < digit.length(); k++) {
            if (num[k] < 2)
                continue;
            List<String> mid = new ArrayList<>();
            String s1 = ans[num[k]];
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < s1.length(); j++) {
                    mid.add(res.get(i) + s1.charAt(j));
                }
            }
            res=mid;
        }
        return res;
    }
}