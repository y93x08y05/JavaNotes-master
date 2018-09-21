package com.jack.basic.demo;

/**
 * Created by Jack on 8/16/2018 9:46 AM
 */
public class SortDemo {
    public static void main(String[] args) {
        int [] arr = {1,5,3,7,2,6,4};
        getStatic(arr);
    }
    public static void getStatic(int [] arr) {
        int position;
        int value;
        for(int i=0;i<arr.length-1;i++) {
            position=i;
            value=arr[i];
            for(int j=i+1;j<arr.length;j++) {
                if(value>arr[j]) {
                    value=arr[j];
                    position=j;
                }
            }
            arr[position]=arr[i];
            arr[i]=value;
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
