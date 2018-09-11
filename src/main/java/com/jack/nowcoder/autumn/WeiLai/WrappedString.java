package com.jack.nowcoder.autumn.WeiLai;

import java.util.HashSet;

/**
 * @Author: Jack
 * @Date: 2018/9/11 21:22
 */
public class WrappedString {
    private String s;
    public WrappedString(String s) {
        this.s=s;
    }

    public static void main(String[] args) {
        HashSet<Object> set=new HashSet<>();
        WrappedString ws1=new WrappedString("aardvark");
        WrappedString ws2=new WrappedString("aardvark");
        String s1=new String("aardvark");
        String s2=new String("aardvark");
        set.add(ws1);
        set.add(ws2);
        set.add(s1);
        set.add(s2);
        System.out.println(set.size());
    }
}