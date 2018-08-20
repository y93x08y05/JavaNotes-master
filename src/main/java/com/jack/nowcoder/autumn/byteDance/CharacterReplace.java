package com.jack.nowcoder.autumn.byteDance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Jack on 8/9/2018 9:37 PM
 * 字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母
 * 进行交换，请问在至多交换m之后，字符串中最多有多少个连续的位置上的字母相同。
 * 输入描述：
 * 第一行为一个字符串S与一个非负整数m，(1<=|S|<=1000,1<=m<=10000000)
 * 输出描述：
 * 一个非负整数，表示操作之后连续最长的相同字母数量
 * 输入例子：
 * abcbaa 2
 * 输出例子
 * 2
 * 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
 * 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现
 */
public class CharacterReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = sc.nextInt();
        HashSet<Character> set = new HashSet<>();
        for (int i=0;i<s.length();i++)
            set.add(s.charAt(i));
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (char c : set) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=0;i<s.length();i++) {
                if (c==s.charAt(i))
                    list.add(i);
            }
            ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
            lists.add(list1);
        }
    }
}
