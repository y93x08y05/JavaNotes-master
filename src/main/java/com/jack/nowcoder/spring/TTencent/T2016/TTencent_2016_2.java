package com.jack.nowcoder.spring.TTencent.T2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangta on 2/2/2018.
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，
 * 某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。
 * 写出具体算法思路和代码实现，要求算法尽可能高效。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 * 若没有金额超过总数的一半，返回0。
 * 测试样例：
 * [1,2,3,2,2],5
 * 返回：2
 * 红包金额出现次数超过总数一半，即排序之后的金额大小的中位数最中间的值
 * 肯定是那个红包金额，其次判断其出现次数是否大于总数的一半
 */
public class TTencent_2016_2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        int [] gifts = new int [str.length];
        for (int i = 0; i < str.length; i++) {
            gifts[i] = Integer.parseInt(str[i]);
        }
        int m = getValue(gifts,n);
        System.out.println(m);
    }
    public static int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int ans = gifts[n/2];
        int num = 0;
        for(int i = 0; i < gifts.length; i++) {
            if(gifts[i] == ans) {
                num++;
            }
        }
        return num <= n/2 ? 0 : ans;
    }
}
