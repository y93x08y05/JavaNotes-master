package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180909;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/9 9:47
 * 无重复字符的最长子字符串的长度
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(findSubStringMaxLength(sc.next()));
    }
    private static int findSubStringMaxLength(String s) {
        if (s.length()==0)
            return 0;
        int max=1;
        List<Character> list=new ArrayList<>();
        list.add(s.charAt(0));
        for (int i=1;i<s.length();i++) {
            if (list.contains(s.charAt(i))) {
                int index=list.indexOf(s.charAt(i));
                list= list.subList(index+1,list.size());
                list.add(s.charAt(i));
                if (list.size()>max)

                max=Math.max(max,list.size());
            } else {
                list.add(s.charAt(i));
                max=Math.max(max,list.size());
            }
        }
        return max;
    }
}