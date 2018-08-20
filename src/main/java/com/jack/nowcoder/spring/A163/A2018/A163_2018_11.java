package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/8/2018.
 * 一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串
 * 现在有一个01串s,找出一个最长的连续子串,并且这个子串是一个交错01串
 * 求出最长的这样的子串的长度是多少
 * 输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'
 * 输出一个整数,表示最长的满足要求的子串长度
 * 输入例子
 * 111101111
 * 输出例子
 * 3
 */
public class A163_2018_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int maxLen = 1;
            int len = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) != str.charAt(i)) {
                    len++;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                } else {
                    len = 1;
                }
            }
            System.out.println(maxLen);
        }
    }
}
