package com.jack.coding;

import java.util.HashMap;

/**
 * Created by Jack on 8/1/2018 8:28 PM
 * find the first character that appears only once ina string
 * and return its position.If the string is empty return -1
 */
public class Main26 {
    public static void main(String[] args) {
        String s = "abcdafgblc";
        findNotRepeatingChar(s);
    }
    public static int findNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int time = map.get(c);
                time++;
                map.put(c,time);
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
