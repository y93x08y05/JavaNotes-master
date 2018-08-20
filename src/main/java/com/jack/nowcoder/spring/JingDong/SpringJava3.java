package com.jack.nowcoder.spring.JingDong;

import java.util.Scanner;

/**
 * 对于括号的移动匹配是必须操作一次，只能操作一次
 */
public class SpringJava3 {
    public static String solve(String str){
        int ls = str.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        boolean flag = false;
        for (int i=0;i<ls;i++){
            if (str.charAt(i) == '('){
                left++;
            }else if (str.charAt(i) == ')'){
                right++;
            }
            if (ans == 2 && right - left == 0){
                flag = true;
            }
            if (flag){
                if (right - left > 0){
                    return "No";
                }
            }
            ans = Math.max(ans,right - left);
            if (ans > 2){//每遍历一个字符更新一个ans，ans最大值为3
                return "No";
            }
        }
        if (str.equals(")("))
            return "Yes";
        if (left == right && ans <= 2 && left >= 2){
            return "Yes";
        }
        return "No";
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            String str = sc.next();
            System.out.println(solve(str));
        }
    }
}