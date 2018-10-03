package com.jack.algorithm.guideline.KMP算法;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/3 9:53
 */
public class KMP2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(find(s1, s2));
    }
    private static int find(String s1,String s2) {
        char []t=s1.toCharArray();
        char []p=s2.toCharArray();
        int i=0;
        int j=0;
        int []next=find(s2);
        while (i<t.length&&j<p.length) {
            if (j==-1||t[i]==p[j]) {
                i++;
                j++;
            } else {
                j=next[j];
            }
        }
        if (j==p.length)
            return i-j;
        else
            return -1;
    }
    private static int [] find(String temp) {
        char []p=temp.toCharArray();
        int []next=new int[p.length];
        next[0]=-1;
        int j=0;
        int k=-1;
        while (j<p.length-1) {
            if (k==-1||p[j]==p[k]) {
                if (p[++j]==p[++k]) {
                    next[++j]=++k;
                }
            }
            else
                k=next[k];
        }
        return next;
    }
}