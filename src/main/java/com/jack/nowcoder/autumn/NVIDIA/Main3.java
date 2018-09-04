package com.jack.nowcoder.autumn.NVIDIA;

        import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 20:50
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][] arr=new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        int []a1=new int[sc.nextInt()];
        for (int i=0;i<a1.length;i++) {
            a1[i]=sc.nextInt();
        }
        int []a2=new int[sc.nextInt()];
        for (int i=0;i<a2.length;i++) {
            a2[i]=sc.nextInt();
        }
        System.out.println(findMin(arr, a1, a2));
    }
    private static int findMin(int [][]arr,int []a1,int []a2) {
        int x1=a1[0];
        int y1=a1[1];
        int x2=a2[0];
        int y2=a2[1];
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length;j++) {

            }
        }
        return 8;
    }
}