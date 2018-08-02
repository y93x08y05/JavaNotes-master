package com.jack.coding;

/**
 * Created by Jack on 7/31/2018 10:25 PM
 * find the number of occurrences of any non negative integer range 1
 */
public class Main18 {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(getNumber(n));
    }
    public static int getNumber(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char [] ch = str.toCharArray();
            for (int i=0;i<ch.length;i++) {
                if (ch[i] == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}
