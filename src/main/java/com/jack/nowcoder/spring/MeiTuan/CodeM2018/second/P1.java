package com.jack.nowcoder.spring.MeiTuan.CodeM2018.second;

import java.util.Scanner;

public class P1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s [][] = {{"@!:","ABC","DEF"},
                {"GHI","JKL","MNO"},
                {"PQRS","TUV","WXYZ"}};
        for (int p=0;p<n;p++) {
            String s1 = sc.next();
            int length = 0;
            int a[][] = new int[s1.length()][2];
            for (int q=0;q<s1.length();q++) {
                for (int i=0;i<s.length;i++) {
                    for (int j=0;j<s.length;j++) {
                        for (int m=0;m<s[i][j].length();m++) {
                            if (s1.charAt(q) == s[i][j].charAt(m)){
                                a[q][0] = i;
                                a[q][1] = j;
                            }
                        }
                    }
                }
            }
            if (a.length > 0) {
                length+=Math.abs(a[0][0]+a[0][1]);
            }
            for (int k=0;k<a.length-1;k++) {
                length+=(Math.abs(a[k+1][0]-a[k][0])+Math.abs(a[k+1][1]-a[k][1]));
            }
            System.out.println(length);
        }
    }
}