package com.jack.nowcoder.spring.campus2017;

import java.util.Scanner;

/**
 * Created by zhangta on 3/16/2018.
 * 输入数据为一个文件路径，输出对应的文件扩展名
 * 输入：Abc/file.txt
 * 输出：txt
 */
public class filename {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            int temp;
            for(int i=s1.length()-1;i>=0;i--){
                if(s1.charAt(i) == '.'){
                    temp = i;
                    System.out.println(s1.substring(temp+1));
                    return;
                }
            }
            System.out.println("null");
        }
    }
}
