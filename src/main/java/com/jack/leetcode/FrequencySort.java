package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/8 22:13
 * LeetCode 451
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 输入:
 * "树"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class FrequencySort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(frequencySort0(s));
        System.out.println(frequencySort1(s));
    }
    private static String frequencySort0(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char []chars=s.toCharArray();
        for (char c:chars) {
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        List<Character> []bucket=new ArrayList[s.length()+1];
        for (char k:map.keySet()) {
            int v=map.get(k);
            if (bucket[v]==null)
                bucket[v]=new ArrayList<>();
            bucket[v].add(k);
        }
        StringBuilder sb=new StringBuilder();
        for (int i=bucket.length-1;i>0;i--) {
            if (bucket[i]!=null) {
                for (char c:bucket[i]) {
                    for (int j=0;j<map.get(c);j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
    private static String frequencySort1(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char []chars=s.toCharArray();
        for (char c:chars) {
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> priorityQueue=new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());
        priorityQueue.addAll(map.entrySet());
        StringBuilder sb=new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character,Integer> m=priorityQueue.poll();
            for (int i=0;i<m.getValue();i++)
                sb.append(m.getKey());
        }
        return sb.toString();
    }
}