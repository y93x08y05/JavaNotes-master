package com.jack.nowcoder.spring.TTouTiao.春招2019;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/3/22 20:59
 * 去掉三连重复（aaa）的最后一个，两对（aabb）的最后一个，而且符合最后匹配。
 * 所以直接从左开始模拟，两个bool，一个表示当前位前1，2位是否相等。
 * 另一个表示当前位的前2，3位是否相同。
 */
public class Second2 implements Runnable{
    public static void main(String[] args) {
        new Thread(null, new Second2(), "thread-1", 1024 * 1024 * 1024).start();
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
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            String source = sc.nextLine();
            boolean flag1 = false, flag2 = false;
            int len = source.length();
            char pre = ' ';
            for (int j = 0; j < len; j++) {
                if (!flag1 || source.charAt(j) != pre) {
                    if (flag1 || !flag2 || source.charAt(j) != pre) {
                        flag2 = flag1;
                        flag1 = pre == source.charAt(j);
                        pre = source.charAt(j);
                        sb.append(source.charAt(j));
                    }
                }
            }
            System.out.println(sb);
        }
    }
}