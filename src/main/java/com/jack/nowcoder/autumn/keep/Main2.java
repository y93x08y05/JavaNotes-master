package com.jack.nowcoder.autumn.keep;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jack on 8/23/2018 6:42 PM
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>(2, 0.7f);
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        System.out.println(map.get(3));
        System.out.println(map.entrySet());
        System.out.println(map.values());
    }
}
