package com.jack.arrowOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 8/1/2018 9:51 AM
 * enter a matrix to print each number in a clockwise order from
 * the outside to the inside.
 */
public class Main21 {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = printMatrix(arr);
        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    public static ArrayList<Integer> printMatrix(int [][] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (arr == null || arr.length == 0) {
            return list;
        }
        int m = arr.length;
        int n = arr[0].length;
        int x = 0;
        int y = 0;
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i=0;i<n;i++) {
                    list.add(arr[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i=0;i<m;i++) {
                    list.add(arr[x++][y]);
                }
                break;
            }
            for (int i=0;i<n-1;i++) {
                list.add(arr[x][y++]);
            }
            for (int i=0;i<m-1;i++) {
                list.add(arr[x++][y]);
            }
            for (int i=0;i<n-1;i++) {
                list.add(arr[x][y--]);
            }
            for (int i=0;i<m-1;i++) {
                list.add(arr[x--][y]);
            }
            x++;
            y++;
            m=m-2;
            n=n-2;
        }
        return list;
    }
}
