package com.jack.nowcoder.autumn.creditCardCenter.test2019;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 2:33 PM
 * 农场有n只鸡鸭排成一个队伍，鸡用C表示，鸭用D表示，当鸡鸭挨着会产生矛盾，需要对所
 * 排的队伍进行调整，鸡鸭各在一边，每次调整只能让相邻的鸡和鸭交换位置，需要计算出最少
 * 需要调整多少次，可以让上述情况最少，
 * CCDCC->CCCDC->CCCCD
 * 这样就能使得两处鸡鸭相邻变为一处鸡鸭相邻
 * 输入描述
 * 输入一个长度为N，且只包含C和D的字符串
 * 输出描述
 * 使得最后只有一对鸡鸭相邻，最少的交换次数
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ji = 0;
        int ya = 0;
        int jiSum = 0;
        int yaSum = 0;
        for(int i=0;i<s.length();i++){
            if (s.charAt(i)=='D'){
                yaSum+=(i-ya);
                ya++;
            }else if(s.charAt(i)=='C'){
                jiSum +=(i-ji);
                ji++;
            }
        }
        System.out.println(Math.min(yaSum,jiSum));
    }
}
