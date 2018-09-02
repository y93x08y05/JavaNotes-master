package com.jack.nowcoder.autumn.tencent.tencent0831;

import java.util.Scanner;

/**
 * Created by Jack on 8/31/2018 8:23 PM
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成
 * 一个总长度为K的歌单每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的
 * 先后顺序的情况下，请问有多少中组成歌单的方法。
 * 输入描述：
 * 每个输入包含一个测试用例
 * 每个测试用例的第一行包含一个整数表示歌单的总长度K(1<=K<=1000)
 * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和
 * 数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A
 * 不等于B。
 * 输出描述：
 * 输出一个整数表示组成歌单的方法取模，因为答案可能会很大，输出时对
 * 10000000取模
 * 输入
 * 5
 * 2 3 3 3
 * 输出
 * 9
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();
        int A=sc.nextInt();
        int X=sc.nextInt();
        int B=sc.nextInt();
        int Y=sc.nextInt();
        System.out.println(findMethodCount(K, A, X, B, Y));
    }
    private static int findMethodCount(int K,int A,int X,int B,int Y) {
        if (K>A&&K>B)
            return 0;
        else if (K>A&&K<=B) {
            if (K%A!=0)
                return 0;
            else {
                int temp=K/A;
                if (temp>X)
                    return 0;
                else if (temp==X){
                    return 1;
                } else {
                    int sum=1;
                    for (int i=temp;i<=X;i++) {
                        sum*=i;
                    }
                    return sum;
                }
            }
        } else if (K<=A&&K>B) {
            if (K%B!=0)
                return 0;
            else {
                int temp=K/B;
                if (temp>Y)
                    return 0;
                else if (temp==Y){
                    return 1;
                } else {
                    int sum=1;
                    for (int i=temp;i<=Y;i++) {
                        sum*=i;
                    }
                    return sum;
                }
            }
        }
        return 9;
    }
}
