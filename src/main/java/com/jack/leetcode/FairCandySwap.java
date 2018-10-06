package com.jack.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/10/6 21:21
 * LeetCode 888
 * 公平的糖果交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：
 * A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，
 * 这样交换后，他们都有相同的糖果总量。
 * （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中
 * ans[0] 是爱丽丝必须交换的糖果棒的大小，
 * ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * 例1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 例2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 例3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 例4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 */
public class FairCandySwap {
    public static void main(String[] args) {
        int []A={1,2,5};
        int []B={2,4};
        new FairCandySwap().find(A,B);
    }
    public int [] find(int []A,int []B) {
        int sumA=0;
        int sumB=0;
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<A.length;i++) {
            sumA+=A[i];
            set.add(A[i]);
        }
        for (int i=0;i<B.length;i++) {
            sumB+=B[i];
        }
        for (int i=0;i<B.length;i++) {
            int x=B[i]+(sumA-sumB)/2;
            if (set.contains(x)) {
                return new int[]{x,B[i]};
            }
        }
        return null;
    }
}