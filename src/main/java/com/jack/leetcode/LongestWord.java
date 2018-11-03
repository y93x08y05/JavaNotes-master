package com.jack.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Jack on 8/26/2018 10:55 AM
 * LeetCode 720
 * 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。
 * 从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 * 例1:
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 例2:
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 */
public class LongestWord {
    public static void main(String[] args) {
        String[] str = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(findLongestWord0(str));
        System.out.println(findLongestWord1(str));
    }
    private static String findLongestWord0(String []str) {
        Arrays.sort(str);
        HashSet<String> hashSet = new HashSet<>();
        String res = "";
        for (String s : str) {
            if (s.length() == 1 || hashSet.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                hashSet.add(s);
            }
        }
        return res;
    }
    private static String findLongestWord1(String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            hashSet.add(words[i]);
        }
        int length = 0;
        String res = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > length || (words[i].length() == length && words[i].compareTo(res) < 0)) {
                int len=words[i].length();
                while (len > 0 && hashSet.contains(words[i].substring(0, len))) {
                    len--;
                }
                if (len == 0) {
                    length = words[i].length();
                    res = words[i];
                }
            }
        }
        return res;
    }
}
