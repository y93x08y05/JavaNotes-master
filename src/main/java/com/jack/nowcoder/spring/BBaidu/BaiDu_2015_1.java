package com.jack.nowcoder.spring.BBaidu;

import java.util.Scanner;

/**
 * 快速排序的一种
 * 给定一个01串（仅由‘ 0’或‘1’组成的字符串），
 * 现在想把这个数字串排序成“非递减”有序序列，请问至少需要多少次交换（任意两个位置交换）？
 * 输入数据第一行是一个正整数T(T<=100),表示有T组测试数据；
 * 接下来的T行，每行给出01串
 * 数据保证——
 * 50%的字符串长度在[1,100 ]
 * 95%的字符串长度在[1,10000]
 * 100%的字符串长度在[1,1000000]
 * 对于每组测试数据，请输出排成“非递减有序序列”的最小交换次数。
 * 每组输出占一行。
 * 输入例子
 * 3
 * 01
 * 10
 * 110
 * 输出例子
 * 0
 * 1
 * 1
 */
public class BaiDu_2015_1 {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for(int i =0; i < num; i++) {
            int count = 0;
            char [] arr = scanner.nextLine().toCharArray();
            int OneIndex =0;
            int ZeroIndex = arr.length - 1;
            while(OneIndex < ZeroIndex){
                while(OneIndex<arr.length-1 && arr[OneIndex]!='1') {
                    //当元素不等于1时，加1，即加到元素等于1，取得下标
                    //当元素等于1时，直接将当前下标元素赋值
                    OneIndex++;
                }
                while(ZeroIndex>0  && arr[ZeroIndex] != '0') {
                    //当元素不等于0时，减一，即减到元素等于0，取得下标
                    //当元素等于0时，直接将当前下标元素赋值
                    ZeroIndex--;
                }
                //即从两边到中间，交换元素值
                arr[OneIndex]='0';
                arr[ZeroIndex]='1';
                if(OneIndex < ZeroIndex) {
                    //即1在0前边，则此时需要交换，次数加1
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
