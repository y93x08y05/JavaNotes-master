package com.jack.nowcoder.autumn.duoduopin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 11:29 AM
 * 拼多多2019秋招内推笔试-Java研发
 * 运输货物
 * 有N个货物(0<=N<=1024)，每个货物的和重量是w(100<=w<=300)，如果每辆车最多载重300，求最少需要多少
 * 辆车能运输完所有货物。
 * 输入描述：
 * 一行输入，包含N个整数，表示每个货物的重量，空格分割
 * 输出描述
 * 一行输出，包含一个整数，表示需要的车辆数
 * 输入：
 * 130 140 150 160
 * 输出：2
 */
public class Goods1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] strings = str.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<strings.length;i++) {
            list.add(Integer.valueOf(strings[i]));
        }
        Collections.sort(list);
        int i;
        int j = list.size()-1;
        int num = 0;
        int k=0;
        for (i=0;i<list.size();i++) {
            if (list.get(i) == 100)
                k++;
            if ((k/3)==0) {
                num++;
                i=i+3;
            }
        }
        while (i<j) {
            if (list.get(i) + list.get(j) > 300) {
                num++;
                j--;
            }
            if (list.get(i) + list.get(j) < 300) {
                num++;
                j--;
                i++;
            }
        }
        if (i == j)
            num++;
        System.out.println(num);
    }
}
