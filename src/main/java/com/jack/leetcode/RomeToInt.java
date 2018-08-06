package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 1:16 PM
 * LeetCode 13
 * rome number transfer to int
 */
public class RomeToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(romanToInt(str));
    }
    private static int romanToInt(String s) {
        int sum = 0;
        boolean flag = false;
        if (s.length() > 1) {
            for (int i=0;i<s.length()-1;i++) {
                if (s.charAt(i) == 'M') {
                    sum+=1000;
                    continue;
                } else if (s.charAt(i) == 'V') {
                    sum+=5;
                    continue;
                } else if (s.charAt(i) == 'L') {
                    sum+=50;
                    continue;
                } else if (s.charAt(i) == 'D') {
                    sum+=500;
                    continue;
                } else if (s.charAt(i) == 'I') {
                    if (s.charAt(i+1) == 'V') {
                        sum+=4;
                        i++;
                        if (i == s.length()-1)
                            flag = true;
                        continue;
                    } else if (s.charAt(i+1) == 'X') {
                        sum+=9;
                        i++;
                        if (i == s.length()-1)
                            flag = true;
                        continue;
                    } else {
                        sum+=1;
                        continue;
                    }
                } else if (s.charAt(i) == 'X') {
                    if (s.charAt(i+1) == 'L') {
                        sum+=40;
                        i++;
                        if (i == s.length()-1)
                            flag = true;
                        continue;
                    } else if (s.charAt(i+1) == 'C') {
                        sum+=90;
                        i++;
                        if (i == s.length()-1)
                            flag = true;
                        continue;
                    } else {
                        sum+=10;
                        continue;
                    }
                } else if (s.charAt(i) == 'C') {
                    if (s.charAt(i+1) == 'D') {
                        sum+=400;
                        i++;
                        if (i == s.length()-1)
                            flag = true;
                        continue;
                    } else if (s.charAt(i+1) == 'M') {
                        sum+=900;
                        i++;
                        if (i == s.length()-1)
                            flag = true;
                        continue;
                    } else {
                        sum+=100;
                        continue;
                    }
                }
            }
        }
        if (!flag) {
            if (s.charAt(s.length()-1) == 'I') {
                sum+=1;
            } else if (s.charAt(s.length()-1) == 'V') {
                sum+=5;
            } else if (s.charAt(s.length()-1) == 'X') {
                sum+=10;
            } else if (s.charAt(s.length()-1) == 'L') {
                sum+=50;
            } else if (s.charAt(s.length()-1) == 'C') {
                sum+=100;
            } else if (s.charAt(s.length()-1) == 'D') {
                sum+=500;
            } else if (s.charAt(s.length()-1) == 'M') {
                sum+=1000;
            }
        }
        return sum;
    }
}
