package com.jack.arrowOffer;

/**
 * Created by Jack on 7/30/2018 7:48 PM
 * 二维数组从左到右递增，从上到下递增，查找是否存在某个数。
 */
public class Main01 {
    public static int[][] a = {
            {1,2,3,4},
            {2,3,4,5},
            {3,4,5,6},
            {4,5,6,7}
    };
    public static int m = 2;
    public static void main(String[] args) {
        System.out.println(find(a, m));
    }
    public static boolean find(int [][] a,int target) {
        //以最后一行第一个字符为起始开始寻找
        int i=0;
        int len = a.length - 1;
        while (len >= 0&&i<a[0].length) {
            if (a[len][i]>target) {
                len--;
            } else if (a[len][i]<target){
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
