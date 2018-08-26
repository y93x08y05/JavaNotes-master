package com.jack.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jack on 8/26/2018 7:27 PM
 * LeetCode 524
 * delete some char and get longest string and return new string
 */
public class LongestWordDeleteChar {
    public static void main(String[] args) {
        String s="abpcplea";
        String [] str={"ale","apple","monkey","plea"};
        List<String> list=Arrays.asList(str);
        System.out.println(findLongestWord(s, list));
    }
    private static String findLongestWord(String s,List<String> list) {
        String res="";
        for (int i=0;i<list.size();i++) {
            int m,n;
            for (m=0,n=0;m<s.length()&&n<list.get(i).length();m++) {
                if (s.charAt(m)==list.get(i).charAt(n))
                    n++;
            }
            /**
             * only s contain all char of string of list and list string length more than res length
             * or list string length == res length will replace res, let list string as new res.
             */
            if (n==list.get(i).length()&&(res.length()<list.get(i).length()||(res.length()==list.get(i).length()&&res.compareTo(list.get(i))>0))) {
                res=list.get(i);
            }
        }
        return res;
    }
}
