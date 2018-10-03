package com.jack.nowcoder.spring.BBaidu;

import java.util.Scanner;

/**
 * Created by zhangta on 1/8/2018.
 * 最近对全排列特别感兴趣,对于1到n的一个排列,
 * 发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。
 * 但是现在手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),
 * 想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
 * 输入包括一行,包含两个整数n和k(k < n ≤ 1000)
 * 输出满足条件的排列数,答案对2017取模。
 * 输入
 * 5 2
 * 输出
 * 66
 */
public class BaiDu_2017_5 {
    /**
     * 动态规划[i][j]表示有i个数字和j个小于号所能组成的数量，大于号数量为i-j-1次
     * 当加入第i+1个数字时分为四种情况
     * （1）如果i+1插入当前序列开头相当于同时加入一个大于号
     * （2）如果i+1插入当前序列末尾相当于同时加入一个小于号
     * （3）如果i+1插入一个小于号之间相当于同时加入一个大于号
     * （4）如果i+1插入一个大于号之间相当于同时加入一个小于号
     * （1）动态规划[i-1][j]将i加在开头，此时有了j个小于号
     * （2）动态规划[i-1][j-1]将i加在末尾，此时有了j-1个小于号
     * （3）动态规划[i-1][j]*j将j加在任意小于号之间，此时i-1个数有j个小于号
     * （4）动态规划[i-1][j-1]*（i-j-i）将i加在任意一个大于号之间，即i-1个数时有了j-1个小于号
     * 此时有(i-1)-(j-1)-1即i-j-1个大于号
     * 合并同类项即
     * 动态规划[i][j] = (动态规划[i-1][j-1]*(i-j) + 动态规划[i-1][j]*(j+1))%2017;
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] dp = new int[n+1][k+1];
            for(int i=0;i<=n;i++)
                dp[i][0] = 1;
            for(int i=2;i<n+1;i++){
                for(int j=1;j<=k && j<i;j++){
                    if(j==i-1)
                        dp[i][j]=1;
                    else if(j < i-1){
                        dp[i][j] = (dp[i-1][j-1]*(i-j) + dp[i-1][j]*(j+1))%2017;
                    }
                }
            }
            //输出最终dp内所存的元素
            for (int i=0;i<dp.length;i++){
                for (int j=0;j<dp[0].length;j++){
                    System.out.print(dp[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println(dp[n][k]);
        }
    }
}
