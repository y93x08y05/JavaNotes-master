package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/13/2018 10:38 AM
 * LeetCode 38
 * integer sequence
 * 1 1
 * 2 11
 * 3 21
 * 4 1211
 * 5 111221
 */
public class CountAndSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findStringBaseInt(n));
    }
    private static String findStringBaseInt(int n) {
        if (n==1)
            return 1+"";
        String result = "1";
        for (int i=2;i<=n;i++)
            result=findStringBaseInt(result);
        return result;
    }
    private static String findStringBaseInt(String s) {
        String result = "";
        int count = 0;
        char c = '0';
        for (int i=0;i<s.length();i++) {
            c = s.charAt(i);
            if (count!=0) {
                if (s.charAt(i-1) != c) {
                    result=result+count+s.charAt(i-1);
                    count=0;
                }
            }
            count++;
        }
        result=result+count+c;
        return result;
    }
}
