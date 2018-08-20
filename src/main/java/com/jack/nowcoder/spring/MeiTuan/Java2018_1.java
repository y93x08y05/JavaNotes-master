package com.jack.nowcoder.spring.MeiTuan;

import java.util.Scanner;
/**
 * 输入两个字符串，长度分别为S和L
 * 其中第一个字符串的长度大于等于第二个字符串的长度
 * 第一个字符串包含S-L+1个与第二个字符串长度一样的子串
 * 比较这样的子串与第二个字符串
 * 比如abc与abd，则其不同字符的总长度为1
 * 即比较字符串的每个对应位置字符，不同则加1
 * 输入最终的第一个字符串的所有子串与第二个字符串的这样长度之和
 */

public class Java2018_1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int str1Length = str1.length();
        int str2Length = str2.length();
        char [] str2Char = str2.toCharArray();
        int count = str1Length-str2Length+1;
        int sum =0;
        for(int i=0;i<count;i++){
            char [] str1Char = str1.substring(i,str2Length+i).toCharArray();
            for(int j=0;j<str2Char.length;j++){
                if(str1Char[j]!=str2Char[j]){
                    sum+=1;
                }
            }
        }
        System.out.println(sum);
    }
}