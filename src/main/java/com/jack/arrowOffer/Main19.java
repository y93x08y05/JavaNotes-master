package com.jack.arrowOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jack on 7/31/2018 10:32 PM
 * enter an array of integers and splicing all the numbers in the array
 * into a single number and print the smallest number
 */
public class Main19 {
    public static void main(String[] args) {
        long [] arr = {3,32,321};
        System.out.println(getSmallest(arr));
    }
    public static long getSmallest(long [] arr) {
        long result;
        List<String> list = new ArrayList<String>();
        for (int i=0;i<arr.length;i++) {
            list.add(String.valueOf(arr[i]));
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String m = o1 + o2;
                String n = o2 + o1;
                return m.compareTo(n);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            sb.append(list.get(i));
        }
        result = Long.parseLong(sb.toString());
        return result;
    }
}
