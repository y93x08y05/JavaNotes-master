package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/15/2018 1:49 PM
 * LeetCode 10
 * give string and character pattern
 * justify if match return true else return false
 */
public class RegexMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(ifRegexMatch(s1, s2));
    }
    private static boolean ifRegexMatch(String s,String p) {
        if (s==null||p==null)
            return false;
        boolean [][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i=0;i<p.length();i++)
            if (p.charAt(i)=='*'&&dp[0][i-1])
                dp[0][i+1] = true;
        for (int i=0;i<s.length();i++) {
            for (int j=0;j<p.length();j++) {
                if (p.charAt(j)=='.')
                    dp[i+1][j+1] = dp[i][j];
                if (p.charAt(j)==s.charAt(i))
                    dp[i+1][j+1] = dp[i][j];
                if (p.charAt(j)=='*') {
                    if (p.charAt(j-1)!=s.charAt(i)&&p.charAt(j-1)!='.')
                        dp[i+1][j+1] = dp[i+1][j-1];
                    else
                        dp[i+1][j+1] = dp[i+1][j]||dp[i][j+1]||dp[i+1][j-1];

                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
