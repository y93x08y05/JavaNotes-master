package com.jack.nowcoder.spring.A163.SpringJava0419;

/**
 * 三个数字X，Y，Z，两种操作：
 * （1）任选两个数字同时加1；（2）任选一个数字加2
 * 每次执行一种操作，则最少执行几次使得三个数字一样大
 * 一定存在这样的操作使得三个数字一样大
 * 贪心算法
 * 输入三个数并对其进行排序为x,y,z
 * （1）如果x,y之间差距为偶数,则x+2使得x,y相等，然后对x,y分别加1，使得x,y,z相等
 * （2）如果x,y之间为奇数，则对x和y分别加1,使得y=z,如果x和z之间差距为偶数,
 * 则对x加2,使得x,y,z相等
 * （3）如果x,z之间差距为奇数,则x+2使得x比z,y都大1,再分别对y,z加1,使得x,y,z相等
 */

import java.util.Arrays;
import java.util.Scanner;

public class Java2 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int [3];
        for (int i=0;i<arr.length;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        if ((y - x) % 2 == 0){
            /*
             * (y-x)/2为计算让x等于y时，执行的次数
             * z-y为计算x和y相等后，给x和y同时加1需要操作的次数
             */
            System.out.println((y - x) / 2 + z - y);
        } else {
            int sum1 = z - y;//对x和y分别加1，使得y等于z要操作的次数
            int sum2 = z - x -sum1;
            if (sum2 % 2 == 0){
                System.out.println(sum1 + sum2 / 2);
            } else {
                //即sum1+sum2/2+1+1
                //sum2/2使得x比y和z都小1，然后+1是使得x+2比y和z都大1，
                //然后+1是对y和z加1使得三个数之间相等
                System.out.println(sum1 + sum2 / 2 + 2);
            }
        }
    }
}