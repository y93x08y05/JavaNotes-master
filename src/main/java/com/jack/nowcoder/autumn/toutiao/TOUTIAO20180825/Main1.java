package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180825;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jack on 8/24/2018 8:32 PM
 * 直接或间接认识，然后分组
 * 输入
 * 10
 * 0
 * 5 3 0
 * 8 4 0
 * 9 0
 * 9 0
 * 3 0
 * 0
 * 7 9 0
 * 0
 * 9 7 0
 * 输出
 * 2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        for (int i=0;i<n;i++) {
            ArrayList<Integer> list=new ArrayList<>();
            String [] str=sc.nextLine().split(" ");
            for (int j=0;j<str.length;j++) {
                int temp=Integer.parseInt(str[j]);
                if (temp!=0)
                    list.add(temp);
            }
            lists.add(list);
        }
        System.out.println(findMin(lists));
    }
    private static int findMin(ArrayList<ArrayList<Integer>> lists) {
        if (lists.size()==0)
            return 0;
        if (lists.size()==1)
            return 1;
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i=0;i<lists.size();i++) {
            temp.add(i+1);
            temp.addAll(lists.get(i));
            for (int j=i+1;j<lists.size();j++) {
                if (lists.get(j).contains(i+1)||lists.get(i).contains(j)) {
                    temp.addAll(lists.get(j));
                }
            }
            System.out.println(temp.size());
        }
        return 0;
    }
}
