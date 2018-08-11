package com.jack.arrowOffer;

/**
 * Created by Jack on 8/1/2018 11:21 AM
 * if tree is not empty
 * if left tree is not empty,
 * all of value left tree less than value of root;
 * if right tree is not empty,
 * all of value right tree more than value of root.
 */
public class Main23 {
    public static void main(String[] args) {
        int [] arr = {2,8,1,5,7,6,4};
        System.out.println(verifyPostOrder(arr));
    }
    public static boolean verifyPostOrder(int [] arr) {
        if (arr.length == 0)
            return false;
        return isPostSort(arr,0,arr.length-1);
    }
    public static boolean isPostSort(int [] arr,int start,int end) {
        if (end <= start)
            return true;
        int i = start;
        for (;i<end;i++) {
            if (arr[i] > arr[end])
                break;
        }
        for (int j=i;j<end;j++) {
            if (arr[j] < arr[end])
                return false;
        }
        return isPostSort(arr,start,i-1) && isPostSort(arr,i,end-1);
    }
}
