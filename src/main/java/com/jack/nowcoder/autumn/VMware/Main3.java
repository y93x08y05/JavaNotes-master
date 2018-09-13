package com.jack.nowcoder.autumn.VMware;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/13 19:51
 * 小明要搬家，他家里面有许多物品要搬，所以令他非常苦恼。
 * 不过他可以叫工人来帮他搬家，每一个工人可以搬走一些物品，
 * 但是要求物品的重量之和不超过W才行。
 * 现在问题来了，小明最少要叫多少个工人，才能搬走所有物品呢？
 * 输入
 * 第一行两个整数，N,W，分别表示物品数量和工人最大搬运重量和。
 * 第二行到第n+1行，每行各一个整数C[i]，表示第i个物品的重量。
 * 满足1<=N<=18，1<=C[i]<=W<=100000000
 * 输出
 * 输出最少工人数量。
 * 样例输入
 * 3 5
 * 3
 * 2
 * 4
 * 样例输出
 * 2
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int W=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<N;i++)
            list.add(sc.nextInt());
        System.out.println(find(list, W));
    }
    private static int find(List<Integer> list,int W) {
        Collections.sort(list);
        int i=0;
        int j=list.size()-1;
        int count=0;
        while(i<j){
            if(list.get(i)+list.get(j)>W){
                count++;
                j--;
            }
            if(list.get(i)+list.get(j)<=W){
                count++;
                j--;
                i++;
            }
        }
        if(i==j)
            count++;
        return count;
    }
}