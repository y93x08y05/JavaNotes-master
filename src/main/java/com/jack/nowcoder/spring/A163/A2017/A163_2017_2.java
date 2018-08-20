package com.jack.nowcoder.spring.A163.A2017;

import java.util.Scanner;

/**
 * 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,
 * 小易需要立即回公司修复这个紧急bug。假设市区是一个无限大的区域，
 * 每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。
 * 小易周围有多个出租车打车点，小易赶去办公室有两种选择，
 * 一种就是走路去公司，另外一种就是走到一个出租车打车点，
 * 然后从打车点的位置坐出租车去公司。每次移动到相邻的街道(横向或者纵向)
 * 走路将会花费walkTime时间，打车将花费taxiTime时间。
 * 小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司
 * 输入描述
 * 输入数据包括五行:
 * 第一行为周围出租车打车点的个数n(1 ≤ n ≤ 50)
 * 第二行为每个出租车打车点的横坐标tX[i] (-10000 ≤ tX[i] ≤ 10000)
 * 第三行为每个出租车打车点的纵坐标tY[i] (-10000 ≤ tY[i] ≤ 10000)
 * 第四行为办公室坐标gx,gy(-10000 ≤ gx,gy ≤ 10000),以空格分隔
 * 第五行为走路时间walkTime(1 ≤ walkTime ≤ 1000)和
 * taxiTime(1 ≤ taxiTime ≤ 1000),以空格分隔
 * 输出描述
 * 输出一个整数表示，小易最快能赶到办公室的时间
 * 输入例子
 * 2 -2 -2 0 -2 -4 -2 15 3
 * 输出例子
 * 42
 */
public class A163_2017_2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [][] array = new int[2][num];
        int [][] taxi = new int[1][2];
        for (int i=0;i<num;i++){
            array[0][i] = sc.nextInt();
        }
        for (int i=0;i<num;i++){
            array[1][i] = sc.nextInt();
        }
        taxi[0][0] = sc.nextInt();
        taxi[0][1] = sc.nextInt();
        int walkTime = sc.nextInt();
        int taxiTime = sc.nextInt();
        long min = (Math.abs(taxi[0][0])+Math.abs(taxi[0][1]))*walkTime;
        long temp ;
        for(int i=0;i<num;i++){
            temp =  ((Math.abs(array[0][i]-taxi[0][0])+
                    Math.abs(array[1][i]-taxi[0][1]))*taxiTime+
                    (Math.abs(array[0][i])+
                            Math.abs(array[1][i]))*walkTime);
            if(temp<min){
                min = temp;
            }
        }
        System.out.println(min);
    }
}