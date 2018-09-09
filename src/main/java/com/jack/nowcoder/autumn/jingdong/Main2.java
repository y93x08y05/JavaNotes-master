package com.jack.nowcoder.autumn.jingdong;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/9 18:45
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]arr=new int[n][3];
        List<List<Integer>> lists=new ArrayList<>();
        for (int i=0;i<arr.length;i++) {
            List<Integer> list=new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            lists.add(list);
        }
        System.out.println(findMin(lists));
    }
    private static int findMin(List<List<Integer>> lists) {
        int count=0;
        if (lists.size()<=1)
            return count;
        Collections.sort(lists, Comparator.comparing(o -> o.get(0)));
        for (int i=0;i<lists.size();i++) {
            for (int j=i+1;j<lists.size();j++) {
                if (lists.get(i).get(0)<lists.get(j).get(0)) {
                    if (lists.get(i).get(1)<lists.get(j).get(1)) {
                        if (lists.get(i).get(2)<lists.get(j).get(2)) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}