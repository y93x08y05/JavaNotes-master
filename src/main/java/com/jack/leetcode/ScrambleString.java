package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/21 10:22
 * LeetCode 87
 * 扰乱字符串
 * 给定一个字符串s1，我们可以把它递归地分割成两个非空子字符串，
 * 从而将其表示成二叉树。
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * 在扰乱这个字符串的过程中，
 * 我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，
 * 将会产生扰乱字符串 "rgeat" 。
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，
 * 将会产生另一个新的扰乱字符串 "rgtae" 。
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * 例1:
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 例2:
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 */
public class ScrambleString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(isScramble(s1, s2));
        System.out.println(isScramble2(s1, s2));
    }

    /**
     * 找到字符串的切割点，通过剪枝来减少数据量。
     * 剪枝的方法就是，如果待比较的字符串时scramble的，则两个字符串中
     * 的字符应该是一样的，如果不一样，则不可能是scramble的。
     * 所以在每层先进行排序，然后比较这个字符串是否是相同的，如果不同则
     * 直接输出return false
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isScramble(String s1, String s2) {
        int len=s1.length();
        if (s1.equals(s2))
            return true;
        char []chars1=s1.toCharArray();
        char []chars2=s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i=0;i<len;i++) {
            if (chars1[i]!=chars2[i])
                return false;
        }
        boolean res=false;
        for (int i=1;i<len;i++) {
            res=res||
                    (isScramble(s1.substring(0,i),s2.substring(0,i))&&
                    isScramble(s1.substring(i),s2.substring(i)))||
                    (isScramble(s1.substring(0,i),s2.substring(len-i))&&
                    isScramble(s1.substring(i),s2.substring(0,len-i)));
        }
        return res;
    }
    private static boolean isScramble2(String s1,String s2) {
        char []v1=s1.toCharArray();
        char []v2=s2.toCharArray();
        return isScramble(v1,0,v1.length-1,v2,0,v2.length-1);
    }
    private static boolean isScramble(char []v1,int start1,int end1,char []v2,int start2,int end2) {
        int []letters=new int[26];
        boolean isSame=true;
        for (int i=start1,j=start2;i<=end1;i++,j++) {
            letters[v1[i]-'a']++;
            letters[v2[j]-'a']--;
            isSame=isSame&&v1[i]==v2[j];
        }
        if (isSame)
            return true;
        for (int i=0;i<26;i++) {
            if (letters[i]!=0)
                return false;
        }
        for (int i=start1,j=start2;i<end1;i++,j++) {
            if (isScramble(v1,start1,i,v2,start2,j)
                    &&isScramble(v1,i+1,end1,v2,j+1,end2))
                return true;
            if (isScramble(v1,start1,i,v2,end2-j+start2,end2)
                    &&isScramble(v1,i+1,end1,v2,start2,end2-j+start2-1))
                return true;
        }
        return false;
    }
}