package com.jack.train;

/**
 * Created by Jack on 8/2/2018 9:18 PM
 * input unsigned integer and return the number of digits in the binary of '1'
 * when number is 2147483648 will not be get by Math method in Java code
 * so use Integer.toBinaryString and then to solve
 */
public class Main8 {
    public static void main(String[] args) {
        int n = 2147;
        getNumber(n);
    }
    public static int getNumber(int n) {
        int ans=0;
        String s=Integer.toBinaryString(n);
        for(char i:s.toCharArray()) {
            if(i == '1')
            ans++;
        }
        return ans;
    }
}
