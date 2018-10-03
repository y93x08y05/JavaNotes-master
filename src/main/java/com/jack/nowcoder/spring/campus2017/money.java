package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/16/2018.
 * 给6种面额1、5、10、20、50、100院纸币数量足够多。
 * 编程求组成N元的不同组合个数（N在0-10000的非负整数）
 * 利用现有的多种组合成所需的
 * 输入数字N即需要拼凑的面额，比如5
 * 输出一个数字为组合N的组合个数，比如2
 */
public class money {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine())!=null){
            int n = Integer.parseInt(line.trim());
            int [] moneys = {1,5,10,20,50,100};
            long [] dp = new long[n+1];//动态规划[i]代表拼凑i元的方法数
            dp[0] = 1;
            for(int i=0;i<moneys.length;i++){
                for(int j=1;j<=n;j++){
                    if(j>=moneys[i]){
                        dp[j]+=dp[j-moneys[i]];
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}
