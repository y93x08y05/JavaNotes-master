package com.jack.nowcoder.spring.ArrowOffer;

/**
 * 实现一个函数将一个字符串中的空格转换成"%20"
 */
public class ReplaceSpace {
    public static void main(String [] args) {
        String s = "l o v e";
        System.out.println(replace(s));
    }
    private static String replace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                sb.append('%').append('2').append('0');
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}