package com.jack.train;

/**
 * Created by Jack on 7/31/2018 10:02 AM
 */
public class Main2 {
    public static String s = "PAYPALISHIRING";
    public static void main(String[] args) {
        int n = 4;
        System.out.println(getString(s, n));
    }
    public static StringBuilder sb = new StringBuilder();
    public static String getString(String s,int n) {
        int z = (1+n-2) * (s.length() / (n + n - 2)) + 1;
        char [][] arr = new char[n][z];
        arr = getResult(arr,s,n);
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[0].length;j++) {
                if (arr[i][j] != '0') {
                    sb.append(arr[i][j]);
                }
            }
        }
        return sb.toString();
    }
    public static char [][] getResult(char [][] arr,String s,int n) {
        int a = 0;
        int b = 0;
        int temp = 0;
        while (temp < s.length()) {
            while (a < n-1 && temp < s.length()) {
                arr[a++][b] = s.charAt(temp++);
            }
            while (a > 0 && temp < s.length()){
                arr[a--][b++] = s.charAt(temp++);
            }
            a = 0;
        }
        return arr;
    }
}
