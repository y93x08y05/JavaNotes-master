package com.jack.nowcoder.spring.BBaidu;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zhangta on 1/8/2018.
 * 去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。
 * 想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * 首先输入一个正整数N（N <= 50），
 * 接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 * 输入
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 * 输出
 * 30
 */
public class BaiDu_2017_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        /**
         * HashSet为无序存储，是由hash表实现的，add、remove、contains的复杂度为O(1)
         * 但TreeSet是comparable顺序排序存储，树形结构实现，
         * add、remove、contains的复杂度为O(log(n))
         */
        Set<Integer> set = new TreeSet<>();
        for (int i=0;i<n;i++)
            set.add(in.nextInt());
        if(set.size()<3)
            System.out.println(-1);
        else
            System.out.println(set.toArray()[2]);
    }
}
