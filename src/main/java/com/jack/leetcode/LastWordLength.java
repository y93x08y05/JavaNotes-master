package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/14/2018 11:07 PM
 * LeetCode 58
 * find last word length from string
 */
public class LastWordLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getLengthOfLastWord(s));
    }
    private static int getLengthOfLastWord(String s) {
        s=s.trim();
        if (s.length()==0)
            return 0;
        for (int i=s.length()-1;i>0;i--) {
            if (s.charAt(i)==' ')
                return s.substring(i+1,s.length()).length();
        }
        return s.length();
    }
}
