package com.jack.nowcoder.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 1:21 PM
 * 电话号码
 * 手机号码仅由N位十进制数字组成(0-9)，一个手机号码中至少有k位数字相同，则被定义为靓号，
 * 手机号码可以有前导0，如00123456是一个合法的手机号码，小多想花钱将自己的手机号码修改
 * 为一个靓号，修改号码中的一个数字需要花费的金额为新数字与旧数字的差值。比如将1修改为6或
 * 将6修改为1都需要花费5元钱，给出小多现在的手机号码，请问将其修改为一个靓号最少需要多少钱。
 * 输入描述：
 * 第一行包含两个整数N和K，分别表示手机号码数字个数和靓号至少有K个数字相同。
 * 第二行包含N个字符，每个字符都是一个数字('0'-'9')，数字之间没有其他空白符，表示小多的手机号码
 * 数据范围：2<=k<=n<=10000
 * 输出描述：
 * 第一行包含一个整数，表示修改成一个靓号，最少需要的金额
 * 第二行包含N个数字字符，表示最少花费修改的手机号，若有多个靓号花费都最少，则输出字典序最小的靓号。
 * 输入：
 * 6 5
 * 787585
 * 输出：
 * 4
 * 777577
 */
public class TelNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int n = Integer.valueOf(str[0]);
        int k = Integer.valueOf(str[1]);
        String s = sc.nextLine();
        getNumber(n,k,s);
    }
    private static void getNumber(int n, int k,String s) {
        int [] arr = new int[s.length()];
        int [] arrTemp = new int[s.length()];
        int [] arrTemp2 = new int[s.length()];
        int [] flag = new int[s.length()];
        int temp;
        for (int i=0;i<arr.length;i++) {
            arr[i] = Integer.valueOf(s.charAt(i));
        }
        int mnum = 0;
        int min;
        int minLocal;
        for (int i=0;i<10;i++) {
            for (int j=0;j<n;j++) {
                flag[j] = Math.abs(arr[j] - i);
                arrTemp[j] = arr[j];
            }
            temp = 0;
            for (int q=0;q<k;q++) {
                min = flag[q];
                minLocal = 0;
                for (int m = n-1;m>=0;m--) {
                    if (min > flag[m]) {
                        min = flag[m];
                        minLocal = m;
                    }
                }
                temp += Math.abs(arr[minLocal]-i);
                arrTemp[minLocal] = i;
                flag[minLocal] = 10;
            }
            if (i == 0) {
                mnum = temp;
                for (int p=0;p<n;p++) {
                    arrTemp2[p] = arrTemp[p];
                }
            } else {
                if (mnum > temp) {
                    mnum = temp;
                    for (int w=0;w<n;w++) {
                        arrTemp2[w] = arrTemp[w];
                    }
                }
            }
        }
        System.out.println(mnum);
        for (int i=0;i<n;i++) {
            System.out.print(arrTemp2[i]);
        }
    }
}
