package com.jack.nowcoder.spring.TTouTiao.春招2019;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/3/16 8:53
 */
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println(find(s, 0));
        }
    }
    private static String find(String s, int a) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        if (s.length() - 3 == a) {
            if (s.charAt(a) == s.charAt(a + 1) && s.charAt(a + 1) == s.charAt(a + 2)) {
                return new StringBuilder(s).deleteCharAt(a + 2).toString();
            }
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        char[] chars = s.toCharArray();
//        for (int i = a; i < chars.length - 3; i++) {
            if (chars[a] == chars[a+1] && chars[a + 1] == chars[a + 2]) {
                sb.deleteCharAt(a + 2);
                find(sb.toString(), a);
            } else if (chars[a] == chars[a + 1] && chars[a + 2] == chars[a + 3]) {
                sb.deleteCharAt(a + 3);
                find(sb.toString(), a);
            } else {
                a++;
                find(sb.toString(), a);
            }
//        }
        return sb.toString();
    }
}