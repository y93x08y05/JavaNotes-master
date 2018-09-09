package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 17:36
 * LeetCode 93
 * 给定一个只包含数字的字符串，复原它并返回所有可能的IP地址格式。
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(restore(s));
    }
    private static List<String> restore(String s) {
        List<String> list=new ArrayList<>();
        if (s.length()<4||s.length()>12)
            return list;
        findIP(s,"",list,1);
        return list;
    }
    private static void findIP(String s,String temp,List<String> list,int count) {
        if (count==4&&isValid(s)) {
            list.add(temp+s);
            return;
        }
        int len=Math.min(4,s.length());
        for (int i=1;i<len;i++) {
            String s1=s.substring(0,i);
            if (isValid(s1)) {
                findIP(s.substring(i),temp+s1+".",list,count+1);
            }
        }
    }
    private static boolean isValid(String s) {
        if (s.charAt(0)=='0')
            return s.equals("0");
        int val=Integer.parseInt(s);
        if (0<val&&val<256)
            return true;
        else
            return false;
    }
}