package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 1:16 PM
 * LeetCode 13
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。
 * 12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 例1:
 * 输入: "III"
 * 输出: 3
 * 例2:
 * 输入: "IV"
 * 输出: 4
 * 例3:
 * 输入: "IX"
 * 输出: 9
 * 例4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: C = 100, L = 50, XXX = 30, III = 3.
 * 例5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomeToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(romanToInt(str));
    }
    private static int romanToInt(String s) {
        int sum = 0;
        boolean flag = false;
        if (s.length() > 1) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == 'M') {
                    sum += 1000;
                } else if (s.charAt(i) == 'V') {
                    sum += 5;
                } else if (s.charAt(i) == 'L') {
                    sum += 50;
                } else if (s.charAt(i) == 'D') {
                    sum += 500;
                } else if (s.charAt(i) == 'I') {
                    if (s.charAt(i + 1) == 'V') {
                        sum += 4;
                        i++;
                        if (i == s.length() - 1)
                            flag = true;
                        continue;
                    } else if (s.charAt(i + 1) == 'X') {
                        sum += 9;
                        i++;
                        if (i == s.length() - 1)
                            flag = true;
                    } else {
                        sum+=1;
                    }
                } else if (s.charAt(i) == 'X') {
                    if (s.charAt(i + 1) == 'L') {
                        sum += 40;
                        i++;
                        if (i == s.length() - 1)
                            flag = true;
                    } else if (s.charAt(i + 1) == 'C') {
                        sum += 90;
                        i++;
                        if (i == s.length() - 1)
                            flag = true;
                    } else {
                        sum += 10;
                    }
                } else if (s.charAt(i) == 'C') {
                    if (s.charAt(i + 1) == 'D') {
                        sum += 400;
                        i++;
                        if (i == s.length() - 1)
                            flag = true;
                    } else if (s.charAt(i + 1) == 'M') {
                        sum += 900;
                        i++;
                        if (i == s.length() - 1)
                            flag = true;
                    } else {
                        sum += 100;
                    }
                }
            }
        }
        if (!flag) {
            if (s.charAt(s.length() - 1) == 'I') {
                sum += 1;
            } else if (s.charAt(s.length() - 1) == 'V') {
                sum += 5;
            } else if (s.charAt(s.length() - 1) == 'X') {
                sum += 10;
            } else if (s.charAt(s.length() - 1) == 'L') {
                sum += 50;
            } else if (s.charAt(s.length() - 1) == 'C') {
                sum += 100;
            } else if (s.charAt(s.length() - 1) == 'D') {
                sum += 500;
            } else if (s.charAt(s.length() - 1) == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }
}
