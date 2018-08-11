package com.jack.arrowOffer;

/**
 * Created by Jack on 7/30/2018 8:50 PM
 * one frog could jump one step, two step and n step
 * how many method jump a n steps
 * every step have two choose one is jump another is not jump
 */
public class Main7 {
    public static void main(String[] args) {
        int target = 5;
        System.out.println(getValue(target));
    }
    public static int getValue(int target) {
        return (int) Math.pow(2,target-1);
    }
}
