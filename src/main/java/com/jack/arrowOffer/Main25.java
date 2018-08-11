package com.jack.arrowOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jack on 8/1/2018 2:09 PM
 * find the maximum sum of the consecutive subarray contain negative numbers
 */
public class Main25 {
    private static int [] arr = {6,-3,-2,7,-15,1,2,2};
    public static void main(String[] args) {
        System.out.println(findGreatestSum(arr));
    }
    private static int findGreatestSum(int [] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<arr.length;i++) {
            int sum = 0;
            for (int j=i;j<arr.length;j++) {
                sum+=arr[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        if (list.size() <= 0) {
            return 0;
        }
        return list.get(list.size()-1);
    }
}
