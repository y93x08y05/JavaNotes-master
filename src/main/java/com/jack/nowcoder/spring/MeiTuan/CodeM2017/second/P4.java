package com.jack.nowcoder.spring.MeiTuan.CodeM2017.second;

import java.util.*;

/**
 * n个小区排成一列，编号为0到n-1，开始美团外卖员在0号小区，目标为位于
 * 第n-1个小区的配送站。给定两个整数数列a[0]到a[n-1]和b[0]到b[n-1]，在每个
 * 小区i里有两种选择：
 * （1）选择a，向前a[i]个小区
 * （2）选择b，向前b[i]个小区
 * 把每步的选择写成关于字符a,b的字符串，求达到第n-1个小区的方案，字典序最小的
 * 字符串。如果做出某个选择，跳出了n个小区的范围，则选择不合法。
 * （1）当没有合法的选择序列时，输出“no solution”
 * （2）当字典序最小的字符串无限长时，输出“infinity!”
 * （3）否则，输出这个选择字符串。
 * 字典序定义：串s和串t，如果s字典序比串t小，则存在整数i>=-1，
 * 使得任意j,0<=j<=i，满足s[j]=t[j]且s[j+1]<t[j+1]。
 * 其中，空字符<'a'<'b'。
 * 输入描述：
 * 输入三行
 * 第一行输入一个整数n(1<=n<=10^5)
 * 第二行输入n个整数，分别表示a[i]
 * 第三行输入n个整数，分别表示b[i]
 * -n<=a[i],b[i]<=n
 * 输出描述：
 * 输出一行字符串表示答案
 * 输入：
 * 7
 * 5 -3 6 5 -5 -1 6
 * -6 1 4 -2 0 -2 0
 * 输出
 * abbbb
 */
public class P4 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];
        for (int i=0;i<n;i++) {
            a[i] = scanner.nextInt();
            //向前a[i]个小区，即从当前位置i加上a[i]
            if (i+a[i]<0 || i+a[i]>n-1) {
                a[i] = 0;
            }
        }
        for (int i=0;i<n;i++) {
            b[i] = scanner.nextInt();
            //向前b[i]个小区，即从当前位置i加上b[i]
            if (i+b[i]<0 || i+b[i]>n-1) {
                b[i] = 0;
            }
        }
        System.out.println(findPath(n, a, b));
    }
    public static String findPath(int n, int []a, int []b) {
        HashMap<Integer,ArrayList<Integer>> trace = new HashMap<Integer,ArrayList<Integer>>();
        for (int i=0;i<n;i++) {
            trace.put(i,new ArrayList<Integer>());
        }
        boolean []visit = new boolean[n];
        for (int i=0;i<n;i++) {
            if (a[i] != 0) {//说明从当前i加上a[i]在范围内
                trace.get(a[i]+i).add(i);
            }
            if (b[i] != 0) {//说明从当前i加上a[i]在范围内
                trace.get(b[i]+i).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(n-1);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (!visit[index]) {
                visit[index] = true;
                for (Integer j : trace.get(index)) {//遍历每一个索引值
                    queue.offer(j);
                }
//                trace.get(index).forEach(queue::offer);
            }
        }
        if (!visit[0]) {
            return "No solution!";
        }
        String s = "";
        int k = 0;
        boolean []visit2 = new boolean[n];
        while (true) {
            if (k == n-1) {
                return s;
            }
            visit2[k] = true;
            if (a[k] != 0 && visit[a[k]+k]) {
                if (visit2[a[k]+k]) {
                    return "Infinity!";
                }
                s += "a";
                k += a[k];
            } else if (b[k] != 0 && visit[b[k]+k]) {
                if (visit2[b[k]+k]) {
                    return "Infinity!";
                }
                s += "b";
                k += b[k];
            } else {
                return "No solution!";
            }
        }
    }
}