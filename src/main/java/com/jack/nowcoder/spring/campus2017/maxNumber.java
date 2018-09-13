package com.jack.nowcoder.spring.campus2017;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhangta on 3/12/2018.
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
 * 输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。
 * 第二行是希望去掉的数字数量cnt 1 ≤ count < length(number)。
 * 输出保留下来的结果。
 * 输入
 * 325 1
 * 输出
 * 35
 */
public class maxNumber {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);

        String s = in.nextLine();
        char[] nums=s.toCharArray();
        int account=Integer.parseInt(in.nextLine());
        if (account == 0) {
            System.out.println(s);
            return;
        }
        Stack<Character> stack=new Stack<>();
        stack.push(nums[0]);
        int i=1;
        while(account>0&&i<nums.length){
            while(!stack.isEmpty()&&account>0&&nums[i]>stack.peek()){
                stack.pop();
                account--;
            }
            stack.push(nums[i]);
            i++;
        }

        while(account>0){
            stack.pop();
            account--;
        }
        StringBuilder sb = new StringBuilder(stack.size() + nums.length - i);
        /**
        for (char c : stack) {
            sb.append(c);
        }
         */
        stack.forEach(sb::append);
        for (int j = i; j < nums.length; j++) {
            sb.append(nums[j]);
        }
        System.out.println(sb);
    }
}
