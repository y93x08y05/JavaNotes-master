package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/8 21:56
 * LeetCode 500
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 */
public class KeyBoardWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        System.out.println(Arrays.toString(findWord(str)));
    }
    private static String[] findWord(String[] word) {
        String[] str = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            for (char c : str[i].toCharArray())
                map.put(c, i);
        }
        int index;
        List<String> res = new ArrayList<>();
        for (String s : word) {
            if (s.equals(""))
                continue;
            index = map.get(s.toUpperCase().toCharArray()[0]);
            for (char c : s.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1)
                res.add(s);
        }
        return res.toArray(new String[0]);
    }
}