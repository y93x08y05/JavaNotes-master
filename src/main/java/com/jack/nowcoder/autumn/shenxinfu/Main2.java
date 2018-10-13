package com.jack.nowcoder.autumn.shenxinfu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/10/13 19:18
 * 需要制作一个手机号码查询系统，输入连续的数字后，需要显示所有包含该
 * 连续数字的手机号。为了验证算法，目前只需要输出手机号的个数即可。
 * 输入描述：
 * 首行输入两个数N，M，之后是N行输入，表示有N个手机号码，每个手机号码由
 * 11位首位不为零的连续数字组成，接着是M行单词，每行由连续的数字组成。
 * 长度为L。
 * 输出描述：
 * 每个请求输出包含查询数字串的不同的手机号共多少个。
 * 输入：
 * 3 2
 * 15623651459
 * 18956036508
 * 18625690367
 * 333
 * 036
 * 输出：
 * 0
 * 2
 * 输入数据号可能有冗余
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s [] = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextLine());
        }
        for (int i = 0; i < M; i++) {
            String temp = sc.nextLine();
            int count = 0;
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().contains(temp))
                    count++;
            }
            System.out.println(count);
        }
    }
}