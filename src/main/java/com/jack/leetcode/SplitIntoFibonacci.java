package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 10:15
 * LeetCode 842
 * 给定一个数字字符串 S，比如 S = "123456579"，
 * 我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0<=F[i]<=2^31 - 1，（也就是说，每个整数都符合32位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0<=i<F.length-2，都有F[i]+F[i+1]=F[i+2]成立。
 * 将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字0本身。
 * 返回从 S 拆分出来的所有斐波那契式的序列块，如果不能拆分则返回 []。
 * 例1：
 * 输入："123456579"
 * 输出：[123,456,579]
 * 例2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 例3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 例4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 例5：
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 */
public class SplitIntoFibonacci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(splitFibonacci(s));
    }
    private static List<Integer> splitFibonacci(String s) {
        int n=s.length();
        for (int i=1;i<n;i++) {
            String s1=s.substring(0,i);
            Long a=Long.valueOf(s1);
            if (a>Integer.MAX_VALUE)
                break;
            for (int j=1;j+i+1<n;j++) {
                String s2=s.substring(i,i+j);
                Long b=Long.valueOf(s2);
                if (b>Integer.MAX_VALUE)
                    break;
                if ((a==0&&s1.length()>1)||(b==0&&s2.length()>1))
                    continue;
                List<Integer> res=find(a.intValue(),b.intValue(),s.substring(i+j));
                if (res!=null&&res.size()>=3)
                    return res;
            }
        }
        return new ArrayList<>();
    }
    private static List<Integer> find(int a,int b,String s) {
        List<Integer> res=new ArrayList<>();
        res.add(a);
        res.add(b);
        long c=a+b;
        if (c>Integer.MAX_VALUE)
            return new ArrayList<>();
        int cnt;
        while (s.length()>0) {
            c=a+b;
            if (c<0) {
                return new ArrayList<>();
            }
            cnt=Integer.toString((int) c).length();
            if (s.startsWith(Integer.toString((int) c))) {
                res.add((int) c);
                s=s.substring(cnt);
            } else {
                return new ArrayList<>();
            }
            a=b;
            b= (int) c;
        }
        return res;
    }
}