package com.jack.arrowOffer;

/**
 * Created by Jack on 7/30/2018 9:01 PM
 * 输入一个数，判断这个数的二进制中有多少个1
 */
public class Main09 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(getCount(n));
    }
    public static int getCount(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
