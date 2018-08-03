package com.jack.train;

/**
 * Created by Jack on 8/2/2018 2:38 PM
 */
public class Main3 {
    public static void main(String[] args) {
        int [] arr = {2,7,11,15};
        int target = 9;
        int [] arr1 = getValue(arr,target);
        System.out.println(arr1[0] + " " + arr1[1]);

    }
    public static int [] getValue(int [] arr,int target) {
        int [] temp = new int[2];
        for (int i=0;i<arr.length-1;i++) {
            if (arr[i] < target) {
                for (int j=i+1;j<arr.length;j++) {
                    if (arr[i] + arr[j] == target) {
                        temp[0] = i;
                        temp[1] = j;
                    }
                }
            }
        }
        return temp;
    }
}
