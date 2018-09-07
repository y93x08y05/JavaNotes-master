package com.jack.nowcoder.autumn.MEITUAN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 18:40
 * 给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，
 * 每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，
 * 那么总路程至少是多少？
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 * 接下来N-1行，每行包含两个整数X和Y，表示X号节点和Y号节点之间有一条边，
 * 1≤X，Y≤N。
 * 输出
 * 输出总路程的最小值。
 * 样例输入
 * 4
 * 1 2
 * 1 3
 * 3 4
 * 样例输出
 * 4
 * Hint
 * 按1->2->1->3->4的路线遍历所有节点，总路程为4。
 * 走完所有节点类似于深度优先搜索，也就是说除了最后一条路径外，
 * 别的路径都经历了正着走，再返回的过程，也就是两遍
 * 设最后一条路径为x，总分支数为n-1，总路径=2*(n-1-x)+x=2*n-2-x，当x最大时
 * 总路径最小，所以转化为求多叉树的深度。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<2*(n-1);i++) {
            list.add(sc.nextInt());
        }
        for (int i=0;i<list.size()-1;i++) {
            if (list.get(i+1)==list.get(i)) {
                list.remove(i);
            }
        }
        System.out.println(list.size()-1);
    }
}