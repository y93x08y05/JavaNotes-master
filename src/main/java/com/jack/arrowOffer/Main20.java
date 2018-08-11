package com.jack.arrowOffer;

/**
 * Created by Jack on 7/31/2018 11:09 PM
 * find the Nth ugly number in the order from small to large
 * ugly number is only have 2 or 3 or 5
 */
public class Main20 {
    public static void main(String[] args) {
        int index = 7;
        System.out.println(getUglyNumber(index));
    }
    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int [] result = new int[index];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        result[0]  = 1;
        int temp;
        while (count < index - 1) {
            temp = Math.min(result[i2]*2,Math.min(result[i3]*3,result[i5]*5));
            if (temp == result[i2]*2) {
                i2++;
            }
            if (temp == result[i3]*3) {
                i3++;
            }
            if (temp == result[i5]*5) {
                i5++;
            }
            result[++count] = temp;
        }
        return result[index-1];
    }
}
