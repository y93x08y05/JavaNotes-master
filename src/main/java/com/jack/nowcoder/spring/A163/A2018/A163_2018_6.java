package com.jack.nowcoder.spring.A163.A2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zhangta on 1/6/2018.
 * 一个合法的括号匹配序列被定义为:
 * 1. 空串""是合法的括号序列
 * 2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
 * 3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
 * 4. 每个合法的括号序列都可以由上面的规则生成
 * "", "()", "()()()", "(()())", "(((()))"都是合法的
 * 从一个字符串S中移除零个或者多个字符得到的序列称为S的子序列
 * "abcde"的子序列有"abe","","abcde"等
 * 定义LCS(S,T)为字符串S和字符串T最长公共子序列的长度,
 * 即一个最长的序列W既是S的子序列也是T的子序列的长度。
 * 给出一个合法的括号匹配序列s，找出具有以下特征的括号序列t
 * 1、t跟s不同,但是长度相同
 * 2、t也是一个合法的括号匹配序列
 * 3、LCS(s, t)是满足上述两个条件的t中最大的
 * 计算满足条件的t的个数
 * s = "(())()",跟字符串s长度相同的合法括号匹配序列有:
 * "()(())", "((()))", "()()()", "(()())",
 * 其中LCS( "(())()", "()(())" )为4,其他三个都为5,所以输出3
 */
public class A163_2018_6 {
    //用HashSet去除重复值
    private static Set<String> set = new HashSet<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        getSequence(str);
        System.out.println(set.size() - 1);//减一去除字符串本身
        sc.close();
    }
    private static void getSequence(String str) {
        //将字符串中的每一位依次删除
        //再将删除的字符依次插入到字符串的每一位置进行比较
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            char c = str.charAt(i);
            sb.deleteCharAt(i);
            for (int j = 0; j < str.length(); j++) {
                sb.insert(j, c);
                if (isLegal(sb.toString())) {
                    set.add(sb.toString());
                }
                sb.deleteCharAt(j);
            }
        }
    }
    private static boolean isLegal(String s) {
        //判断两种符号按顺序分别出现次数
        //一旦右括号大于左括号则返回false，循环遍历完都不存在这种情况
        //则默认返回true
        int left = s.length() / 2, right = s.length() / 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left--;
            else
                right--;
            if (right < left)
                return false;
        }
        return true;
    }
}
