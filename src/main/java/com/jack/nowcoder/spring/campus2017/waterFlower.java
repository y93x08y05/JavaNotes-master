package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/12/2018.
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的：
 * “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。
 * 现在要求输出所有在m和n范围内的水仙花数
 * 输入描述
 * 输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
 * 输出描述
 * 对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m,
 * 并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;
 * 如果给定的范围内不存在水仙花数，则输出no;每个测试实例的输出占一行。
 * 输入
 * 100 120
 * 300 380
 * 输出
 * no
 * 370 371
 */
public class waterFlower {
    public static void main(String [] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bf.readLine()) != null) {
            String[] str = line.split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            StringBuffer sb = new StringBuffer();
            for(int i = start; i < end; i++) {
                int a = i / 100;
                int b = (i - 100 * a) / 10;
                int c = i - 100 * a - 10 * b;
                if(a*a*a + b*b*b + c*c*c == i) {
                    sb.append(i + " ");
                }
            }
            if(sb.toString().equals("")) {
                System.out.println("no");
            }
            else {
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb.toString());
            }
        }
    }
}
