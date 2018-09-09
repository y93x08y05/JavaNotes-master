package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180909;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 9:48
 * 复原IP地址
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(findIP(sc.next()));
    }
    private static int findIP(String s) {
        List<String> list=new ArrayList<>();
        if (s.length()<4||s.length()>12)
            return 0;
        findIP(s,"",list,1);
        return list.size();
    }
    private static void findIP(String s,String temp,List<String> list,int count) {
        if (count==4&&isValid(s)) {
            list.add(temp+s);
            return;
        }
        int len=Math.min(4,s.length());
        for (int i=1;i<len;i++) {
            String s1=s.substring(0,i);
            if (isValid(s1)) {
                findIP(s.substring(i),temp+s1+".",list,count+1);
            }
        }
    }
    private static boolean isValid(String s) {
        if (s.charAt(0)=='0')
            return s.equals("0");
        int val=Integer.parseInt(s);
        if (0<val&&val<256)
            return true;
        else
            return false;
    }
}