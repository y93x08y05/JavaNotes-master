package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/19 19:48
 * LeetCode 788
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
 * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。
 * 0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；
 * 6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * 例1:
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 */
public class RotatedDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(rotate(n));
    }
    private static int rotate(int n) {
        int sum=0;
        for (int i=1;i<=n;i++) {
            if (judge(i)) {
                sum++;
            }
        }
        return sum;
    }
    private static boolean judge(int i) {
        int x=i;
        int y=0;
        int z=0;
        int k=0;
        while (x!=0) {
            int temp=x%10;
            x/=10;
            k++;
            if (temp==2||temp==6) {
                temp+=3;
            }
            else if (temp==5||temp==9) {
                temp-=3;
            } else if (temp==0||temp==1||temp==8) {

            } else
                return false;
            y=y*10+temp;
        }
        while (k!=0) {
            z=z*10+y%10;
            y/=10;
            k--;
        }
        if (z!=i)
            return true;
        else
            return false;
    }
}