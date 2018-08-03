package com.jack.train;

/**
 * Created by Jack on 8/2/2018 9:40 PM
 * when number is 2147483648 will not be get by Math method in Java code
 */
public class Main9 {
    public static void main(String[] args) {
        int n = 43261596;
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<32-s.length();i++) {
            sb.append(0);
        }
        s = sb.append(s).toString();
        int sum = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '1')
            sum += (int) Math.pow(2,i);
        }
        System.out.println(sum);
        getNumber(n);
    }
    public static int getNumber(int n) {
        int value = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) {
                value = (value << 1) + 1;
                n >>= 1;
            } else {
                value = value << 1;
                n >>= 1;
            }
        }
        return value;
    }
}
