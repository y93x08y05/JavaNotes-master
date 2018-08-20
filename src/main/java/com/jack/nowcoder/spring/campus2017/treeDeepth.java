package com.jack.nowcoder.spring.campus2017;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by zhangta on 3/12/2018.
 * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 * 输入描述
 * 输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
 * 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
 * 输出描述
 * 输出树的高度，为一个整数
 * 输入
 * 5
 * 0 1
 * 0 2
 * 1 3
 * 1 4
 * 输出
 * 3
 */
public class treeDeepth {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = "";
        // 树的深度Map、节点孩子数量Map
        HashMap<Integer, Integer> deep = new HashMap<>();
        HashMap<Integer, Integer> childNum = new HashMap<>();
        deep.put(0, 1);
        childNum.put(0, 0);
        // 默认树的深度为1
        int max = 1;
        int myDeep = 0;
        for (int i = 0; i < n - 1; i++) {
            int parent = scanner.nextInt();
            int num = scanner.nextInt();
            // 不包含父节点或者孩子数目超过两个，则跳过
            if (!deep.containsKey(parent) || childNum.get(parent) >= 2) {
                continue;
            }
            // 树的深度加一
            myDeep = deep.get(parent) + 1;
            // 子节点和树的深度
            deep.put(num, myDeep);
            // 存父节点，其子节点的数量加一
            childNum.put(parent, (childNum.get(parent) + 1));
            // 存子节点，其子节点数量为0
            childNum.put(num, 0);
            if (myDeep > max) {
                max = myDeep;
            }
        }
        System.out.println(max);
    }
}
