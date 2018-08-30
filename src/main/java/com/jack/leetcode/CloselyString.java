package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 4:51 PM
 * LeetCode 859
 */
public class CloselyString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(ifCloselyString(A, B));
    }
    private static boolean ifCloselyString(String A,String B) {
        if (A==null&&B!=null)
            return false;
        if (A!=null&&B==null)
            return false;
        if (A.length()!=B.length())
            return false;
        if (A==B)
            return false;
        for (int i=0;i<A.length();i++) {
            if (A.charAt(i)!=B.charAt(i)) {
                char temp=A.charAt(i);
                for (int j=0;j<B.length();j++) {
                    if (B.charAt(j)==temp) {
                    }
                }
            }
        }
        return true;
    }
}
