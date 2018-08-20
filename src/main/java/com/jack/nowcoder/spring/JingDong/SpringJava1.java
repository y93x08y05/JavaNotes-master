package com.jack.nowcoder.spring.JingDong;

/**从字符串中删减字符，使得剩下的字符串为一个回文串
 * 求可以构成的回文串的个数
 * XXY:四个，删Y，删YX，删XY，删XX
 * ABA：不删，删B，删AB，删BA，删AA
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SpringJava1 {
    //动态规划
    public static long solve1(String s){
        int len = s.length();
        long [][] dp = new long[len+1][len+1];
        for (int i=0;i<=len;i++){
            dp[i][i] = 1;
        }
        for (int i=2;i<=len;i++){
            for (int l=1;l<=len-i+1;l++){
                int r = l + i -1;
                dp[l][r] += dp[l+1][r];
                dp[l][r] += dp[l][r-1];
                if (s.charAt(l-1) == s.charAt(r-1))
                    dp[l][r] +=1;
                else
                    dp[l][r] -= dp[l+1][r-1];
            }
        }
        return dp[1][len];
    }
    //暴力求解
    public static int solve(String s){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        for (int i=1;i<=s.length();i++){
            solution(s,i,result,lists);
        }
        int ans = 0;
        ArrayList<String> arrayList;
        for (int i=0;i<lists.size();i++){
            arrayList = lists.get(i);
            if (is(arrayList,0,arrayList.size()-1))
                ans++;
        }
        return ans;
    }
    public static void solution(String s,int m,ArrayList<String> result,ArrayList<ArrayList<String>> lists){
        if (m == 0){
            lists.add(new ArrayList<>(result));
            return;
        }
        if (s.length() != 0){
            //选择当前元素
            result.add(s.charAt(0) + "");
            solution(s.substring(1,s.length()),m-1,result,lists);
            result.remove(result.size()-1);
            //不选当前元素
            solution(s.substring(1,s.length()),m,result,lists);
        }
    }
    public static boolean is(ArrayList<String> sb ,int left ,int right){
        while (left <= right && sb.get(left).equals(sb.get(right))){
            left++;
            right--;
        }
        if (left > right)
            return true;
        return false;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.print(solve1(string));
    }
}