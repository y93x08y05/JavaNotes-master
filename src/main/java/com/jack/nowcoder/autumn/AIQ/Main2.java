package com.jack.nowcoder.autumn.AIQ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/15 10:58
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Integer,Integer> map=new HashMap<>();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int p=sc.nextInt();
        for (int i=1;i<=n;i++) {
            map.put(i,sc.nextInt());
        }
        for (int i=0;i<m;i++) {
            String s1=sc.next();
            int a1=sc.nextInt();
            if (s1.equals("A"))
                map.put(a1,map.get(a1)+1);
            else if (s1.equals("B"))
                map.put(a1,map.get(a1)-1);
        }
        int val=map.get(p);
        int count=1;
        for (int i=1;i<=n;i++) {
            if (i!=p) {
                if (map.get(i)>val) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}