package com.jack.nowcoder.spring.A163.A2017;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 现在有n位工程师和6项工作(编号为0至5)，现在给出每个人能够胜任的工作序号表
 * (用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。
 * 现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，
 * 两位工程师不能安排到同一项工作当中去。如果两种工作安排中有一个人被安排
 * 在的工作序号不一样就被视为不同的工作安排，
 * 现在需要计算出有多少种不同工作安排计划
 * 输入描述
 * 输入数据有n+1行： 第一行为工程师人数n(1 ≤ n ≤ 6) 接下来的n行，
 * 每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作(字符串不一定等长的)
 * 输出描述
 * 输出一个整数，表示有多少种不同的工作安排方案
 * 输入例子
 * 6 012345 012345 012345 012345 012345 012345
 * 输出例子
 * 720
 * 利用回溯法进行求解
 * 一个人只能做一项工程，而不能分饰两角
 * 有几个工程师，每个工程师有一个工作即满足题意，不用6项工作全部都要有人做
 * 前一个人选了哪项工作，直接影响后一个人的选择余地
 * 所以需要用一个set记录在当前这个人选择之前，前面那些人已经选了的工作，
 * 进而他只能选除set中已有剩下的工作
 * 当考察完最后一个人，情况数+1（递归出口）
 */
public class A163_2017_6 {
    private static int cases = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] ables = new String[n];
        for(int i = 0; i < n; i++)
            ables[i] = in.next();
        backTracing(ables, 0, new HashSet<Integer>());
        System.out.println(cases);
        in.close();
    }
    public static void backTracing(String[] ables, int index, HashSet<Integer> set){
        if(index >= ables.length){
            cases++;
            return;
        }
        String able = ables[index];
        for(int i = 0; i < able.length(); i++){
            int work = able.charAt(i) - '0';
            if(!set.contains(work)) {
                set.add(work);
                backTracing(ables, index + 1, set);
                set.remove(work);
            }
        }
    }
}