package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/7 22:23
 * LeetCode 307
 * 给定一个整数数组num，
 * 求出数组从索引i到j(i ≤ j) 范围内元素的总和，
 * 包含 i,  j 两点。
 * update(i, val) 函数可以通过将下标为i的数值更新为val，
 * 从而对数列进行修改。
 */
public class NumberArray2 {
    int[] processed;
    int[] num;
    int length;
    public NumberArray2(int[] num) {
        length = num.length;
        processed = new int[length+1];
        this.num = num;
        for(int i = 1;i<=length;i++){
            int sum = 0;
            int count = 1;
            int counter = lowBit(i);

            while(count <= counter){
                sum += num[i-count];
                count++;
            }
            processed[i] = sum;
        }
    }

    void update(int i, int val) {
        int gap = val - num[i];
        num[i] = val;

        int index = i+1;
        while(index <= length){
            processed[index] += gap;
            index += lowBit(index);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j+1) - sum(i);
    }

    private int sum(int index){
        int sum = 0;
        while(index > 0){
            sum += processed[index];
            index -= lowBit(index);
        }
        return sum;
    }
    private int lowBit(int index){
        return index & (-index);
    }
    public static void main(String[] args) {

    }
}