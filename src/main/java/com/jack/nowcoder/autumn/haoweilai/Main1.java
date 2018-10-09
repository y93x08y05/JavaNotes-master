package com.jack.nowcoder.autumn.haoweilai;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/9 20:41
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long l=sc.nextLong();
        long r=sc.nextLong();
        System.out.println(find(l, r));
    }
    public static long find(long l, long r) {
        long count = 0;
        for (long i = l; i <= r; i++) {
            String s = String.valueOf(i);
            if (s.charAt(0)==s.charAt(s.length()-1))
                count++;
        }
        return count;
    }
}