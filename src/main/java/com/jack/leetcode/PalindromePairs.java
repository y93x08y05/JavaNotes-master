package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/7 11:00
 * LeetCode 336
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词，
 * words[i] + words[j] ，可拼接成回文串。
 * 例1:
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 例2:
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 */
public class PalindromePairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String []words=new String[n];
        for (int i=0;i<n;i++) {
            words[i]=sc.next();
        }
        findPairs0(words);
        findPairs1(words);
    }
    private static List<List<Integer>> findPairs0(String []words) {
        List<List<Integer>> lists=new ArrayList<>();
        if (words==null)
            return lists;
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<words.length;i++) {
            map.put(words[i],i);
        }
        for (int i=0;i<words.length;i++) {
            int l=0;
            int r=0;
            while (l<=r) {
                String subStr=words[i].substring(l,r);
                Integer j=map.get(new StringBuilder(subStr).reverse().toString());
                if (j!=null&&i!=j&&l==0&&isPalindrome(words[i].substring(r,words[i].length()))) {
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                } else {
                    if (j!=null&&i!=j&&l!=0&&isPalindrome(words[i].substring(0,l))) {
                        List<Integer> list=new ArrayList<>();
                        list.add(j);
                        list.add(i);
                        lists.add(list);
                    }
                }
                if (r==words[i].length())
                    l++;
                else
                    r++;
            }
        }
        return lists;
    }
    /**
     * 超出时间限制
     * @param words
     * @return
     */
    private static List<List<Integer>> findPairs1(String []words) {
        List<List<Integer>> lists=new ArrayList<>();
        for (int i=0;i<words.length;i++) {
            for (int j=0;j<words.length;j++) {
                if (i!=j) {
                    String s1=new StringBuilder(words[i]).append(words[j]).toString();
                    String s2=new StringBuilder(s1).reverse().toString();
                    if (s1.equals(s2)) {
                        List<Integer> list=new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        lists.add(list);
                    }

                }
            }
        }
        return lists;
    }
    private static boolean isPalindrome(String s) {
        if (s==null)
            return false;
        for (int i=0;i<s.length()/2;i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}