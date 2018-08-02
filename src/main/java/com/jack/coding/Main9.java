package com.jack.coding;

/**
 * Created by Jack on 7/30/2018 9:01 PM
 * input a int number and output binary how many 1
 */
public class Main9 {
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
