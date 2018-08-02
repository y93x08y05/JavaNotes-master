package com.jack.thoughtsWorks;

import java.util.Scanner;

/**
 * Created by Jack on 7/28/2018 3:02 PM
 * Road Grid could generate a 7x7 Render Grid and use special input to produce Road Grid
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(getResult(s1, s2));
    }
    public static String getResult(String s1,String s2) {
        StringBuilder sb = new StringBuilder();
        String [] arr1 = s1.split(" ");
        if (arr1.length != 2) {
            return "Incorrect command format";
        } else if (!(isDigitOrNot(arr1[0].charAt(0)) && isDigitOrNot(arr1[1].charAt(0)))) {
            return "Invalid number format";
        }
        int m = Integer.parseInt(arr1[0]);
        int n = Integer.parseInt(arr1[1]);
        if (!judgeLine2(s2)) {
            return "Incorrect command format";
        }
        String [] arr2 = s2.split(";");
        int x = 3+2*(m-1);
        int y = 3+2*(n-1);
        boolean [][] arr3 = new boolean[x][y];
        String [] arr4;
        for (int i=0;i<arr2.length;i++) {
            arr4 = arr2[i].split(" ");
            for (int p = 0;p<arr4.length;p++) {
                if (!isDigitOrNot(arr4[p].charAt(0))) {
                    return "Invalid number format" ;
                } else if (!isDigitOrNot(arr4[p].charAt(2))) {
                    return "Invalid number format" ;
                } else if (Integer.parseInt(String.valueOf(arr4[p].charAt(0))) < 0
                        || Integer.parseInt(String.valueOf(arr4[p].charAt(0))) > m-1
                        || Integer.parseInt(String.valueOf(arr4[p].charAt(2))) < 0
                        || Integer.parseInt(String.valueOf(arr4[p].charAt(2))) > n-1
                        ) {
                    return "Number out of range";
                }
            }
            if (arr4[0].charAt(0) != arr4[1].charAt(0) && arr4[0].charAt(2) == arr4[1].charAt(2)) {
                int a = Integer.parseInt(String.valueOf(arr4[0].charAt(0)));
                int b = Integer.parseInt(String.valueOf(arr4[1].charAt(0)));
                int c = 2*a+1;
                int d = 2*b+1;
                if (a < b) {
                    for (int j=c;j<=d;j++) {
                        arr3[j][2*Integer.parseInt(String.valueOf(arr4[0].charAt(2)))+1] = true;
                    }
                } else if (a > b){
                    for (int j=d;j<=c;j++) {
                        arr3[j][2*Integer.parseInt(String.valueOf(arr4[0].charAt(2)))+1] = true;
                    }
                }
            } else if (arr4[0].charAt(0) == arr4[1].charAt(0) && arr4[0].charAt(2) != arr4[1].charAt(2)){
                int a = Integer.parseInt(String.valueOf(arr4[0].charAt(2)));
                int b = Integer.parseInt(String.valueOf(arr4[1].charAt(2)));
                int c = 2*a+1;
                int d = 2*b+1;
                if (a < b) {
                    for (int j=c;j<=d;j++) {
                        arr3[2*Integer.parseInt(String.valueOf(arr4[0].charAt(0)))+1][j] = true;
                    }
                } else if (a > b){
                    for (int j=d;j<=c;j++) {
                        arr3[2*Integer.parseInt(String.valueOf(arr4[0].charAt(0)))+1][j] = true;
                    }
                }
            } else {
                return "Maze format error" ;
            }
        }
        for (int i=0;i<arr3.length;i++) {
            for (int j=0;j<arr3[0].length;j++) {
                if (arr3[i][j] == true) {
                    sb.append("[R]" + " ");
                } else {
                    sb.append("[W]" + " ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static boolean isDigitOrNot(char c) {
        if (!Character.isDigit(c)) {
            return false;
        }
        return true;
    }
    public static boolean judgeLine2(String s2) {
        int m = s2.length();
        int r = 0;
        int s = 0;
        int t = 0;
        int x=4*r+1;
        int y=8*s+3;
        int z=8*t+7;
        while (x < m) {
            if (s2.charAt(x) != ',') {
                return false;
            }
            r++;
            x = 4 * r + 1;
        }
        while (y < m) {
            if (s2.charAt(y) != ' ') {
                return false;
            }
            s++;
            y = 8 * s + 3;
        }
        while (z < m) {
            if (s2.charAt(z) != ';') {
                return false;
            }
            t++;
            z = 8 * t + 7;
        }
        return true;
    }
}
