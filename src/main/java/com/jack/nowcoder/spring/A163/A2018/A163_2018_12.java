package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/8/2018.
 * 有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 输入包括两行:
 * 第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度
 * 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割
 * 在一行中输出操作n次之后的b序列,以空格分割,行末无空格
 */
public class A163_2018_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            for (int i = n - 1; i >= 0; i -= 2) {
                System.out.print(num[i] + " ");
            }
            for (int i = n % 2; i < n - 2; i += 2) {
                System.out.print(num[i] + " ");
            }
            System.out.print(num[n - 2]);
        }
    }
}
