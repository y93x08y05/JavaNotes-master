package com.jack.nowcoder.spring.JingDong;

import java.util.Scanner;

public class SpringJava2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            //此处应该用nextLong，不然不能处理所有的数据
            //也就是09/04为什么不能百分百对的原因，时刻注意数据范围
            //题目数值范围为2^63,int最大到2^31，所以会越界
            long N = sc.nextLong();
            if (N % 2 == 1){
                System.out.println("No");
            }else{
                long Y = 2;
                long X = N/2;
                while (X % 2 == 0){
                    Y *= 2;
                    X /= 2;
                }
                System.out.println(X + " " + Y);
            }
        }
    }
}