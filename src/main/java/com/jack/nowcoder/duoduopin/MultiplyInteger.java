package com.jack.nowcoder.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 4:13 PM
 * 有两个用字符串表示的非常大的大整数，算出他们的乘积也是用字符串表示
 * 不能用系统自带的大整数类型。
 * 输入描述：空格分隔的两个字符串，代表输入的两个大整数
 * 输出描述：乘积用字符串表示。
 * 输入例子
 * 72106547548473106236 982161082972751393
 * 输出例子
 * 70820244829634538040848656466105986748
 */
public class MultiplyInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] strings = sc.nextLine().split(" ");
        String str1 = strings[0];
        String str2 = strings[1];
        int len1 = str1.length();
        int len2 = str2.length();
        int [] num = new int[len1+len2];
        for (int i=len1-1;i>=0;i--) {
            int x = str1.charAt(i) - '0';
            for (int j=len2-1;j>=0;j--) {
                int y = str2.charAt(j) - '0';
                num[i+j] += (num[i+j+1]+x*y)/10;
                num[i+j+1] = (num[i+j+1]+x*y)%10;
            }
        }
        String s = "";
        for (int i=0;i<num.length;i++) {
            if (i==0&&num[i]==0)
                continue;
            s+=num[i];
        }
        System.out.println(s);
    }
}
