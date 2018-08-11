package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 5:04 PM
 * LeetCode 686
 * give two String A and B and find if exist repeated A many times and let A contains B
 * if exist output repeated count else output -1
 */
public class RepeatedStringMatch {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdabcdab";
        System.out.println(findRepeatedStringMatch(s1, s2));
    }
    private static int findRepeatedStringMatch(String A,String B) {
        StringBuilder sb = new StringBuilder();
        int lenA = A.length();
        int lenB = B.length();
        for(int i=0;i<lenB/lenA + 2;i++){
            String str = sb.append(A).toString();
            if(str.indexOf(B) != -1)
                return i+1;
        }
        return -1;
    }
}
