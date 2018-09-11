package com.jack.leetcode;

/**
 * Created by Jack on 8/2/2018 9:40 PM
 * LeetCode 190
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 例：
 * 输入: 43261596
 * 输出: 964176192
 * 解释: 43261596 的二进制表示形式为 00000010100101000001111010011100 ，
 * 返回 964176192，其二进制表示形式为 00111001011110000010100101000000 。
 */
public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<32-s.length();i++) {
            sb.append(0);
        }
        s = sb.append(s).toString();
        int sum = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '1')
            sum += (int) Math.pow(2,i);
        }
        System.out.println(sum);
        getNumber(n);
    }
    public static int getNumber(int n) {
        int value = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) {
                value = (value << 1) + 1;
                n >>= 1;
            } else {
                value = value << 1;
                n >>= 1;
            }
        }
        return value;
    }
}
