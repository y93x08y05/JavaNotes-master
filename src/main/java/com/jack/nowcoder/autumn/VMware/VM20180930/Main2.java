package com.jack.nowcoder.autumn.VMware.VM20180930;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 8:53
 */
public class Main2 {
    public static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        init(map);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n;i++) {
            String []str=sc.nextLine().split(" ");
            int Y=Integer.parseInt(str[0]);
            int M=Integer.parseInt(str[1]);
            int D=Integer.parseInt(str[2]);
            int A=Integer.parseInt(str[3]);
            int B=Integer.parseInt(str[4]);
            System.out.println(find(Y, M, D, A, B));
        }
    }
    private static int find(int Y,int M,int D,int A,int B) {
        if (M==A) {
            if (B>=D)
                return B-D;
            else {
                int sum=map.get(M)-D+B;
                for (int i=M+1;i<=12;i++) {
                    sum+=map.get(i);
                }
                for (int i=1;i<A;i++) {
                    sum+=map.get(i);
                }
                if (Y%4==0&&M<=2)
                    sum+=1;
                if ((Y+1)%4==0&&A>2)
                    sum+=1;
                return sum;
            }
        } else if (M<A) {
            int sum=map.get(M)-D+B;
            for (int i=M+1;i<A;i++) {
                sum+=map.get(i);
            }
            if (Y%4==0&&M<=2&&A>2)
                sum+=1;
            return sum;
        } else {
            int sum=map.get(M)-D+B;
            for (int i=M+1;i<=12;i++) {
                sum+=map.get(i);
            }
            for (int i=1;i<A;i++) {
                sum+=map.get(i);
            }
            if (Y%4==0&&M<=2)
                sum+=1;
            if ((Y+1)%4==0&&A>2)
                sum+=1;
            return sum;
        }
    }
    public static void init(Map<Integer,Integer> map) {
        map.put(1,31);
        map.put(2,28);
        map.put(3,31);
        map.put(4,30);
        map.put(5,31);
        map.put(6,30);
        map.put(7,31);
        map.put(8,31);
        map.put(9,30);
        map.put(10,31);
        map.put(11,30);
        map.put(12,31);
    }
}