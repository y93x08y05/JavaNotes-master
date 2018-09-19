package com.jack.nowcoder.autumn.didi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/18 20:07
 * 题目描述：
 * 英文单词拼写的时候可能会出现拼写错误的情况(typo)。
 * 下面的题目，我们尝试实现拼写纠错推荐的功能。
 * 字串编辑距离是衡量字串间相似度的常见手段。
 * ①字串编辑距离：是指利用字符操作，
 * 把字符串A转换成字符串B所需要的最少操作数。
 * ②字串操作包括：删除字符(removal)、插入字符(insertion)、
 * 修改字符(substitution)。
 * ③使用以下规则对推荐纠错选项进行相似度排序。
 * 得分越高，认为相似度越低
 * 只涉及到26个英文字符、不区分大小写。
 * 删除(removal)  3分
 * 插入(insertion) 3分
 * 修改(substitution) ：
 *     (q w e r t a s d f g z x c v ) （y u i o p h j k l b n m）
 *     以上两个分组内的字符修改1分，两个分组间字符修改 2分。
 * 输入
 * ·每行一个输入。空格分割参数。
 * ·第一个参数是目标单词(可能存在typo)
 * ·后面若干空格分割参数(个数不定)是字典单词，
 * 作为候选纠错项(也可能和第一个参数重复)。
 * 输出
 * ·按照上面的纠错规则字串相似度最小编辑距离进行排序，
 * 给出3个(如有)对应的纠错候选。
 * ·如得分相同，则按照输入顺序进行排序。
 * 样例输入
 * slep slap sleep step shoe shop snap slep
 * 样例输出
 * slep slap step
 * slep slap sleep step shoe shop snap slep
 */
public class Main1 {
    static class Pair implements Comparable<Pair>{
        int val;
        String s;
        Pair(int val,String s) {
            this.val=val;
            this.s=s;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.val==this.val)
                return o.s.compareTo(this.s);
            return o.val-this.val;
        }
    }
    public static String regex1="qwertasdfgzxcv";
    public static String regex2="yuiophjklbnm";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(" ");
        List<Pair> list=new ArrayList<>();
        String s1=str[0];
        for (int i=1;i<str.length;i++) {
            int a=findBianJiJuLi(s1,str[i]);
            list.add(new Pair(a,str[i]));
        }
        Collections.sort(list);
        if (list.size()<=3) {
            for (int i=0;i<list.size();i++) {
                System.out.print(list.get(i).s+" ");
            }
        } else {
            for (int i=0;i<3;i++) {
                System.out.print(list.get(i).s+" ");
            }
        }
    }
    private static int findBianJiJuLi(String s1,String s2) {
        int count=0;
        int delete=3;
        int insert=3;
        int change1=2;
        int change2=1;
        if (s1.length()<s2.length()) {
            count+=delete*(s2.length()-s1.length());
        } else if (s1.length()>s2.length()) {
            count+=insert*(s2.length()-s1.length());
        }
        int temp=0;
        for (int i=0;i<s1.length();i++) {
            for (int j=i;j<s2.length();j++) {
                if (s1.charAt(i)!=s2.charAt(j)) {
                    if (regex1.contains(String.valueOf(s1.charAt(i)))&&
                            regex1.contains(String.valueOf(s2.charAt(i)))) {
                        temp+=change2;
                    } else if (regex2.contains(String.valueOf(s1.charAt(i)))&&
                            regex2.contains(String.valueOf(s2.charAt(i)))) {
                        temp+=change2;
                    } else {
                        temp+=change1;
                    }
                }
            }
        }
        return temp+count;
    }
}