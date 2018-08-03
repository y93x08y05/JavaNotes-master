package com.jack.train;

/**
 * Created by Jack on 8/2/2018 8:43 PM
 * merge two sorted array
 */
public class Main7 {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,0,0,0};
        int [] arr2 = {2,5,6};
        merge(arr1,3,arr2,3);
    }
    public static void merge(int [] arr1,int m,int [] arr2,int n) {
        int l1 = m-1,l2=n-1;
        int len = l1+l2+1;
        while(l2>=0){
            arr1[len--]= (l1>=0&&arr1[l1]>arr2[l2])?arr1[l1--]:arr2[l2--];
        }
    }
}
