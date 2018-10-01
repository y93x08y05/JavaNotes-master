package com.jack.train;

/**
 * @Author: Jack
 * @Date: 2018/9/30 13:44
 */
public class Main5 {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        System.out.println(o1==o2);
        /**
         * 判断调用equals方法的引用与传进来的引用是否一致
         * 即两个引用是否指向同一个对象
         * Object类的equals相当于==
         */
        System.out.println(o1.equals(o2));
        /**
         * String类中重写了equals方法
         */
        String s1="123";
        String s2=new String("123");
        String s3="1"+new String("23");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);
        System.out.println();
        /**
         * 字符串池中查找aaa这个对象，不存在则创建，
         * 并将aaa这个对象地址返回赋值给引用
         * 如果存在，则不创建任何对象，直接将aaa对象
         * 地址返回，并赋值给引用
         */
        String s4="aaa";
        String s5="aaa";
        System.out.println(s4.equals(s5));
        System.out.println(s4==s5);
    }
}