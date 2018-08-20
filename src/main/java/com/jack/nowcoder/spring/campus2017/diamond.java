package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/12/2018.
 * 有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
 * 有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，
 * 蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，
 * 这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。如果无法找到则一个也无法带走。
 * 请帮助学者找出如何切分项链才能够拿到最多的宝石。
 * 输入描述
 * 我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，
 * F代表玉石，G代表玻璃等等，我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。
 * 每行代表一种情况。
 * 输出描述
 * 输出学者能够拿到的最多的宝石数量。每行一个
 * 输入
 * ABCYDYE
 * ATTMBQECPD
 * 输出
 * 1
 * 3
 */
public class diamond {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        while((line = br.readLine()) != null){
            int n = line.length();
            char[] loop = new char[2*n];
            String s = line;
            for(int i=0;i<2*n;i++){
                loop[i] = s.charAt(i%n);
            }
            int takeMax = 0;
            int[] a = {-1,-1,-1,-1,-1};
            for(int i=0;i<2*n;i++){
                if(loop[i]<='E'&&loop[i]>='A'){
                    a[loop[i]-'A'] = i;
                    if(judge(a)){
                        takeMax = Math.max(takeMax, n-stay(a));
                    }
                }
            }
            System.out.println(takeMax);
        }
    }
    private static boolean judge(int[] a) {
        for(int i=0;i<a.length;i++){
            if(a[i] < 0){
                return false;
            }
        }
        return true;
    }
    private static int stay(int[] a){
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            max = Math.max(max,a[i]);
            min = Math.min(min,a[i]);
        }
        return (max-min)+1;
    }
}
