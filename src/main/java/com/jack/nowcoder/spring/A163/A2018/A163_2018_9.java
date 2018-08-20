package com.jack.nowcoder.spring.A163.A2018;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by zhangta on 1/8/2018.
 * 彩色砖块，每种颜色用一个大写字母表示，砖块看起来完全一样
 * 给定的字符串s,s中每个字符代表某个砖块的颜色
 * 砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的
 * 计算有多少种方式将他所有砖块排成漂亮的一行
 * 如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的
 * s = "ABAB",那么有六种排列的结果:
 * "AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 * 只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块
 * 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),
 * s中的每一个字符都为一个大写字母(A到Z)
 * 输出一个整数,表示可以有多少种方式
 */
public class A163_2018_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            hashSet.add(string.substring(i, i + 1));
            if (hashSet.size() > 2) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(hashSet.size());
    }
}
