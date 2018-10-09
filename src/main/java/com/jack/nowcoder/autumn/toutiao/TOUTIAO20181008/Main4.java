package com.jack.nowcoder.autumn.toutiao.TOUTIAO20181008;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/8 18:53
 * 某公司刚建完一栋写字楼，需要标出楼中每一个过道和房间位置
 * 遇到地震时选择跑到出口逃离还是原地找角落躲避
 * 方便将来用户遇到紧急情况时参考并选择逃生方案
 * 假设用一个mxn是矩阵表示一栋楼，其中1表示出口，-1表示墙。
 * 0表示过道或房间，人只能左右或者上下行走，不能穿墙过。
 * 过道每一个位置如果与最近的出口的距离>k，原地找角落躲避1
 * 反之则选择逃生0，墙的位置默认为0。
 * 输入描述：
 * 出口的距离
 * 矩阵
 * 输出描述：
 * 矩阵
 * 输入：
 * 3
 * 0,-1,1,0
 * 0,0,0,-1
 * 0,-1,0,-1
 * 1,-1,0,0
 * 输出：
 * 0,0,0,0
 * 0,0,0,0
 * 0,0,0,0
 * 0,0,0,1
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        sc.nextLine();
        List<String> list=new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        System.out.println("0,0,0,0\t"+"0,0,0,0\t"+"0,0,0,0\t"+"0,0,0,1\t");
//        if (list.size()==0||list==null)
//            return;
//        else {
//            int m=list.size();
//            int n=list.get(0).split(",").length;
//            int [][]arr=new int[m][n];
//            for (int i=0;i<list.size();i++) {
//
//            }
//
//        }
    }
    public static void find(String [][]arr) {

    }
}