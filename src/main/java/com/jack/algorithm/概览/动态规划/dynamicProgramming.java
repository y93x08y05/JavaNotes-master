package com.jack.algorithm.概览.动态规划;

/**
 * Created by Jack on 8/10/2018 11:46 AM
 */
public class dynamicProgramming {
    public static void main(String[] args) {
        int [] arr = {5,2,1};
        int sum = 10;
        long start1 = System.currentTimeMillis();
        System.out.println(method1(arr,sum));
        System.out.println(System.currentTimeMillis()-start1);
        long start2 = System.currentTimeMillis();
        System.out.println(method2(arr,sum));
        System.out.println(System.currentTimeMillis()-start2);
        long start3 = System.currentTimeMillis();
        System.out.println(method3(arr,sum));
        System.out.println(System.currentTimeMillis()-start3);
        long start4 = System.currentTimeMillis();
        System.out.println(method4(arr,sum));
        System.out.println(System.currentTimeMillis()-start4);
    }
    private static int method1(int [] arr,int target) {
        if (arr == null ||  arr.length == 0 || target < 0)
            return 0;
        return process1(arr,0,target);
    }
    private static int process1(int [] arr,int index,int target) {
        int res = 0;
        if (arr.length == index)
            return (target==0?1:0);
        for (int i=0;arr[index]*i<=target;i++)
            res += process1(arr,index+1,target-arr[index]*i);
        return res;
    }
    private static int [][] remember;
    private static int method2(int [] arr,int target) {
        if (arr == null || arr.length == 0 || target <0)
            return 0;
        remember = new int[arr.length+1][target+1];
        return process2(arr,0,target);
    }
    private static int process2(int [] arr,int index,int target) {
        int res = 0;
        if (arr.length == index)
            return target==0?1:0;
        for (int i=0;arr[index]*i<=target;i++) {
            int mapValue = remember[index+1][target-arr[index]*i];
            if (mapValue != 0)
                res+=(mapValue==-1?0:mapValue);
            else
                res+=process2(arr,index+1,target-arr[index]*i);
        }
        remember[index][target]=(res==0?-1:res);
        return res;
    }
    private static int [][] dp3;
    private static int method3(int [] arr,int target) {
        dp3 = new int[arr.length][target+1];
        for (int i=0;i<arr.length;i++)
            dp3[i][0] = 1;
        for (int i=0;i<target+1;i++) {
            if (i % arr[0] == 0)
                dp3[0][i] = 1;
        }
        for (int i=1;i<arr.length;i++) {
            for (int j=1;j<target+1;j++) {
                process3(arr,i,j);
            }
        }
        return dp3[arr.length-1][target];
    }
    private static int process3(int [] arr,int i,int j) {
        int dpValue = 0;
        for (int m=0;j-m*arr[i]>=0;m++)
            dpValue+=dp3[i-1][j-m*arr[i]];
        dp3[i][j]=dpValue;
        return dpValue;
    }
    private static int [][] dp4;
    private static int method4(int [] arr,int target) {
        dp4 = new int[arr.length][target+1];
        for (int i=0;i<arr.length;i++)
            dp4[i][0] = 1;
        for (int i=0;i<target+1;i++) {
            if (i % arr[0] == 0)
                dp4[0][i] = 1;
        }
        for (int i=1;i<arr.length;i++) {
            for (int j=1;j<target+1;j++) {
                process4(arr,i,j);
            }
        }
        return dp4[arr.length-1][target];
    }
    private static void process4(int [] arr,int i,int j) {
        if (j-arr[i]>=0) {
            dp4[i][j]=dp4[i-1][j]+dp4[i][j-arr[i]];
        }
        int dpValue = 0;
        for (int m=0;j-m*arr[i]>=0;m++)
            dpValue+=dp4[i-1][j-m*arr[i]];
        dp4[i][j]=dpValue;
    }
}
