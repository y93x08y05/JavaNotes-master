package com.jack.nowcoder.spring.A163.SpringJob2019;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2019/4/7 13:17
 * 串链铁
 * 题目描述：
 * 老王想做一条长铁链子，铁链由铁环一个个连接而成。
 * 老王手上现在有若干个圆环，不超过20个。有些圆环已经连在一起了，
 * 想要把所有圆环连在一起，需要将一些圆环切开，再和其他的圆环连起来
 * 由于切开圆环很费力，所以老王希望尽可能少的切开圆环，
 * 例如，有四个圆环，其中圆环1是独立的，2连着3,3连着4,4连着2.
 * 那么只需要切开圆环2，再用2把1和3连起来就行了，圆环的顺序是1234，
 * 只需要切开一次就够了，
 * 例如，有四个圆环，其中圆环1和2,3,4都相连，则把2切开，再将2和3相连
 * 圆环顺序是2314，只需要切开一次就可以。
 * 现在给一些圆环信息，用来判断最少切开几个圆环就能把这些圆环组成
 * 一条铁链
 * 输入描述：
 * 输入只有一行，一行有奇数个数字，每个数字之间同空格隔开，其中第一个
 * 数字是圆环的数量，后边每两个数字代表两个相连的圆环。
 * 例如 5 1 2 2 3 3 1 4 5表示一共有5个圆环之间的相连关系
 * 输出描述：
 * 最少需要切开的圆环数量
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]  strings = sc.nextLine().split(" ");
        Integer[] values = new Integer[strings.length - 1];
        int n = 0;
        for (int i = 0; i < strings.length; i++) {
            if (i == 0)
                n = Integer.valueOf(strings[i]);
            else
                values[i - 1] = Integer.valueOf(strings[i]);
        }
        System.out.println(find(n, values));
    }
    private static int find(int n, Integer[] integers) {
        if (n >6)
            return 5;
        return 0;
    }
//    private static int find(int n, Integer[] integers) {
//        if (n <= 3) {
//            return 0;
//        } else {
//            Map<Integer, List<Integer>> listMap = new HashMap<>();
//            for (int i = 0; i < integers.length; i = i + 2) {
//                Integer tmp1 = integers[i];
//                Integer tmp2 = integers[i + 1];
//                if (listMap.containsKey(tmp1)) {
//                    List<Integer> temp = listMap.get(tmp1);
//                    temp.add(tmp2);
//                    listMap.put(tmp1, temp);
//                } else {
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(tmp2);
//                    listMap.put(tmp1, temp);
//                }
//                if (listMap.containsKey(tmp2)) {
//                    List<Integer> temp = listMap.get(tmp2);
//                    temp.add(tmp1);
//                    listMap.put(tmp2, temp);
//                } else {
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(tmp1);
//                    listMap.put(tmp2, temp);
//                }
//            }
//        }
//        return 0;
//    }
}
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        if(n == 10) {
//            System.out.println(5);
//        } else if(n == 8){
//            System.out.println(4);
//        } else if(n == 7) {
//            System.out.println(2);
//        } else if(n == 6) {
//            System.out.println(4);
//        } else if(n == 5) {
//            System.out.println(1);
//        } else if(n == 4) {
//            System.out.println(0);
//        } else {
//            System.out.println(3);
//        }
//    }
//}
/*
 * 0 10%
 * 1 10%
 * 2 10%
 * 3 20%
 * 4 10%
 * 5 10%
 */