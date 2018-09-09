package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 13:39
 * LeetCode 784
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，
 * 我们可以获得一个新的字符串。返回所有可能得到的字符串集合
 * 例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * 输入: S = "12345"
 * 输出: ["12345"]
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(findPermutation(s));
    }
    private static List<String> findPermutation(String s) {
        List<String> list=new ArrayList<>();
        if (s==null)
            return list;
        if (s.length()==0) {
            list.add(s);
            return list;
        }
        char []source=s.toCharArray();
        List<Integer> list1=new ArrayList<>();
        for (int i=0;i<source.length;i++) {
            if (source[i]>'9')
                list1.add(i);
        }
        int cnt=1<<(list1.size());
        for (int i=0;i<cnt;i++) {
            int temp=i;
            for (int j=0;j<list1.size();j++) {
                if ((temp&1)==1) {
                    source[list1.get(j)]=Character.toUpperCase(source[list1.get(j)]);
                } else {
                    source[list1.get(j)]=Character.toLowerCase(source[list1.get(j)]);
                }
                temp>>=1;
            }
            list.add(String.valueOf(source));
        }
        return list;
    }
}