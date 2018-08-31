package com.jack.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jack on 8/31/2018 10:51 AM
 */
public class MapDemo {
    private static Map<Integer,List<Integer>> map=new HashMap<>();
    private static int [][]arr={{5,2},{5,6},{5,11},{5,15},{5,19}, {5,23},
            {11,2},{11,6},{11,11},{11,15},{11,19}, {11,23}};
    public static void main(String[] args) {
        createData(arr);
        System.out.println("X-axis is "+getData(12).get(0)+"\nY-axis is "+getData(12).get(1));
    }
    private static void createData(int [][]arr) {
        for (int i=0;i<12;i++) {
            List<Integer> list=new ArrayList<>();
            list.add(arr[i][0]);
            list.add(arr[i][1]);
            map.put(i+1,list);
        }
    }
    private static List<Integer> getData(int key) {
        return map.get(key);
    }
}
