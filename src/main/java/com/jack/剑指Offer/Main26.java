package com.jack.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jack on 8/1/2018 8:28 PM
 * 找到第一个不重复的字符，并返回其在字符串中的位置。
 */
public class Main26 {
    public static void main(String[] args) {
        String s = "abcdafgblc";
        System.out.println(findNotRepeatingChar(s));
    }
    public static int findNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1)
                return i;
        }
        return -1;
    }
}
