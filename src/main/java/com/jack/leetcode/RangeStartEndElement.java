package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 6:56 PM
 * LeetCode 34
 * give a sorted array and find target in array
 * first appear position and last appear position
 * if found return position else return [-1,-1]
 */
public class RangeStartEndElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        findRange(arr,target);
    }
    private static int [] findRange(int [] arr,int target) {
        int start = 0;
        int end = arr.length;
        int mid = (start+end)/2;
        int val = -1;
        while (start<end) {
            if (arr[mid]<target) {
                if (start==mid)
                    break;
                start=mid;
                mid=(start+end)/2;
            } else if (arr[mid]>target){
                if (end==mid)
                    break;
                end=mid;
                mid=(start+end)/2;
            } else {
                val = mid;
                break;
            }
        }
        if (val == -1)
            return new int[]{-1,-1};
        int a = val;
        int b = val;
        while (a>0&&arr[a-1]==target)
            a--;
        while (b<arr.length-1&&arr[b+1]==target)
            b++;
        return new int[]{a,b};
    }
}
