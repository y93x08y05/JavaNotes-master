package com.jack.nowcoder.autumn.NVIDIA;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 17:52
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        System.out.println(find(N, M));
    }
    public static int find(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i<=n; i++)
            list.add(i);
        int index = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++)
                index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
