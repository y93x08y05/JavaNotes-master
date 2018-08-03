package com.jack.train;

/**
 * Created by Jack on 8/2/2018 2:57 PM
 * justify whether an integer is a palindrome or not if yes output true else output false
 * -129-129 921-921-
 */
public class Main4 {
    public static void main(String[] args) {
        int m = 121;
        System.out.println(getValue(m));
    }
    public static boolean getValue(int m) {
        System.out.println(String.valueOf(m));
        System.out.println(new StringBuilder(String.valueOf(m)).reverse().toString());
        System.out.println(new StringBuilder(String.valueOf(m)).reverse().toString() == String.valueOf(m));
        System.out.println(new StringBuilder(String.valueOf(m)).reverse().toString().equals(String.valueOf(m)));
        return false;
    }
}
