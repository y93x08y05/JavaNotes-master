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
        String requestBody = "{\n" +
                "  \"Inputs\": {\n" +
                "    \"input1\": {\n" +
                "      \"ColumnNames\": [\n" +
                "        \"A\",\n" +
                "        \"B\",\n" +
                "        \"C\",\n" +
                "        \"D\",\n" +
                "        \"E\",\n" +
                "        \"F\",\n" +
                "        \"G\",\n" +
                "        \"H\",\n" +
                "      ],\n" +
                "      \"Values\": [\n" +
                "        [\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "        ],\n" +
                "        [\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "          \"-90\",\n" +
                "        ]\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"GlobalParameters\": {}\n" +
                "}";
        System.out.println(requestBody);
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
        int A=3;
        int B=4;
        String a1="\""+A+"\""+",\n"+"\""+B+"\""+",\n";
        System.out.println(a1);
        return map.get(key);
    }
}
