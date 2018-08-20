package com.jack.nowcoder.spring.A163.A2017;

import java.util.Scanner;

/**
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),
 * 当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：
 * 每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),
 * 一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).
 * 现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态
 * 输入描述
 * 输入数据包括两行： 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),
 * 以空格分隔 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99
 * 输出描述
 * 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格
 * 输入
 * 3 2 1 2 3
 * 输出
 * 8 9 7
 */
public class A163_2017_5 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int [] array = new int[num1];
        for (int i=0;i<num1;i++){
            array[i] = sc.nextInt();
        }
        StringBuffer sb = new StringBuffer();
        int temp;
        while(num2>0){
            temp = array[0];
                for (int i=0;i<array.length;i++){
                    if (i<array.length-1){
                        array[i] = (array[i] + array[i+1])%100;
                        if (num2 == 1){
                            sb.append(array[i]).append(" ");
                        }
                    }else{
                        array[i] = (array[i] + temp)%100;
                        if (num2 == 1){
                            sb.append(array[i]);
                        }
                    }
                }
            num2--;
        }
        System.out.println(sb);
    }
}