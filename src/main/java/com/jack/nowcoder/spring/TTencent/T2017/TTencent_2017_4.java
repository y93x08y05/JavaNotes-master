package com.jack.nowcoder.spring.TTencent.T2017;

import java.util.Scanner;

/**
 * Created by zhangta on 1/10/2018.
 * 假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，
 * 如果我们把该编码按字典序排序，形成一个数组如下：
 * a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab,
 * baac … …, yyyw, yyyx, yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。
 * 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
 * 输入一个待编码的字符串,字符串长度小于等于100.
 * 输出这个编码的index
 * 输入
 * baca
 * 输出
 * 16331
 * 给一个例子：
 * dbc
 * 这是一个3位串，算一下有多少种组合能小于它：
 * 1)1位串。(d-a)+1种，第1位可以选[a,d)，再加上d本身。
 * 2)2位串。(d-a)*25+(b-a)+1种，第1位选[a,d)那么第2位可以选25种，
 * 第1位选d那么第2位只能选[a,b)，再加上db本身 。
 * 上面是串长小于3的时候
 * 3)3位串。(d-a)*25^2+(b-a)*25+(c-a)种，计算方法和上述相同。
 * 但是因为串长相同，所以dbc本身不能要，不用+1。
 * 下面是大于串长的情况。
 * 4)4位串。(d-a)*25^3+(b-a)*25^2+(c-a)*25种，
 * 相当于在3位串的基础上乘25 。串的前缀相同，较长的串要排后面，所以不能要。
 * 小于dbc的情况就是上述4种情况之和，对于每个串都计算这4种情况。
 * 观察4个和的规律，可以利用已有结果避免重复计算。
 */
public class TTencent_2017_4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] s = cin.next().toCharArray();
        int n = s.length;
        int sum = 0, curSum = 0;
        for (int i = 0; i < 4; ++i) {
            curSum *= 25;
            if (i < n) {
                //计算每一个字符和a之间的差值代表可选范围
                curSum += s[i] - 'a';
            }
            sum += curSum;
            if (i < n - 1) {
                //即字符串本身不要加1，其他情况字符串加1
                //也就是小于此字符串长度的唯一的个数值
                sum += 1;
            }
        }
        System.out.println(sum);
        cin.close();
    }
}
