package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/10/7 14:01
 * LeetCode 54
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），
 * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 例1:
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 例2:
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int [][]arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new SpiralMatrix().find1(arr));
        System.out.println(new SpiralMatrix().find2(arr));
    }
    public List<Integer> find1(int [][]arr) {
        List<Integer> list=new ArrayList<>();
        if (arr.length==0||arr[0].length==0)
            return list;
        int m=arr.length;
        int n=arr[0].length;
        int len=m*n;
        int row=0;
        int col=0;
        int leftMin=0;
        int topMin=1;
        int k=0;
        int [][]dir={{1,0,-1,0},{0,1,0,-1}};
        for (int i=0;i<len;i++) {
            list.add(arr[row][col]);
            col+=dir[0][k%4];
            row+=dir[1][k%4];
            switch (k%4) {
                case 0:
                    if (col>n-1) {
                        col=n-1;
                        row++;
                        k++;
                        n--;
                    }
                    break;
                case 1:
                    if (row>m-1) {
                        row=m-1;
                        col--;
                        k++;
                        m--;
                    }
                    break;
                case 2:
                    if (col<leftMin) {
                        col=leftMin;
                        leftMin++;
                        row--;
                        k++;
                    }
                    break;
                case 3:
                    if (row<topMin) {
                        row=topMin;
                        topMin++;
                        col++;
                        k++;
                    }
                    break;
            }
        }
        return list;
    }
    public List<Integer> find2(int [][]arr) {
        List<Integer> list=new ArrayList<>();
        if (null==arr||arr.length==0||arr[0].length==0)
            return list;
        int li=0,lj=0,ri=arr.length-1,rj=arr[0].length-1;
        while (li<=ri&&lj<=rj) {
            int i=li;
            int j=lj;
            while (j<=rj) {
                list.add(arr[i][j]);
                j++;
            }
            --j;++i;
            while (i<=ri) {
                list.add(arr[i][j]);
                i++;
            }
            --i;--j;
            while (j>lj&&li!=ri) {
                list.add(arr[i][j]);
                j--;
            }
            while (i>li&&lj!=rj) {
                list.add(arr[i][j]);
                i--;
            }
            li++;lj++;ri--;rj--;
        }
        return list;
    }
}