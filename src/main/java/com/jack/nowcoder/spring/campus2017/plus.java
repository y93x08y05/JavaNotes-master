package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/16/2018.
 * 设计算法能够完成两个用字符串存储的整数相加操作，非法输入返回error
 * 输入一行，包含两个字符串，字符串长度在[1,100]
 * 输出为一行，合法情况输出相加结果，非法情况，输出error
 * 输入 123 123
 * abc 123
 * 输出 246
 * Error
 */
public class plus {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        String s1 = str.split(" ")[0];
        String s2 = str.split(" ")[1];
        int i = s1.length()-1;
        int j = s2.length()-1;
        StringBuilder sb = new StringBuilder();
        int cb = 0;
        while(i>=0&&j>=0){
            if(s1.charAt(i)>'9'||s1.charAt(i)<'0'||s2.charAt(i)>'9'||s2.charAt(i)<'0'){
                System.out.println("error");
                return;
            }
            int temp = ((s1.charAt(i)-'0')+(s2.charAt(j)-'0')+cb)%10;
            sb.append(temp);
            cb = ((s1.charAt(i)-'0')+(s2.charAt(j)-'0')+cb)>=10?1:0;
            i--;
            j--;
        }
        while (i>=0){
            if(s1.charAt(i)>'9'||s1.charAt(i)<'0'){
                System.out.println("error");
                return;
            }
            sb.append((cb+(s1.charAt(i)-'0'))%10);
            cb = (cb+(s1.charAt(i)-'0'))%10;
            i--;
        }
        while (j>=0){
            if(s2.charAt(j)>'9'||s2.charAt(j)<'0'){
                System.out.println("error");
                return;
            }
            sb.append((cb+(s2.charAt(j)-'0'))%10);
            cb = (cb+(s2.charAt(j)-'0'))%10;
            j--;
        }
        if(cb!=0)
            sb.append(cb);
        sb.reverse();
        System.out.println(sb.toString());
    }
}
