package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 9:16 PM
 * LeetCode 51
 * n queens in nxn and between queen one not attack other
 */
public class QueensN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findQueen(n).size());
    }
    private static List<List<String>> findQueen(int n) {
        List<List<String>> res = new ArrayList<>();
        int [] queenList = new int[n];
        placeQueen(queenList,0,n,res);
        return res;
    }
    private static void placeQueen(int [] queenList,int row,int n,List<List<String>> res) {
        if (row==n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i=0;i<n;i++) {
                String str = "";
                for (int col=0;col<n;col++) {
                    if (queenList[i]==col)
                        str+="Q";
                    else
                        str+=".";
                }
                list.add(str);
            }
            res.add(list);
        }
        for (int col=0;col<n;col++) {
            if (isValid(queenList,row,col)) {
                queenList[row] = col;
                placeQueen(queenList,row+1,n,res);
            }
        }
    }
    private static boolean isValid(int [] queenList,int row,int col) {
        for (int i=0;i<row;i++) {
            int pos = queenList[i];
            if (pos==col)
                return false;
            if (pos+row-i==col)
                return false;
            if (pos-row+i==col)
                return false;
        }
        return true;
    }
}
