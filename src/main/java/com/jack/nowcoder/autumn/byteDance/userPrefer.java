package com.jack.nowcoder.autumn.byteDance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Jack on 8/9/2018 7:17 PM
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户
 * 按照他们的注册时间先后来标号，对于一类文章，每个用户都有不同的喜好值，我们会想知道
 * 某一段时间内注册的用户(标号相连的一批用户)中，有多少用户对这些文章的喜好值为k。因为
 * 一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间
 * (不存在L1<=L2<=R2<=R1)
 * 输入描述：
 * 输入：第1行为n代表用户的个数，第2行为n个整数，第i个代表用户标号为i的用户对某类文章的
 * 喜好度，第3行为一个正整数q代表查询的组数
 * 第4行到第3+q行，每行包含三个整数l,r,k代表一组查询，即标号l<=i<=r的用户中对这类文章
 * 喜好值为k的用户的个数。数据范围n<=300000,q<=300000 k是整型
 * 输出描述：
 * 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 * 输入例子：
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 * 输出例子：
 * 1
 * 0
 * 2
 * 样例解释：
 * 有5个用户，喜好值分别为1,2,3,4,5
 * 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 * 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 * 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 */
public class userPrefer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashMap<Integer,LinkedList<Integer>> hashMap = new HashMap<>();
        for (int i=0;i<m;i++) {
            int key = sc.nextInt();
            if (!hashMap.containsKey(key)) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i+1);
                hashMap.put(key,list);
            } else {
                hashMap.get(key).add(i+1);
            }
        }
        int n = sc.nextInt();
        int sum;
        int a,b,c;
        for (int i=0;i<n;i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            sum = 0;
            LinkedList<Integer> list;
            if (!hashMap.containsKey(c)) {
                System.out.println(0);
                continue;
            } else {
                list = hashMap.get(c);
            }
            for (int j=0;j<list.size();j++) {
                if (list.get(j) > b) {
                    break;
                }
                if (list.get(j) >= a)
                    sum++;
            }
            System.out.println(sum);
        }
    }
}
