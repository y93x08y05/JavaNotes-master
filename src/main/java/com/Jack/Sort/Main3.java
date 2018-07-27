package com.Jack.Sort;

/**
 * Created by Jack on 7/23/2018 9:37 PM
 * choose sort not stable
 */
public class Main3 {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        int position;
        for (int i=0;i<a.length;i++) {
            position = i;
            int temp = a[i];
            for (int j=i+1;j<a.length;j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}
