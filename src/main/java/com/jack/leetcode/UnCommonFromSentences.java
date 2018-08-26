package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/26/2018 10:27 AM
 * LeetCode 884
 * give two sentence and contain some word
 * find one sentence this word is appear once and
 * other sentence this word is appear zero
 * and then add this word to array
 */
public class UnCommonFromSentences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.nextLine();
        String B=sc.nextLine();
        System.out.println(findUnCommon(A, B).length);
    }
    private static String[] findUnCommon(String A,String B) {
        String s1[]=A.split(" ");
        String s2[]=B.split(" ");
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        for (String s:s1) {
            if (map1.containsKey(s)) {
                map1.put(s,map1.get(s)+1);
            } else {
                map1.put(s,1);
            }
        }
        for (String s:s2) {
            if (map2.containsKey(s)) {
                map2.put(s,map2.get(s)+1);
            } else {
                map2.put(s,1);
            }
        }
        List<String> list=new ArrayList<>();
        for (String s:map1.keySet()) {
            if (map1.get(s)==1&&map2.get(s)==null) {
                list.add(s);
            }
        }
        for (String s:map2.keySet()) {
            if (map2.get(s)==1&&map1.get(s)==null) {
                list.add(s);
            }
        }
        String []str=new String[list.size()];
        int i=0;
        for (String s:list) {
            str[i++]=s;
        }
        return str;
    }
}
