package com.jack.nowcoder.spring.A163.SpringJob2018;

/**
 * 一个正整数数对(x, y)，x和y均不大于n, 并且x除以y的余数大于等于k。
 * 计算一共有多少个可能的数对。
 * 输入描述
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 * 输入例子
 * 5 2
 * 输出例子
 * 7
 */

import java.util.Scanner;

public class Spring_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(k == 0)
            //即x除以y的余数大于等于0，即每一对都可以
            System.out.println((long) n * n);
        else {
            long ans = 0;
            for(int i = k + 1; i <= n; i++){
                //计算（2,3）（2,4）（2,5）（3,4）（3,5）（4,5）
                ans += (n / i) * (i - k);
                if(n % i >= k)
                    //计算（5,2）（5,3）（5,4）（4,2）（4,3）（3,2）
                    ans += n % i - k + 1;
            }
            System.out.println(ans);
        }
    }
}