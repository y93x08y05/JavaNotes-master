package com.jack.nowcoder.autumn.BaiXin;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/10 21:01
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        if (s1.contains("aibank"))
            System.out.println(s1.indexOf("aibank"));
        else
            System.out.println(1);
    }
}