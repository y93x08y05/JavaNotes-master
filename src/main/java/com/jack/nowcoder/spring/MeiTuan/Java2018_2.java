package com.jack.nowcoder.spring.MeiTuan;

import java.util.*;
/**
 * 输入一行字符串，字符在‘0’和‘9’之间的长度
 * 输出这些字符所不能组成的最小的正整数
 * 比如55不能组成的最小的正整数为1
 * 比如123456789不能组成的最小的正整数为10
 */

public class Java2018_2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        char [] str1Char = str1.toCharArray();
        Arrays.sort(str1Char);
        int [] num = new int [str1Char.length];
        for(int i=0;i<str1Char.length;i++){
            num[i] = str1Char[i];
            Integer.parseInt(String.valueOf(str1Char[i]));
            if(str1Char[i]!=str1Char[i+1]){
            }
        }
    }
}