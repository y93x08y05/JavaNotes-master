package com.jack.nowcoder.spring.TTouTiao.春招2019;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/3/22 20:52
 * 找钱问题，共1024，64，16，4，1几种面值。
 * 因为1，4，16，64这几种面值都可以由小于他们的面值凑出来，
 * 所以直接贪心的选最大的面值就好。
 */
public class First2 implements Runnable{
    private final int[] arr = {64, 16, 4, 1};
    public static void main(String[] args) {
        new Thread(null, new First2(), "thread-1", 1024 * 1024 * 10).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = 1024 - sc.nextInt(), ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += n / arr[i];
            n %= arr[i];
        }
        System.out.println(ans);
    }
}