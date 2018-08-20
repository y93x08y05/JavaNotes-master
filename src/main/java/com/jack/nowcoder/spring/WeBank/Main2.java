package com.jack.nowcoder.spring.WeBank;

import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int sum = 0;
        for (long i=0;i<=a;i++){
            String s = g(i);
            if (is(s))
                sum++;
        }
        System.out.println(sum);
    }
    public static boolean is(String s){
        int left = 0;
        int right = s.length()-1;
        while (left <= right && s.charAt(left)==s.charAt(right)){
            left++;
            right--;
        }
        if (left > right)
            return true;
        return false;
    }
    public static String g(long n){
        StringBuffer stringBuffer = new StringBuffer();
        while(n!=0){
            stringBuffer.append(n%2);
            n=n/2;
        }
        return stringBuffer.reverse().toString();
    }
}