package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

/**
 * Created by zhangta on 3/12/2018.
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 输入数据有多组，每组占一行，由两个整数n（n < 10000）和m(m < 1000)组成，n和m的含义如前所述。
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 * 输入
 * 81 4
 * 2 2
 * 输出
 * 94.73
 * 3.41
 */
public class shulie {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr ;
        while((inputStr = br.readLine())!=null) {
            String[] input = inputStr.split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            double result = 0;
            double num = n;
            for(int i = 0; i < m; i++) {
                result += num;
                num = Math.sqrt(num);
            }
            result = (Math.round(result*100));
            if(result%100==0) {
                System.out.println(result/100 + ".00");
            }
            else if(result%10==0) {
                System.out.println(result/100.0 + "0");
            }
            else
                System.out.println(result/100.0);
        }
    }
}
