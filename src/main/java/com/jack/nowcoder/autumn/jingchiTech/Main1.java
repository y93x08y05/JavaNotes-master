package com.jack.nowcoder.autumn.jingchiTech;


import java.util.*;

/**
 * 题目描述：
 * 运输公司A承包了某一地区的乘客运输服务。这个地区有N个城市（编号从1到N），并且在一开始，每个城市中都有且只有一位乘客，
 * 并且乘客的编号与城市的相同。由于人手短缺，这家公司在任意时刻只能派出一辆公交车。
 * 这辆车可以把一个城市中的所有乘客都运送到另一个城市中。
 * 为了更好的调配车辆，这家公司想知道在给定车辆运输记录之后，每个乘客的位置，以及这个乘客所在城市中有多少人。
 * 总共有两种指令：
 * 1. 运输指令（T a b）：代表派出一辆车，把城市a中的所有乘客都送到城市b中。
 * 2. 查询指令（Q x）：输出乘客x所在的城市，以及这个城市中有多少乘客，用空格隔开。
 * 输入
 * 第一行输入包含了两个整数，N 和 A (2 < N <= 50000 , 2 < A <= 100000)。N代表了有多少个城市，A代表了有多少条指令。
 * 接下来有A行，每行都是一条指令。
 * 输出
 * 一个查询指令，对应了一行输出。每个输出包含两个用空格隔开的整数： X Y。X代表了乘客所在的城市，Y代表了这个城市中有多少乘客。
 * 样例输入
 * 3 3
 * T 1 2
 * T 3 2
 * Q 2
 * 样例输出
 * 2 3
 */

public class Main1 {
    public static Map<Integer,List<Integer>> map=new HashMap();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int A=sc.nextInt();
        for (int i=0;i<N;i++) {
            List<Integer> list=new ArrayList<>();
            list.add(i+1);
            map.put(i+1,list);
        }
        for (int i=0;i<A;i++) {
            String s=sc.next();
            if (s.equals("T")) {
                int val1=sc.nextInt();
                int val2=sc.nextInt();
                map.get(val2).addAll(map.get(val1));
                map.put(val1,new ArrayList<>());
            } else if (s.equals("Q")) {
                int val3=sc.nextInt();
                for (int m=0;m<N;m++) {
                    if (map.get(m+1).contains(val3)) {
                        System.out.println(m+1+" "+map.get(m+1).size());
                    }
                }
            }
        }
    }
}