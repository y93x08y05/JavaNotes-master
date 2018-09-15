package com.jack.arrowOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Jack on 7/30/2018 10:27 PM
 * 输入一个字符串，输出这个字符串的全排列
 * input abc
 * output abc,acb,bac,bca,cab,cba
 */
public class Main15 {
    public static void main(String[] args) {
        String s = "abc";
        List<String> list = permutation(s);
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
    public static List<String> permutation(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        char [] chars = s.toCharArray();
        TreeSet<String> treeSet = new TreeSet<>();
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
