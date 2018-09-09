package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 3:19 PM
 * LeetCode 696
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
 * 并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * 例1 :
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 例2 :
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */
public class BinarySubStringCount {
    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(findCountBinarySubString1(s));
        System.out.println(findCountBinarySubString2(s));
        System.out.println(findCountBinarySubString3(s));
    }
    private static int findCountBinarySubString1(String s) {
        char [] chars = s.toCharArray();
        int count = 0;
        for (int i=0;i<chars.length-1;i++) {
            if (isSubString(chars,i))
                count++;
        }
        return count;
    }
    private static boolean isSubString(char [] chars,int start) {
        int same = start + 1;
        while (same<chars.length-1&&chars[start]==chars[same])
            same++;
        int diff = same;
        while (diff<chars.length&&chars[diff]!=chars[start]&&diff-same<same-start)
            diff++;
        return diff-same==same-start?true:false;
    }
    private static int findCountBinarySubString2(String s) {
        char [] chars = s.toCharArray();
        int [] group = new int[chars.length];
        int index = 0;
        group[0] = 1;
        for (int i=1;i<chars.length;i++) {
            if (chars[i] == chars[i-1])
                group[index]++;
            else
                group[++index] = 1;
        }
        int i=0,count=0;
        while (i<group.length-1&&group[i]!=0) {
            count+=Math.min(group[i],group[i+1]);
            i++;
        }
        return count;
    }
    private static int findCountBinarySubString3(String s) {
        int pre = 0;
        int current = 1;
        int count = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i)!=s.charAt(i-1)) {
                count+=Math.min(pre,current);
                pre = current;
                current = 1;
            } else
                current++;
        }
        return count+Math.min(pre,current);
    }
}
