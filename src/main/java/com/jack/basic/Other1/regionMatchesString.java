package com.jack.basic.Other1;

/**
 * regionMatches（boolean ignoreCase，int toffset，String Other1，int ooffset，int len）；
 * regionMatches（int toffset，String Other1，int ooffset，int len）；
 * String的regionMatches两种方法可以用来进行两个字符串之间
 * 指定长度范围的比较，并且返回一个布尔值
 * 其中一种是默认忽略不忽略大小写的，也可指定参数忽略大小写
 * 用来比较两个字符串间的子串之间是否相等以作下一步处理
 * 例如文件路径等确定是否以特定字符穿开头或者结尾
 * String的lastIndexOf方法即字符或字符串首字母最后一次出现的位置
 * String的contains方法即在区分大小写的情况下判断是否存在指定字符
 */
public class regionMatchesString {
    public  static  void main(String [] args){
        String s1 = "tsinghua";
        String s2 = "it is TsingHua";
        String s3 = "love you and love you";
        String s4 = "China ia a beautiful country";
        boolean result1 = s1.regionMatches(0,s2,6,7);
        boolean result2 = s1.regionMatches(true,0,s2,6,7);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(s3.lastIndexOf("love"));
        System.out.println(s4.contains("Country"));
    }
}
