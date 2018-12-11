package com.jack.nowcoder.spring.A163.A2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangta on 1/6/2018.
 *一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 给定一个字符串,计算字符串的所有碎片平均长度。
 * 输出整数，表示所有碎片平均长度，保留两位小数
 * 如输入“aaabbaaac”，则所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 */
public class A163_2018_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.printf("%.2f\n", getAveLen(line));
    }
    private static float getAveLen(String s) {
        ArrayList<String> list = new ArrayList<>();
        Pattern p = Pattern.compile("([a-z])\\1*");
        Matcher m = p.matcher(s);
        while (m.find()) {
            list.add(m.group());
        }
        float sumLen = 0;
        for (String str : list) {
            sumLen += str.length();
        }
        return sumLen / list.size();
    }
}
