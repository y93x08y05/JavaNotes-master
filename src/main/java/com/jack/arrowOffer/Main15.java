package com.jack.arrowOffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Jack on 7/30/2018 10:27 PM
 * input abc
 * output abc,acb,bac,bca,cab,cba
 */
public class Main15 {
    public static void main(String[] args) {
        String s = "aazz";
        ArrayList<String> list = permutation(s);
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
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
