package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 9:39
 * LeetCode 551
 * 给定一个字符串来代表一个学生的出勤纪录，这个纪录仅包含以下三个字符：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 你需要根据这个学生的出勤纪录判断他是否会被奖赏。
 * 例1:
 * 输入: "PPALLP"
 * 输出: True
 * 例2:
 * 输入: "PPALLL"
 * 输出: False
 */
public class CheckRecord1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(checkRecord(s));
    }
    private static boolean checkRecord(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        if (map.containsKey('A')&&map.get('A')>1)
            return false;
        if (s.length()>=3) {
            for (int i=0;i<s.length()-2;i++) {
                if (s.charAt(i)=='L'&&s.charAt(i+1)=='L'&&s.charAt(i+2)=='L') {
                    System.out.println(s.charAt(i)+" "+s.charAt(i+1)+" "+s.charAt(i+2));
                    return false;
                }
            }
        }
        return true;
    }
}