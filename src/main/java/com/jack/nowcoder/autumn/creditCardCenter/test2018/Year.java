package com.jack.nowcoder.autumn.creditCardCenter.test2018;

import java.util.Scanner;

/**
 * Created by Jack on 8/29/2018 11:39 AM
 * 公司年会上，组织人员安排了一个小游戏来调节气氛。游戏规则如下：
 * N个人参与游戏，站成一排来抢工作人抛来的M个小玩偶。
 * 为了增加游戏的趣味和难度，规则规定，
 * 参与游戏的人抢到的礼物不能比左右两边的人多两个或以上，
 * 否则会受到一定的惩罚。游戏结束时拥有玩偶最多的人将获得一份大奖。
 * 假设大家都想赢得这份大奖，
 * 请问站在第K个位置的小招在赢得游戏时，最多能拥有几个玩偶？
 * 输入描述：
 * 为用空格分隔的3个正整数，依次为：参与游戏人数N、玩偶数M、小招所在位置K
 * 输出描述：
 * 输出为1个正整数，代表小招最多能够拥有的玩偶数。若没有，则输出0。
 * 输入例子1:
 * 1 1 0
 * 输出例子1:
 * 0
 * 输入例子2:
 * 1 3 1
 * 输出例子2:
 * 3
 */
public class Year {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            if (n==0||m==0||k==0) {
                System.out.println(0);
            } else {
                for (int max=m;max>0;max--) {
                    int sum=max;
                    for (int i=1;i<=k-1;i++) {
                        sum+=(max-i)>0?(max-i):0;
                    }
                    for (int i=1;i<=n-k;i++) {
                        sum+=(max-i)>0?(max-i):0;
                    }
                    if (sum<=m) {
                        System.out.println(max);
                        break;
                    }
                }
            }
        }
    }
}
