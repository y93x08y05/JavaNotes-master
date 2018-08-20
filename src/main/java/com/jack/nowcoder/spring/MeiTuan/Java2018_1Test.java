package com.jack.nowcoder.spring.MeiTuan;

/**
 * 输入两个字符串，长度分别为S和L
 * 其中第一个字符串的长度大于等于第二个字符串的长度
 * 第一个字符串包含S-L+1个与第二个字符串长度一样的子串
 * 比较这样的子串与第二个字符串
 * 比如abc与abd，则其不同字符的总长度为1
 * 即比较字符串的每个对应位置字符，不同则加1
 * 输入最终的第一个字符串的所有子串与第二个字符串的这样长度之和
 */

import java.util.Scanner;

public class Java2018_1Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int m = s.length();
        int n = t.length();
        int res = 0;
        int d = m - n;
        for(int i = 0;i < n;i++) {
            for(int j = i; j <= i+d;j++) {//取到多个字符串1的子串与字符串2长度一样，进行比较每一个字符
                if(t.charAt(i) !=s.charAt(j)) {//判断字符串对应位置字符是否一致，不一致则加1
                    res+= (comb(j,i)*comb(m - j - 1,n - i - 1));
                }
            }
        }
        System.out.println(res);
    }
    public static int comb(int m,int n) {
        if(m == 0 || m == n)
            return 1;
        long res = 1;
        for(int i = 0,x = m;i < n;i++,x--) {
            res = res * x;
        }
        for(int i = 0 ; i < n;i++) {
            res = res/(i+1);
        }
        return (int)res;
    }
}