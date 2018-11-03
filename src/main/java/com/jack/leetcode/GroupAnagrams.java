package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/5 0:17
 * LeetCode 49
 * 给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        group(s.split(" "));
    }
    private static List<List<String>> group(String[] str) {
        List<List<String>> lists = new ArrayList<>();
        int len = str.length;
        if (len < 1)
            return lists;
        Map<String, List<String>> map = new HashMap<>();
        String tmp;
        for (int i = 0; i < len; i++) {
            tmp = str[i];
            char[] chars = tmp.toCharArray();
            Arrays.sort(chars);
            tmp = new String(chars);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str[i]);
            } else {
                List<String> item = new ArrayList<>();
                item.add(str[i]);
                map.put(tmp, item);
            }
        }
        lists.addAll(map.values());
        return lists;
    }
}