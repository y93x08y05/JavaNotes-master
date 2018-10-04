package com.jack.剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jack on 7/31/2018 10:32 PM
 * 输入一个包含多个数的数组，并且拼接这个数组中的所有元素，找到拼接之后
 * 最小的一个数并输出。
 */
public class Main19 {
    public static void main(String[] args) {
        long [] arr = {3,32,321};
        System.out.println(getSmallest(arr));
    }
    public static long getSmallest(long [] arr) {
        long result;
        List<String> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++) {
            list.add(String.valueOf(arr[i]));
        }
        Collections.sort(list, (o1, o2) -> {
            String m = o1 + o2;
            String n = o2 + o1;
            return m.compareTo(n);
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            sb.append(list.get(i));
        }
        result = Long.parseLong(sb.toString());
        return result;
    }
}
