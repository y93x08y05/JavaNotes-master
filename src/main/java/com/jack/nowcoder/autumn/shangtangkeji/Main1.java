package com.jack.nowcoder.autumn.shangtangkeji;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/15 18:45
 * 给定N个左括号{和M个右括号}，其中M小于等于N，可以将其按照任意顺序排列成
 * 长度为N+M的字符串。给定N和M的值，求所有合法的排列数目。
 * 合法的排列方式是指，字符串中出现的每一个}，必须有一个已经出现的{与之匹配
 * 例如当N=3，M=1时
 * {{{}
 * {}}}都是合法的排列
 * 而}{{{不是合法的排列
 * 输入描述：
 * N M N属于{0,36}，M属于{0，N}
 * 输出描述：
 * 合法的排列数目，以十进制方式输出
 * 输入：
 * 3 1
 * 输出：
 * 3
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println(find(N, M));
    }
    public static int find(int N, int M) {
        if (N == 0 || M == 0)
            return 0;
        int res = N + M;
        int temp1=1;
        int temp2=1;
        int temp3=1;
       for (int i=1;i<res;i++) {
           temp1*=i;
       }
       for (int i=1;i<N;i++) {
            temp2*=i;
       }
       for (int i=1;i<M;i++) {
           temp3*=i;
       }
       return temp1/temp2/temp3;
    }
}