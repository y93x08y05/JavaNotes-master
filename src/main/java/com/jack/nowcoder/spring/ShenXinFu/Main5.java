package com.jack.nowcoder.spring.ShenXinFu;

public class Main5 {
    public static void main(String[] args){
        int[] weight = {3,4,6,2,5};
        int[] val = {6,8,7,5,9};
        int max = 10;
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
                System.out.println(f[j]);
                //j-weight[i]即选择当前物品后还能选择的物品总价值
                int temp = f[j-weight[i]]+val[i];
                System.out.println(temp);
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
            }
        }
        System.out.println(f[max]);
    }
}