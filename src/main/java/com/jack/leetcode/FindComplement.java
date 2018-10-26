package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/26 20:17
 * LeetCode 476
 * 数字的补数
 * 给定一个正整数，输出它的补数，补数是对该数的二进制表示取反。
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 例1:
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 例2:
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 */
public class FindComplement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
    }
    public static int find(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                sb.append(0);
            else
                sb.append(1);
        }
        String temp = sb.toString();
        int res = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                res += Math.pow(2,temp.length()-1-i);
            }
        }
        return res;
    }
}