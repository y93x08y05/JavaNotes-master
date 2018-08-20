package com.jack.nowcoder.spring.TTouTiao;

import java.util.Scanner;

/**
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方
 * 区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。
 * （所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 * 如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点
 * 的集合并输出。
 * 第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
 * 输入描述
 * 对于 50%的数据,  1 <= N <= 10000;
 * 对于 100%的数据, 1 <= N <= 500000
 * 输出描述
 * 输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，
 * 每行两个数字分别代表点的 X 轴和 Y轴
 * 输入例子
 * 5（1 2）（5 3）（4 6）(7 5)(9 0)
 * 输出例子
 * （4 6）（7 5）（9 0）
 */
//算法复杂度太高，如何减少循环的次数
public class Toutiao_2018_2 {
    public static void main(String [] args){
        Scanner sc  = new Scanner(System.in);
        int num = sc.nextInt();
        int [][] array = new int[2][num];
        /**using 48-59
        int [][] result = new int[2][num];
        int m=0;
         */
        boolean isTrue;
        for(int i=0;i<num;i++){
            array[0][i] = sc.nextInt();
            array[1][i] = sc.nextInt();
        }
        for(int i=0;i<array[0].length-1;i++){
            for(int j=i+1;j<array[0].length;j++){
                if(array[0][i]>array[0][j]){
                    array[0][i] = array[0][j]+array[0][i];
                    array[0][j] = array[0][i]-array[0][j];
                    array[0][i] = array[0][i]-array[0][j];
                    array[1][i] = array[1][j]+array[1][i];
                    array[1][j] = array[1][i]-array[1][j];
                    array[1][i] = array[1][i]-array[1][j];
                }
            }
        }
        for(int i=0;i<array[0].length;i++){
            isTrue = true;
            for(int j=i+1;j<array[0].length;j++){
                if(array[1][i]<array[1][j]){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                System.out.println(array[0][i]+" "+array[1][i]);
            }
        }
        /**using 48-59 to replace this
        for(int i=array[0].length-1;i>=0;i--){
            if(i==array[0].length-1){
                result[0][m] = array[0][i];
                result[1][m] = array[1][i];
            }else{
                isTrue = true;
                for(int j=i+1;j<array[0].length;j++){
                    if(array[1][i]<array[1][j]){
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue){
                    m++;
                    result[0][m] = array[0][i];
                    result[1][m] = array[1][i];
                }
            }
        }
        for(int i=m;i>=0;i--){
            System.out.println(result[0][i]+" "+result[1][i]);
        }
         */
    }
}