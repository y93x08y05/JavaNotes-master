package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 5:04 PM
 * LeetCode 686
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，
 * 如果不存在则返回 -1。
 * 例，A = "abcd"，B = "cdabcdab"。
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，
 * 此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 * A 与 B 字符串的长度在1和10000区间范围内。
 */
public class RepeatedStringMatch {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdabcdab";
        System.out.println(findRepeatedStringMatch(s1, s2));
    }
    private static int findRepeatedStringMatch(String A,String B) {
        StringBuilder sb = new StringBuilder();
        int lenA = A.length();
        int lenB = B.length();
        for(int i=0;i<lenB/lenA + 2;i++){
            String str = sb.append(A).toString();
            if(str.indexOf(B) != -1)
                return i+1;
        }
        return -1;
    }
}
