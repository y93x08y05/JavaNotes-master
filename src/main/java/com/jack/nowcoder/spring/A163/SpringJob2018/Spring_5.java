package com.jack.nowcoder.spring.A163.SpringJob2018;

import java.util.Scanner;

/**
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 * 输入描述
 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 * 输出描述
 * 输出一个整数, 表示区间内能被3整除的数字个数。
 * 输入例子
 * 2 5
 * 输出例子
 * 3
 * 重要性质：当数字的各位加起来能被3整除，则这个数字能被3整除
 */
public class Spring_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        int num = (right - left + 1) / 3;
        int ret = 2 * num;
        right -= 3 * num;
        while (left <= right){
            if(left % 3 != 1)
                ret++;
            left++;
        }
        System.out.println(ret);

    }
}