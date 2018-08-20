package com.jack.basic.Other2;

/**
 * 有N种物品和容量为V的背包，每种物品都有无限件可用
 * 每种物品有其自身容量和价值
 * 求解将所拥有的物品放入背包，使得总容量不超过背包容量
 * 并且其价值总和是最大的
 */
public class fullBag {
    public static void main(String[] args){
        int[] weight = {10,30,60};
        int[] val = {6,8,7};
        int max = 100;
        int[] f = new int[max+1];
        for(int i=0;i<f.length;i++){
            f[i] = 0;
        }
        for(int i=0;i<val.length;i++){
            /**
             * 单个物品容积小于11，即最大为背包容量
             * 递归去深度添加所能加进来的但是小于总体积的最大价值
             * 数组的每个元素值保存当前体积下所能保存的最大的价值量
             */
            for(int j=weight[i];j<f.length;j++){
                System.out.println(j);
                //j-weight[i]即选择当前物品后还能选择的物品总价值
                int temp = j-weight[i];
                if (temp == 0) {
                    System.out.println(temp);
                    break;
                }
                j = Math.max(j, j-weight[i]);
            }
        }
    }
}