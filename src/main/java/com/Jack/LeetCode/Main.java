package com.Jack.LeetCode;

/**
 * Created by Jack on 7/21/2018 3:58 PM
 * 给定一个32位有符号整数，将整数中的数字进行反转。
 * 假设只能存储32位有符号整数，其数值范围是[−231,231−1]。
 * 根据这个假设，如果反转后的整数溢出，则返回0。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
    public static int reverse(int x) {
        String z = "2147483647";
        String y = "2147483648";
        if (x > 0) {
            String m = String.valueOf(x);
            m = new StringBuffer(m).reverse().toString();
            if(m.length() >= z.length() && m.compareTo(z) > 0) {
                return 0;
            }
            x = Integer.valueOf(m).intValue();
            return x;
        } else {
            x = -x;
            String m = String.valueOf(x);
            m = new StringBuffer(m).reverse().toString();
            if(m.length() >= y.length() && m.compareTo(y) > 0){
                return 0;
            }
            x = Integer.valueOf(m).intValue();
            return -x;
        }
    }
}
