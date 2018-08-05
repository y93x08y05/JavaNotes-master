package com.jack.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 2:54 PM
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
public class TelNumber1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int n = Integer.valueOf(str[0]);
        int k = Integer.valueOf(str[1]);
        String s = sc.nextLine();
        getNumber(n,k,s);
    }
    private static void getNumber(int n,int k,String s) {

    }
}
