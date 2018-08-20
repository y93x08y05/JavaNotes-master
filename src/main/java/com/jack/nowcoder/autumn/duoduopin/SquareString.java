package com.jack.nowcoder.autumn.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/5/2018 9:39 PM
 */
public class SquareString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        if (len == 0 || len % 4 != 4) {
            return;
        } else {
            int m = len / 4;
            String [][] strings = new String[m+1][m+1];
            int i=0;
            int j=0;
            int temp = 0;
            while (i < m)
                strings[0][i++] = String.valueOf(s.charAt(temp++));
            while (j < m)
                strings[j++][m] = String.valueOf(s.charAt(temp++));
            while (j < m)
                strings[m][j--] = String.valueOf(s.charAt(temp++));
            while (i < m)
                strings[i--][0] = String.valueOf(s.charAt(temp++));
            for (int k=0;k<strings.length;k++) {
                for (int w=0;w<strings[0].length;w++) {
                    if (strings[0][0] == null)
                        System.out.print(" ");
                    else
                        System.out.print(strings[k][w]);
                }
                System.out.println();
            }
        }
    }
}
