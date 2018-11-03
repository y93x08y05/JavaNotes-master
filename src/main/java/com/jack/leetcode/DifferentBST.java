package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/5 21:42
 * LeetCode 96
 * 不同的二叉搜索树
 * 给定一个整数n，求以1...n为节点组成的二叉搜索树有多少种？
 * 例：
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class DifferentBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new DifferentBST().find1(n));
        System.out.println(new DifferentBST().find2(n));
        System.out.println(new DifferentBST().find3(n));
    }
    private int find1(int n) {
        if (n == 0 || n == 1)
            return 1;
        int result = 0;
        for (int i = 0; i < n; i++)
            result += find1(i) * find1(n - i - 1);
        return result;
    }
    /*
     * G(n)，长度为n的序列的所有唯一的二叉树
     * F(i,n)，1<=i<=n，以i作为根节点的二叉树的数量
     * G(n)=F(1,n)+F(2,n)+...+F(n,n)
     * G(0)=1，G(1)=1
     * 对于给定的一个序列，取i作为它的根节点，以i作为根节点的二叉树的数量F(i)
     * F(i,n)=G(i-1)*G(n-i)
     * 即G(n)=G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
     */
    private int find2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j < i; j++)
                G[i] += G[j] * G[i - j - 1];
        return G[n];
    }
    /*
     * 卡塔兰数，Catalan
     * 令h(0)=1，h(1)=1
     * h(n)=h(0)*h(n-1)+h(1)*h(n-2)+...+h(n-1)h(0)
     * h(n)=C(2n,n)/(n+1)=P(2n,n)/(n+1)!=(2n)!/(n!*(n+1)!)
     */
    private int find3(int n) {
        long ans = 1;
        for (int i = n + 1; i <= 2 * n; i++)
            ans = ans * i / (i - n);
        return (int) (ans / (n + 1));
    }
}