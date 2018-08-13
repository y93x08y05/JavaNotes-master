package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/13/2018 11:22 AM
 * LeetCode 443
 * give Character and compress and statistic count
 * and return new array length
 */
public class StringCompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [] chars = new char[n];
        for (int i=0;i<n;i++) {
            chars[i] = sc.next().charAt(0);
        }
        System.out.println(compressString(chars));
    }
    private static int compressString(char [] chars) {
        int i=0;
        int j=0;
        int n=chars.length;
        while (j<n) {
            if (j==n-1||chars[j]!=chars[j+1])
                chars[i++]=chars[j++];
            else {
                chars[i++]=chars[j];
                int k=j;
                while (j<n&&chars[j]==chars[k])
                    j++;
                String s = String.valueOf(j-k);
                for (int q=0;q<s.length();q++)
                    chars[i++] = s.charAt(q);
            }
        }
        return i;
    }
}