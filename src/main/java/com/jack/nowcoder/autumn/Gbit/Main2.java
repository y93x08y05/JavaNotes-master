package com.jack.nowcoder.autumn.Gbit;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 11:29
 * 给定一个非负数，删除其中一些数字后，如果剩余数字刚好为2018，就加1
 * 现在给定一个X，在不大于X的数中找出这类数的个数
 * 输入描述：
 * 一个数字
 * 输出描述：
 * 这类数字的个数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findCount(n));
    }
    private static int findCount(int n) {
        int count=0;
        for (int i=2018;i<=n;i++) {
            String s=String.valueOf(i);
            if (s.contains("2")&&s.contains("0")&&
                    s.contains("1")&&s.contains("8")) {
                if (s.indexOf("2")<s.indexOf("0")) {
                    if (s.indexOf("0")<s.indexOf("1")) {
                        if (s.indexOf("1")<s.lastIndexOf("8")) {
                            count++;
                        }
                    } else if (s.indexOf("0")<s.lastIndexOf("1")) {
                        if (s.lastIndexOf("1")<s.lastIndexOf("8")) {
                            count++;
                        }
                    }
                } else {
                    for (int j=s.indexOf("0");j<s.length();j++) {
                        if (s.charAt(j)==s.indexOf("0")) {
                            if (s.indexOf("2")<s.indexOf(j)) {
                                if (s.indexOf("j")<s.indexOf("1")) {
                                    if (s.indexOf("1")<s.lastIndexOf("8")) {
                                        count++;
                                    }
                                } else {
                                    for (int k=s.indexOf("1");k<s.length();k++) {
                                        if (s.charAt(k)==s.indexOf("1")) {
                                            if (s.indexOf(j)<s.indexOf(k)) {
                                                if (s.indexOf(k)<s.lastIndexOf("8")) {
                                                    count++;
                                                } else {
                                                    for (int m=s.indexOf(k);m<s.length();m++) {
                                                        if (s.charAt(m)==s.indexOf(k)) {
                                                            if (s.indexOf(j)<s.indexOf(k)) {
                                                                if (s.indexOf(k)<s.lastIndexOf("8")) {
                                                                    count++;
                                                                } else {
                                                                    if (s.lastIndexOf("1")<s.lastIndexOf("8")) {
                                                                        count++;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}