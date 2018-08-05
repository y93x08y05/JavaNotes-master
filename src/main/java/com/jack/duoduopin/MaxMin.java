package com.jack.duoduopin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Jack on 8/5/2018 9:15 PM
 */
public class MaxMin {
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] cards = new int[n];
        for (int i=0;i<n;i++) {
            cards[i] = sc.nextInt();
        }
        pick(cards,n,0);
        System.out.println(min);

    }
    private static void pick(int [] cards,int cardsLeft,int count) {
        if (cardsLeft == 0) {
            if (count < min) {
                min = count;
            }
            return;
        }
        int [][] temp = new int[cards.length][2];
        for (int i=0;i<cards.length-1;i++) {
            if (cards[i] != -1) {
                for (int j=i+1;j<cards.length;j++) {
                    if (cards[j] != -1) {
                        if (temp[i][0] == 0 && cards[j] > cards[i]) {
                            temp[i][0] = j;
                        } else if (temp[i][1] == 0 && cards[j] < cards[i]) {
                            temp[i][1] = j;
                        }
                    }
                }
            }
        }
        for (int i=0;i<cards.length;i++) {
            if (cards[i] != -1) {
                HashMap<Integer,Integer> hashMap1 = new HashMap<>();
                int next = i;
                do {
                    hashMap1.put(next,cards[next]);
                    cards[next] = -1;
                    next = temp[next][0];
                } while (next != 0);
                pick(cards,cardsLeft-hashMap1.size(),count+1);
                for (Map.Entry<Integer,Integer> entry : hashMap1.entrySet()) {
                    cards[entry.getKey()] = entry.getValue();
                }
                HashMap<Integer,Integer> hashMap2 = new HashMap<>();
                next = i;
                do {
                    hashMap2.put(next,cards[next]);
                    cards[next] = -1;
                    next = temp[next][1];
                } while (next != 0);
                pick(cards,cardsLeft-hashMap2.size(),count+1);
                for (Map.Entry<Integer,Integer> entry : hashMap2.entrySet()) {
                    cards[entry.getKey()] = entry.getValue();
                }
            }
        }
    }
}
