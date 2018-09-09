package com.jack.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Jack on 8/15/2018 2:18 PM
 * LeetCode 32
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 例1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 例2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(findLongestValidParentheses1(s));
        System.out.println(findLongestValidParentheses2(s));
        System.out.println(findLongestValidParentheses3(s));
        System.out.println(findLongestValidParentheses4(s));
    }

    /**
     * use stack to do
     * @param s
     * @return
     */
    private static int findLongestValidParentheses1(String s) {
        Stack<Parentheses> parenthesesStack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char symbol = s.charAt(i);
            if (symbol==')') {
                if (!parenthesesStack.isEmpty()&&parenthesesStack.peek().symbol=='(') {
                    parenthesesStack.pop();
                    continue;
                }
            }
            parenthesesStack.push(new Parentheses(symbol,i));
        }
        int maxLength = 0;
        int nextIndex = s.length();
        while (!parenthesesStack.isEmpty()) {
            int currentIndex = parenthesesStack.pop().index;
            maxLength = (nextIndex-currentIndex-1)>maxLength?nextIndex-currentIndex-1:maxLength;
            nextIndex = currentIndex;
        }
        return Math.max(nextIndex,maxLength);
    }

    /**
     * use stack to do and optimize
     * @param s
     * @return
     */
    private static int findLongestValidParentheses2(String s) {
        Stack<Integer> parenthesesStack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char symbol = s.charAt(i);
            if (symbol==')') {
                if (!parenthesesStack.isEmpty()&&s.charAt(parenthesesStack.peek())=='(') {
                    parenthesesStack.pop();
                    continue;
                }
            }
            parenthesesStack.push(i);
        }
        int maxLength = 0;
        int nextIndex = s.length();
        while (!parenthesesStack.isEmpty()) {
            int currentIndex = parenthesesStack.pop();
            int currentLength = nextIndex-currentIndex-1;
            maxLength = currentLength>maxLength?currentLength:maxLength;
            nextIndex = currentIndex;
        }
        return Math.max(nextIndex,maxLength);
    }

    /**
     * use dynamic programming to do
     * @param s
     * @return
     */
    private static int findLongestValidParentheses3(String s) {
        int [] maxCount = new int[s.length()];
        int maxLength = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i)==')') {
                if (s.charAt(i-1)=='(') {
                    maxCount[i] = (i>=2?maxCount[i-2]+2:2);
                    maxLength = Math.max(maxCount[i],maxLength);
                } else {
                    if (i-maxCount[i-1]-1>=0&&s.charAt(i-maxCount[i-1]-1)=='(') {
                        maxCount[i] = maxCount[i-1]+2+((i-maxCount[i-1]-2>=0)?maxCount[i-maxCount[i-1]-2]:0);
                        maxLength = Math.max(maxCount[i],maxLength);
                    }
                }
            }
        }
        return maxLength;
    }

    /**
     * use dynamic programming to do
     * @param s
     * @return
     */
    private static int findLongestValidParentheses4(String s) {
        int [] maxCount = new int[s.length()];
        int maxLength = 0;
        for(int i = 1 ; i<s.length() ; i++){
            if(s.charAt(i) == ')' && i-maxCount[i-1]-1>=0 && s.charAt(i-maxCount[i-1]-1)=='('){
                maxCount[i] = maxCount[i-1] + 2 + ((i-maxCount[i-1]-2>=0) ? maxCount[i-maxCount[i-1]-2] : 0);
                maxLength = Math.max(maxCount[i], maxLength);
            }
        }
        return maxLength;
    }
    public static class Parentheses {
        public static char symbol;
        public static int index;
        public Parentheses(char symbol, int index) {
            this.symbol = symbol;
            this.index = index;
        }
    }
}
