package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/6/2018.
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数
 * 得到"相反数"。例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,
 * 我们得到5231,之后再加上原先的数,我们得到5231+1325=6556.如果颠倒之后
 * 的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1.
 */
public class A163_2018_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(Integer.parseInt(new StringBuilder(s).reverse().toString())+Integer.parseInt(s));
        sc.close();
    }
}
