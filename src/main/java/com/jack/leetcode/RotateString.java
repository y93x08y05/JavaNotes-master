package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 13:49
 * LeetCode 796
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。
 * 例如, 若A='abcde'，在移动一次之后结果就是'bcdea' 。
 * 如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * 例1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * 例2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 */
public class RotateString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.nextLine();
        String B=sc.nextLine();
        System.out.println(rotateString0(A, B));
        System.out.println(rotateString1(A, B));
    }
    private static boolean rotateString0(String A, String B) {
        if (A.equals(B))
            return true;
        char []a=A.toCharArray();
        char []b=B.toCharArray();
        int len=b.length;
        if (a.length!=b.length)
            return false;
        for (int i=0;i<len;i++) {
            if (a[i]==b[0]) {
                int offset=i;
                int p=1,q;
                for (q=offset+1;q<len;q++,p++) {
                    if (a[q]!=b[p])
                        break;
                }
                if (q==len) {
                    for (int l=0;l<offset;l++,p++) {
                        if (a[l]!=b[p])
                            break;
                    }
                    if (p>=len)
                        return true;
                }
            }
        }
        return false;
    }
    private static boolean rotateString1(String A, String B) {
        if (A.isEmpty()&&B.isEmpty())
            return true;
        for (int i=0;i<A.length();i++) {
            char []chars=A.toCharArray();
            char c=chars[0];
            for (int n=0;n<A.length()-1;n++) {
                chars[n]=chars[n+1];
            }
            chars[A.length()-1]=c;
            A=String.valueOf(chars);
            if (A.equals(B))
                return true;
        }
        return false;
    }
}