package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/26/2018 10:27 AM
 * LeetCode 884
 * 给定两个句子 A 和 B 。
 * 句子是一串由空格分隔的单词。每个单词仅由小写字母组成。
 * 如果一个单词在其中一个句子中只出现一次，
 * 在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表，您可以按任何顺序返回列表。
 * 例1：
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 例2：
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 */
public class UnCommonFromSentences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        System.out.println(findUnCommon(A, B).length);
    }
    private static String[] findUnCommon(String A, String B) {
        String[] s1 = A.split(" ");
        String[] s2 = B.split(" ");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : s1) {
            if (map1.containsKey(s)) {
                map1.put(s, map1.get(s) + 1);
            } else {
                map1.put(s, 1);
            }
        }
        for (String s : s2) {
            if (map2.containsKey(s)) {
                map2.put(s, map2.get(s) + 1);
            } else {
                map2.put(s, 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : map1.keySet()) {
            if (map1.get(s) == 1 && map2.get(s) == null) {
                list.add(s);
            }
        }
        for (String s : map2.keySet()) {
            if (map2.get(s) == 1 && map1.get(s) == null) {
                list.add(s);
            }
        }
        String[] str = new String[list.size()];
        int i = 0;
        for (String s : list) {
            str[i++] = s;
        }
        return str;
    }
}
