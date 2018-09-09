package com.jack.nowcoder.autumn.wangyi.WY20180908_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 14:38
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(findHeiBai0(s));
        System.out.println(findHeiBai1(s));
    }
    private static int findHeiBai0(String s) {
        int sum=Integer.MIN_VALUE;
        for (int i=0;i<s.length();i++) {
            int res=findLength2(s.substring(0,i),s.substring(i,s.length()));
            if (res>sum)
                sum=res;
        }
        return sum;
    }
    private static int findLength2(String s1,String s2) {
        String s=new StringBuilder(s1).reverse().append(new StringBuilder(s2).reverse()).toString();
        int maxLen = 1;
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
            } else {
                len = 1;
            }
        }
        return maxLen;
    }
    private static int findLength(String s1,String s2) {
        int count=Integer.MIN_VALUE;
        int temp=0;
        boolean flag=true;
        String s=new StringBuilder(s1).reverse().append(new StringBuilder(s2).reverse()).toString();
        for (int i=0;i<s.length()-1;i++) {
            if (s.charAt(i)!=s.charAt(i+1)) {
                temp++;
            } else {
                if (temp>count)
                    count=temp;
                temp=0;
            }
            if (i==s.length()-2)
                if (temp>count)
                    count=temp;
        }
        return count==0?count:count+1;
    }
    private static int findHeiBai1(String s) {
        if (s.length()==0||s==null)
            return 0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i),1);
            }
        }
        if (map.size()==1)
            return 0;
        else {
            int n1=map.get('b');
            int n2=map.get('w');
            return n1>n2?n2*2+1:n1*2+1;
        }
    }
}