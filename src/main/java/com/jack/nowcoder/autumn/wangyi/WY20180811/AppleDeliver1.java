package com.jack.nowcoder.autumn.wangyi.WY20180811;

import java.util.Scanner;

/**
 * Created by Jack on 8/11/2018 2:43 PM
 * 又到了丰收的季节，恰好小易到牛牛的果园里游玩，牛牛常说他对整个果园
 * 都了解，在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数
 * 第x个苹果是那一堆的
 * 输入描述
 * 第一行一个整数n,(1<=n<=10^5)
 * 第二行n个数ai(1<=ai<=1000)，表示从左往右第i堆有多少苹果
 * 第三个一个数m表示有m次询问，第四行m个数表示小易希望知道qi个
 * 苹果属于那一堆
 * 输出描述：
 * m行，第i行输出第qi个苹果表示属于那一堆
 * 输入例子1
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 * 输出例子
 * 1
 * 5
 * 3
 */
public class AppleDeliver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int sum = 0;
        for (int i=0;i<n;i++) {
            arr[i]=sum+sc.nextInt();
            sum=arr[i];
        }
        int m = sc.nextInt();
        int [] arr1 = new int[m];
        for (int i=0;i<m;i++) {
            arr1[i] = sc.nextInt();
        }
        int i=0,j;
        while (i<m){
            j=0;
            while (j<arr.length) {
                if (arr1[i]<=arr[j]) {
                    System.out.println(j+1);
                    break;
                } else
                    j++;
            }
            i++;
        }
    }
}
