package com.jack.leetcode;

import java.util.Arrays;

/**
 * @Author: Jack
 * @Date: 2018/9/8 0:34
 * LeetCode 621
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。
 * 其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，
 * 并且每个任务都可以在 1 个单位时间内执行完。
 * CPU 在任何一个单位时间内都可以执行一个任务，
 * 或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，
 * 因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，
 * 或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 * 例1：
 * 输入:tasks=["A","A","A","B","B","B"], n=2
 * 输出: 8
 * 执行顺序: A->B->(待命)->A->B->(待命)->A->B.
 * 贪心算法：角度选择很重要。这里采取了分块的形式，
 * 按照出现频率最多（假设频率为k）的将其分为了k块，
 * 然后每一轮向这k个区间个插入1个。如何选择贪心策略？
 * （1）数学公式表达：通过数学公式明确考虑问题的角度，
 * 清晰表达解答问题的思路，
 * （2）明确其中涉及的变量以及变量函数间的关系。
 * （3）证明贪心有效性：如何证明一个贪心策略是能够解决一个问题的？
 */
public class TaskScheduler {
    public static void main(String[] args) {
        char []tasks={'A','A','A','B','B','B'};
        int n=2;
        System.out.println(leastInterval(tasks, n));
    }
    private static int leastInterval(char []tasks,int n) {
        int []c=new int[26];
        for (char t:tasks)
            c[t-'A']++;
        Arrays.sort(c);
        int i=25;
        while (i>=0&&c[i]==c[25])
            i--;
        return Math.max(tasks.length,(c[25]-1)*(n+1)+25-i);
    }
}