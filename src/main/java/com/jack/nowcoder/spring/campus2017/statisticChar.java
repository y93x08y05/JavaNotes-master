package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/12/2018.
 * 给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
 * 输入数据一个字符串，包括字母,数字等
 * 输出首先出现三次的那个英文字符
 * 输入
 * Have you ever gone shopping and
 * 输出
 * e
 */
public class statisticChar {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int[] ch = new int[128];
            char[] arr = str.toCharArray();
            for(int i = 0;i<arr.length;i++){
                char c = arr[i];
                if((c>='A'&&c<='Z')||(c>='a'&&c<='z')){
                    ch[c]++;
                    if(ch[c]==3){
                        System.out.println(c);
                        break;
                    }
                }
            }
        }
        br.close();
    }
}
