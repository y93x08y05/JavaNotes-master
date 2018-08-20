package com.jack.nowcoder.spring.TTencent.T2017;

import java.util.Scanner;

/**
 * Created by zhangta on 1/10/2018.
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 对于每组数据，输出移位后的字符串。
 * 输入
 * AkleBiCeilD
 * 输出
 * kleieilABCD
 */
public class TTencent_2017_2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(getResult(str));
        }
    }
    public static String getResult(String str){
        System.out.println(str.replaceAll("[A-Z]", "   "));
        System.out.println(str.replaceAll("[a-z]", "   "));
        return str.replaceAll("[A-Z]","")+str.replaceAll("[a-z]","");
    }
}
