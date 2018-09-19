package com.jack.nowcoder.autumn.tencent.tencent0916;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/16 9:41
 * 4 3
 * 2 1
 * 3 2
 * 4 3
 * 2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<m;i++) {
            map.put(sc.nextInt(),sc.nextInt());
        }
        System.out.println(findImportantCity(map, n, m));
    }
    private static int findImportantCity(Map<Integer,Integer> map,int n,int m) {
        Map<Integer,List<Integer>> map1=new HashMap<>();
        for (int i=1;i<=n;i++) {
            List<Integer> list=new ArrayList<>();
            if (map.containsKey(i)) {
                list.add(map.get(i));
                find(map,map1,list,i,n);
                map1.put(i,list);
            }
        }
        return 2;
    }
    private static void find(Map<Integer,Integer> map,Map<Integer,List<Integer>> map1,List<Integer> list,int i,int n) {
        if (map.containsKey(map.get(i))) {
            list.add(map.get(i));
            find(map,map1,list,map.get(i),n);
            }
    }
}