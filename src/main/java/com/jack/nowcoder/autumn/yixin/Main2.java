package com.jack.nowcoder.autumn.yixin;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 17:34
 * 字符串查找，是字符串操作中一个很有用的函数。
 * 你的任务是实现这个函数：
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 如果 source = "source" 和 target = "target"，返回 -1。
 * 如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 * O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String source=sc.next();
        String target=sc.next();
        System.out.println(findLocationOfSubString(source, target));
    }
    private static int findLocationOfSubString(String source,String target) {
        if (source.contains(target)) {
            int len=target.length();
            for (int i=0;i<source.length()-len;i++) {
                if (source.substring(i,i+len).equals(target))
                    return i;
            }
        }
        return -1;
    }
}