package com.jack.train.AIQ;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/15 9:33
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,
 * 例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),
 * 请你来比较v1和v2的大小。
 */
public class RepeatedNumberCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();
        String s1="";
        String s2="";
        for(int i=0;i<k1;i++) {
            s1+=x1;
        }
        for(int i=0;i<k2;i++) {
            s2+=x2;
        }
        if(s1.length()<s2.length()) {
            System.out.println("Less");
        }else if(s1.length()>s2.length()) {
            System.out.println("Greater");
        }else {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int len = s1.length();
            for(int i=0;i<len;i++) {
                if(c1[i]>c2[i]) {
                    System.out.println("Greater");
                    break;
                }
                else if(c1[i]<c2[i]) {
                    System.out.println("Less");
                    break;
                }
                if(i==len-1) {
                    System.out.println("Equal");
                }
            }
        }
    }
}