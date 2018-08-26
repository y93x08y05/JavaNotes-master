package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180825;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jack on 8/24/2018 8:32 PM
 * 双生词是指两个字符串长度相同
 * 将其中一个字符串首位相接成环，再选一个位置切开，顺时针或者逆时针
 * 能够得到另一个字符串
 * 字符串由小写字母表示
 * 输入
 * 3
 * 2
 * helloworld
 * hdlrowolle
 * 2
 * helloworld
 * worldhello
 * 2
 * abcde
 * acbde
 * 输出
 * Yeah
 * Yeah
 * Sad
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i=0;i<n;i++) {
            int m=sc.nextInt();
            ArrayList<String> list=new ArrayList<>();
            for (int j=0;j<m;j++) {
                String s=sc.next();
                StringBuilder sb=new StringBuilder();
                list.add(sb.append(s).append(s).append(s).toString());
            }
            System.out.println(findString(list));
        }
    }
    private static String findString(ArrayList<String> list) {
        for (int i=0;i<list.size()-1;i++) {
            int len=list.get(i).length()/3;
            for (int k=0;k<2*len;k++) {
                String s1=list.get(i).substring(k,k+len);
                String s2=new StringBuilder(list.get(i).substring(k,k+len)).toString();
                for (int j=i+1;j<list.size();j++) {
                    int len1=list.get(j).length()/3;
                    for (int m=0;m<2*len1;m++) {
                        if (list.get(j).substring(m,m+len1).equals(s1)||
                                list.get(j).substring(m,m+len1).equals(s2))
                            return "Yeah";
                    }
                }
            }
        }
        return "Sad";
    }
}
