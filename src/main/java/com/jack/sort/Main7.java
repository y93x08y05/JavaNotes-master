package com.jack.sort;

/**
 * Created by jack on 7/24/2018 9:43 PM
 * shell sort not stable
 */
public class Main7 {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        int d = a.length;
        int temp = 0;
        while (true) {
            d = (int)Math.ceil(d / 2);
            for (int x=0;x<d;x++) {
                for (int i=x+d;i<a.length;i+=d) {
                    int j = i - d;
                    temp = a[i];
                    for (;j>=0&&temp<a[j];j-=d) {
                        a[j+d] = a[j];
                    }
                    a[j+d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}
