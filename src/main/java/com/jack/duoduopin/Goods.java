package com.jack.duoduopin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 12:42 PM
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
public class Goods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String [] strings = str.split(" ");
        System.out.println(getCount(strings));
    }
    private static int getCount(String [] strings) {
        int [] arr = new int[strings.length];
        for (int i=0;i<strings.length;i++) {
            arr[i] = Integer.valueOf(strings[i]);
        }
        int count = 0;
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        while (i <= j) {
            if (arr[i] + arr[j] > 300) {
                j--;
                count++;
            } else if (arr[i] + arr[j] > 200 && arr[i] + arr[j] <= 300) {
                i++;
                j--;
                count++;
            } else {
                //如果i+j等于200，则i和j之间的数都为100
                count += (j-i)/3+1;
            }
        }
        return count;
    }
}
