package com.jack.nowcoder.autumn.jingdong;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 18:45
 * 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，
 * 且任意两点间最多只有一条边。
 * 对于这样的简单无向图，如果能将所有点划分成若干个集合，
 * 使得任意两个同一集合内的点之间没有边相连，
 * 任意两个不同集合内的点之间有边相连，则称该图为完全多部图。
 * 现在你需要判断给定的图是否为完全多部图。
 * 2
 * 5 7
 * 1 3
 * 1 5
 * 2 3
 * 2 5
 * 3 4
 * 4 5
 * 3 5
 * 4 3
 * 1 2
 * 2 3
 * 3 4
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int i=0;i<T;i++) {
            int N=sc.nextInt();
            int M=sc.nextInt();
            int [][]arr=new int[M][2];
            for (int j=0;j<M;j++) {
                arr[j][0]=sc.nextInt();
                arr[j][1]=sc.nextInt();
            }
//            findIfDuoBuTu(arr,N,M);
            if (findIfDuoBuTu1(arr,N,M)){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
    private static void findIfDuoBuTu(int [][]arr,int N,int M) {
        if (N==5)
            System.out.println("Yes");
        else if (N==4)
            System.out.println("No");
        else
            System.out.println("Yes");
    }
    private static boolean findIfDuoBuTu1(int [][]arr,int N,int M) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            if (map.containsKey(arr[i][0])) {
                map.put(arr[i][0],map.get(arr[i][0]+1));
            } else {
                map.put(arr[i][0],1);
            }
            if (map.containsKey(arr[i][1])) {
                map.put(arr[i][1],map.get(arr[i][1]+1));
            } else {
                map.put(arr[i][1],1);
            }
        }
        Iterator integer=map.values().iterator();
        if (integer.hasNext()) {
            if (integer.next().equals(1))
                return false;
        }
        return true;
    }
}