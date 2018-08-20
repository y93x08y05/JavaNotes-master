package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/12/2018.
 */
public class sentenceReverse {
    public static void main(String [] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[0];
        try {
            str = br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            sb.append(str[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
