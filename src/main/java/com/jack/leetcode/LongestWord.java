package com.jack.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Jack on 8/26/2018 10:55 AM
 * LeetCode 720
 * find the string array longest word and content with given condition
 * once add one character and compare and return longest string
 */
public class LongestWord {
    public static void main(String[] args) {
        String []str={"a","banana","app","appl","ap","apply","apple"};
        System.out.println(findLongestWord0(str));
        System.out.println(findLongestWord1(str));
    }
    private static String findLongestWord0(String []str) {
        Arrays.sort(str);
        HashSet<String> hashSet=new HashSet<>();
        String res="";
        for (String s:str) {
            if (s.length()==1||hashSet.contains(s.substring(0,s.length()-1))) {
                res=s.length()>res.length()?s:res;
                hashSet.add(s);
            }
        }
        return res;
    }
    private static String findLongestWord1(String []words) {
        HashSet<String> hashSet=new HashSet<>();
        for (int i=0;i<words.length;i++) {
            hashSet.add(words[i]);
        }
        int length=0;
        String res="";
        for (int i=0;i<words.length;i++) {
            if (words[i].length()>length||(words[i].length()==length&&words[i].compareTo(res)<0)) {
                int len=words[i].length();
                while (len>0&&hashSet.contains(words[i].substring(0,len))) {
                    len--;
                }
                if (len==0) {
                    length=words[i].length();
                    res=words[i];
                }
            }
        }
        return res;
    }
}
