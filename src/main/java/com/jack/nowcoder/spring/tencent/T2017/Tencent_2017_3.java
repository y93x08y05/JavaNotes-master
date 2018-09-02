package com.jack.nowcoder.spring.tencent.T2017;

import java.util.*;

/**
 * Created by zhangta on 1/10/2018.
 * 有n个数，两两组成二元组，求差最小的对数以及差最大的对数
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * N - 本组测试数据有n个数
 * a1,a2...an - 需要计算的数据
 *保证:1<=N<=100000,0<=ai<=INT_MAX.
 * 每组数据，输出第一个数表示差最小的对数，第二个数表示差最大的对数。
 * 输入
 * 6
 * 45 12 45 32 5 6
 * 输出
 * 1 2
 *
     1.先排序
          特殊情况：如果排完序之后发现数组中所有数都相同，直接输出结果
                           即等差数列求和，差值为1
              结果为：差最大个数 = 差最小个数 = （n * (n-1))/2;(两两组合)
     2.统计数组中每种数字的个数（这里用的map）
     3.计算差最小个数
         3.1.如果数组中没有重复数字，说明最小差不为0，最小差肯定是数组中相邻两个数的差
             遍历一遍数组，计算并统计最小差。
         3.2.如果数组中有重复数字，说明最小差是0，遍历一遍map，数字个数不为0的
             数字会产生最小差0。
     4.计算差最大个数
         只有一种情况，最大值与最小值的两两组合，即最大值个数 * 最小值个数
     算法复杂度：排序O(nlogn), 统计O(n)
 */
public class Tencent_2017_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            //如果数组中的值全相同，直接两两组合
            if(a[0] == a[n-1]){
                int tmp = (n*(n-1))/2;
                System.out.println(tmp + " " + tmp);
                continue;
            }
            //map用来统计每种数的个数
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for(int i=0;i<n;i++){
                if(map.containsKey(a[i]))
                    map.put(a[i], map.get(a[i])+1);
                else
                    map.put(a[i], 1);
            }
            //求差最小个数
            int minres = 0;
            if(map.size() == n){
                //即没有重复的数字
                int min = Math.abs(a[1]-a[0]);
                for(int i=2;i<n;i++){
                    //排序之后相邻两个数进行绝对值
                    int tmp = Math.abs(a[i]-a[i-1]);
                    if(tmp == min)
                        minres++;
                    else if(tmp < min){
                        //一旦发现了更小的数，则把之前统计的最小数的个数置为1
                        //并重新定义最小值
                        min = tmp;
                        minres = 1;
                    }
                }
            }else{
                //即有重复的数字
                for(Integer key : map.keySet()){
                    int val = map.get(key);
                    if(val > 1){
                        //即同一个数重复的次数，可能重复多次
                        minres += (val * (val-1))/2;
                    }
                }
            }
            //求差最大个数
            int maxres = 0;
            List<Integer> keyset = new ArrayList<Integer>(map.keySet());
            //最小值个数与最大值个数组合，即存在多个相同的最小值和最大值
            //如果存在唯一的最小值和最大值，即最后结果为1乘以1即存在唯一最大值
            int val1 = map.get(keyset.get(0));
            int val2 = map.get(keyset.get(keyset.size()-1));
            maxres = val1 * val2;
            System.out.println(minres + " " + maxres);
        }
    }
}
