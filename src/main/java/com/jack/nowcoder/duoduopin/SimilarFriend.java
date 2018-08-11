package com.jack.nowcoder.duoduopin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 9:59 AM
 * 找到不是朋友但是拥有最多共同好友的最可能好友
 */
public class SimilarFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String [] strings = str.split(" ");
            int lineNum = Integer.valueOf(strings[0]);
            int user = Integer.valueOf(strings[1]);
            ArrayList<ArrayList<Integer>> lists  = new ArrayList<>();
            for (int i=0;i<lineNum;i++) {
                String s = sc.nextLine();
                String [] strings1 = s.split(" ");
                ArrayList<Integer> list = new ArrayList<>();
                for (String s1:strings1) {
                    list.add(Integer.valueOf(s1));
                }
                lists.add(list);
            }
            ArrayList<Integer> friends = lists.get(user);
            int maxIndex = -1;
            int max = 0;
            for (int i=0;i<lists.size();i++) {
                ArrayList<Integer> current = lists.get(i);
                int same = sameNum(current,friends);
                if (same > max && i != user && !friends.contains(i)) {
                    max = same;
                    maxIndex = i;
                }
            }
            System.out.println(maxIndex);
        }
    }
    private static int sameNum(ArrayList<Integer> arr1,ArrayList<Integer> arr2) {
        int time = 0;
        for (int i=0;i<arr1.size();i++) {
            for (int j=0;j<arr2.size();j++) {
                if (arr1.get(i) == arr2.get(j))
                    time++;
            }
        }
        return time;
    }
}
