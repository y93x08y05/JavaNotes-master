package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by zhangta on 3/11/2018.
 * 题目描述
 * 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 * 如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 * 如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 * 有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
 * 每组数据输出一个表示最大的整数。
 * 输入
 * 2
 * 12 123
 * 4
 * 7 13 4 246
 * 输出
 * 12312
 * 7424613
 */
public class ShuChuan {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(bf.readLine());
        String[] str = bf.readLine().split(" ");
        Arrays.sort(str, (o1, o2) -> {
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s1.compareTo(s2);
            /**
             * 取出两个字符串的长度，比较较小的长度内，两者是否相等
             * 若不相等，直接返回该位置ASCII码相减后的值
             * 若各位置都相等，将两个字符串长度的差值返回
             */
        });
        StringBuffer sb = new StringBuffer();
        for(int i= str.length-1; i>=0; i--){
            sb.append(str[i]);
        }
        System.out.print(sb);
    }
}
