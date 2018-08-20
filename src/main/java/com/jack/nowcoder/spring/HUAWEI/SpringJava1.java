package com.jack.nowcoder.spring.HUAWEI;

/**
 *  在GBK编码下，编写一个截取字符串的函数，输入为一个字符串和字节数，
 *  输出为按字节数截取的字符串
 *  输入描述：
 *  一行字符串和待截取的字节数
 *  输入华HUA，则输出华HU
 *  保证汉字不会被截取半个，同时忽略字符串中的数字后输出最终结果
 */

import java.util.Scanner;

public class SpringJava1 {
    public static void main(String [] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = scanner.nextInt();
        StringBuffer sb = new StringBuffer();
        System.out.println('1');
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57){

            } else {
                sb.append(s.charAt(i));
            }
        }
        String r = splitString(sb.toString(),num);
        System.out.println(r);
    }
    public static String splitString(String str,int length) throws Exception{
        if (str == null || str.length() < 1 || length < 1){
            return "";
        }
        int wordCount = 0;
        byte [] gbk = str.getBytes("GBK");
        for (int i=0;i<length;i++){
            int val = gbk[i];
            if (val < 0){
                System.out.println(val);
                wordCount++;
            }
            System.out.println("wordCount" + wordCount);
        }
        if (wordCount % 2 == 0) {
            return str.substring(0,(length-(wordCount/2)));
        }
        return str.substring(0,(length-(wordCount/2)-1));
    }
}