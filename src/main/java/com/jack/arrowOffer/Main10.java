package com.jack.arrowOffer;

/**
 * Created by Jack on 7/30/2018 9:08 PM
 * 调整数组顺序让奇数在前，偶数在后
 */
public class Main10 {
    public static void main(String[] args) {
        int [] a = {1,3,2,5,6,8,7};
        orderArray(a);
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void orderArray(int [] a) {
        for (int i=0;i<a.length-1;i++) {
            for (int j=0;j<a.length-1-i;j++) {
                if (a[j]%2 == 0 && a[j+1]%2 == 1) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
