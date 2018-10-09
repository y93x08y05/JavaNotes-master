package com.jack.nowcoder.autumn.weimeng;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/9 19:02
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findOneCount(n));
    }
    public static int findOneCount(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char [] chars = str.toCharArray();
            for (int i=0;i<chars.length;i++) {
                if (chars[i] == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}