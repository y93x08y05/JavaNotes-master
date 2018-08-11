package com.jack.arrowOffer;

/**
 * Created by Jack on 7/30/2018 8:26 PM
 * array reverse to search min value
 */
public class Main4 {
    public static int [] a = {3,4,5,1,2};
    public static void main(String[] args) {
        System.out.println(getValue(a));
    }
    public static int getValue(int [] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }
        for (int i=0;i<a.length-1;i++) {
            if (a[i] > a[i+1]) {
                return a[i+1];
            }
        }
        return 0;
    }
}
