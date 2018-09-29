package com.jack.nowcoder.autumn.yidianzixun;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/29 19:40
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr));
    }
    private static int find(int []arr) {
        int half=arr.length/2;
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new TreeSet<>();
        for (int i=0;i<arr.length;i++) {
            set.add(arr[i]);
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        Iterator<Integer> iterator=set.iterator();
        while (iterator.hasNext()) {
            int temp=iterator.next();
            if (map.get(temp)>half)
                return temp;
        }
        return 0;
    }
}