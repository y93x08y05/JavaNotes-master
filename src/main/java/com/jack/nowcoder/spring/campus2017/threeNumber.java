package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by zhangta on 3/16/2018.
 * 现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，
 * 同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，
 * 并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。
 * 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2
 * 输入描述
 * 输入数据为一行，包含9997个数字，空格隔开
 * 输出为一行，包含一个数字
 * 如丢失元素为336,10,8435，得到新数组为103368435，除以七的余数为2
 */
public class threeNumber {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = br.readLine()) != null){
            boolean[] flag = new boolean[10000];
            String[] s = line.trim().split(" ");
            int x;
            for(int i=0;i<s.length;i++){
                x = Integer.parseInt(s[i]);
                flag[x-1] = true;
            }
            int index = 0;
            int[] res = new int[3];
            for(int i=0;i<flag.length;i++){
                if(!flag[i]){
                    res[index++] = i+1;
                    if(index == 3){
                        break;
                    }
                }
            }
            StringBuffer sb = new StringBuffer();
            Arrays.sort(res);
            sb.append(res[0]);
            sb.append(res[1]);
            sb.append(res[2]);
            long k = Long.parseLong(sb.toString());
            System.out.println(k%7);
        }
    }
}
