package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/14/2018 10:29 PM
 * LeetCode 8
 * give a string and some limitation and let string transfer to int
 */
public class StringTransferInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(stringToInt(s));
    }
    private static int stringToInt(String s) {
        s=s.trim();
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            if (s.length()==0)
                return 0;
            char c = s.charAt(0);
            if (c!='+'&&c!='-'&&(c-'0'<0||c-'0'>9))
                return 0;
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0));
                for (int i=1;i<s.length();i++) {
                    char temp = s.charAt(i);
                    if (temp-'0'>=0&&temp-'0'<=9)
                        sb.append(temp);
                    else
                        break;
                }
                if (sb.length()==1) {
                    if (sb.charAt(0)=='+'||sb.charAt(0)=='-')
                        return 0;
                    else
                        return Integer.parseInt(sb.toString());
                } else {
                    if (sb.charAt(0)=='+')
                        s=sb.substring(1,sb.length());
                    else
                        s=sb.toString();
                    try {
                        return Integer.parseInt(s);
                    } catch (Exception e1) {
                        if (s.charAt(0)=='-')
                            return Integer.MIN_VALUE;
                        else
                            return Integer.MAX_VALUE;
                    }
                }
            }
        }
    }
}
