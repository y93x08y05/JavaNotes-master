package com.jack.byteDance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 10:01 PM
 * P为给定的二维平面整数点集，定义P中某点X，如果X满足P中任意点都不在X的右上方区域内，
 * 横纵坐标都大于X，则称其为最大的，求出所有最大的点的集合，所有点的横坐标和纵坐标都
 * 不重复
 * 输入描述：
 * 第一行输入点集的个数N，接下来N行，每行两个数字代表点的X轴和Y轴
 * 对于50%的数据，1<=N<=10000，对于100%的数据，1<=N<=500000
 * 输出描述：
 * 输出最大的店的集合，按照X轴从小到大的方式输出，每行两个数字分别代表点的X轴和Y轴
 * 输入例子：
 * 5
 * 1 2
 * 5 3
 * 4 6
 * 7 5
 * 9 0
 * 输出例子：
 * 4 6
 * 7 5
 * 9 0
 */
public class pointMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][2];
        for (int i=0;i<arr.length;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int temp;
        int temp1;
        int temp2;
        for (int i=0;i<arr.length-1;i++) {
            temp = arr[i][0];
            for (int j=i+1;j<arr.length;j++) {
                if (temp > arr[j][0]) {
                    temp1 = arr[j][0];
                    temp2 = arr[j][1];
                    arr[j][0] = arr[i][0];
                    arr[j][1] = arr[i][1];
                    arr[i][0] = temp1;
                    arr[i][1] = temp2;
                }
            }
        }
        for (int i=0;i<arr.length;i++) {
        }
    }
}
