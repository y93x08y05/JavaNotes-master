package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2019/3/16 9:29
 * LeetCode 127
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，
 * 找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 例1
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 例2
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class WordLadder {
    public static void main(String[] args) {
        String s1 = "hit";
        String s2 = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("log");
        list.add("cog");
        System.out.println(new WordLadder().ladderLength(s1, s2, list));
    }
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = map.get(word);
            if (word != null) {
                for (int i = 0; i < word.length(); i++) {
                    char[] wordLetter = word.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (wordLetter[i] == j)
                            continue;
                        wordLetter[i] = j;
                        String check = new String(wordLetter);
                        if (check.equals(endWord))
                            return map.get(word) + 1;
                        if (wordSet.contains(check) && !map.containsKey(check)) {
                            map.put(check, level + 1);
                            queue.add(check);
                        }
                    }
                }
            }
        }
        return 0;
    }
}