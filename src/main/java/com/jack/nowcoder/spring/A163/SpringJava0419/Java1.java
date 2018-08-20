package com.jack.nowcoder.spring.A163.SpringJava0419;

/**
 *  最大字典子序列
 *  首先遍历一遍字符串，拿到当前字典排序最大的字符，
 *  其次将从当前字符下边索引后的子串遍历求最大的字符，
 *  最后依次进行，然后拼接。
 */

import java.util.Scanner;

public class Java1 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char [] array = string.toCharArray();
        int maxPos = 0;
        StringBuilder sb = new StringBuilder();
        while (maxPos < array.length) {
            int maxValue = Integer.MIN_VALUE;
            for (int i=maxPos;i<array.length;i++) {
                if (array[i] > maxValue) {
                    maxValue = array[i];
                    maxPos = i;
                }
            }
            sb.append((char)maxValue);
            maxPos++;
        }
        System.out.println(sb.toString());
    }
}