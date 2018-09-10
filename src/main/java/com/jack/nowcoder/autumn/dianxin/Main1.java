package com.jack.nowcoder.autumn.dianxin;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/10 9:24
 * 删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除，
 * 输出删除这些单词后的字符串，字符串中其他字符保持原来的顺序。
 * 输入描述：
 * 字符串只包含小写英文字符
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串
 * 例1：
 * 输入：abcdd
 * 输出：dd
 * 例2：
 * 输入：assddfg
 * 输出：ssdd
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(findString(s));
    }
    private static String findString(String s) {
        char []chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (char c:chars) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        Collection<Integer> collection=map.values();
        int minIndex=Collections.min(collection);
        StringBuilder sb=new StringBuilder();
        for (char key:chars) {
            if (map.get(key)!=minIndex)
                sb.append(key);
        }
        return sb.toString();
    }
}