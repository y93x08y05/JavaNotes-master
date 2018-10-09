package com.jack.nowcoder.autumn.toutiao.TOUTIAO20181008;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/8 18:53
 * 玩家小豆是一位魔兽世界玩家，里面每件装备有装备等级的概念
 * 装备等级越高，游戏角色越厉害。现在小豆手中有n个金币
 * 但是身上最多穿m件装备，每件装备的对应的价格x金币。
 * 对应的装备等级是y。现在小豆想要用手上的金币买到装备等级
 * 最大的装备组合，问小豆能买到最大的装备等级。
 * 输入描述：
 * 金币数量n
 * 最多穿装备的数量m
 * 价格x，装备等级y。
 * 输出描述，能买到装备的等级加和。
 * 输入：
 * 130
 * 3
 * 100 380
 * 20 320
 * 40 360
 * 50 310
 * 输出：
 * 990
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int m=sc.nextInt();
        sc.nextLine();
        List<List<Integer>> lists=new ArrayList<>();
        while (sc.hasNextLine()) {
            String []str=sc.nextLine().split(" ");
            List<Integer> list=new ArrayList<>();
            list.add(Integer.parseInt(str[0]));
            list.add(Integer.parseInt(str[1]));
            lists.add(list);
        }
        System.out.println(find(n, m, lists));
    }
    public static int find(int n, int m, List<List<Integer>> lists) {
        return 0;
    }
}