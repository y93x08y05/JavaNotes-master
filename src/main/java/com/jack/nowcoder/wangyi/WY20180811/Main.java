package com.jack.nowcoder.wangyi.WY20180811;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Jack on 8/11/2018 2:43 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            sb.append("a");
            n--;
        }
        while (m>0) {
            sb.append("z");
            m--;
        }
        String s = sb.toString();
        ArrayList<String> list = permutation(s);
        if (list.size()>=k)
            System.out.println(list.get(k-1));
        else
            System.out.println(-1);
    }
    public static ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        char [] chars = s.toCharArray();
        TreeSet<String> treeSet = new TreeSet<String>();
        permutation(chars,0,s.length()-1,treeSet);
        result.addAll(treeSet);
        return result;
    }
    public static void permutation(char [] chars,int begin,int end,TreeSet<String> treeSet) {
        if (begin == end) {
            treeSet.add(String.valueOf(chars));
        } else {
            for (int i=begin;i<=end;i++) {
                swap(chars,begin,i);
                permutation(chars,begin+1,end,treeSet);
                swap(chars,begin,i);
            }
        }
    }
    public static void swap(char [] x,int a,int b) {
        if (a == b) {
        } else {
            char t = x[a];
            x[a] = x[b];
            x[b] = t;
        }
    }
}
