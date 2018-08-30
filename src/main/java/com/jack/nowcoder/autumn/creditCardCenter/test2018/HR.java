package com.jack.nowcoder.autumn.creditCardCenter.test2018;

import java.util.Scanner;

/**
 * Created by Jack on 8/29/2018 11:36 AM
 * 按照卡中心校园招聘的要求，HR小招和小商需要从三个科室中
 * （分别为A、B、C）抽派面试官去往不同城市。
 * 两名HR按照以下规定轮流从任一科室选择面试官：
 * 每次至少选择一位，至多选择该科室剩余面试官数。
 * 最先选不到面试官的HR需要自己出差。
 * 假设HR小招和小商都不想出差且每次选择都采取最优策略，如果是小招先选，
 * 写一个函数来判断她是否需要出差。如果不需要出差，请给出第一步的最优策略。
 * 输入描述：
 * 输入为三个正整数，分别代表三个科室的面试官人数，用英文逗号分隔
 * 输出描述
 * 若小招需要出差，则输出：1；
 * 若小招不需要出差，则输出：第一步选择的科室名称和选择人数，用英文逗号分隔
 * 输入例子
 * 1,8,9
 * 输出例子
 * 1
 * 输入例子
 * 2,0,3
 * 输出例子
 * C,2
 */
public class HR {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(",");
        int a=Integer.valueOf(str[0]);
        int b=Integer.valueOf(str[1]);
        int c=Integer.valueOf(str[2]);
        if ((a^b^c)==0) {
            System.out.println(1);
        } else if ((a^b)<c) {
            System.out.println("C,"+(c-(a^b)));
        } else if ((a^c)<b) {
            System.out.println("B,"+(b-(a^c)));
        } else if ((c^b)<a) {
            System.out.println("A,"+(a-(b^c)));
        } else {
            System.out.println(1);
        }
        sc.close();
    }
}
