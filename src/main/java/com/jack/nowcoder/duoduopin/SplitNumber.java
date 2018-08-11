package com.jack.nowcoder.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/5/2018 9:45 PM
 */
public class SplitNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        if (len == 0 || len == 1)
            return;
        else if (len == 2)
            System.out.println(1);
        else {
            int count = 0;
            for (int i=1;i<s.length();i++) {
                String temp1 = s.substring(0,i);
                String temp2 = s.substring(i,s.length());
                if (temp1.length() > 1) {
                    if (temp2.length() == 1) {
                        if (temp1.charAt(temp1.length()-1) == '0') {
                            if (temp1.charAt(0) == '0')
                                continue;
                            else
                                count++;
                        } else {
                            if (temp1.charAt(0) == '0')
                                count++;
                            else
                                count+=temp1.length();
                        }
                    } else {
                        if (temp1.charAt(temp1.length()-1) == '0') {
                            if (temp1.charAt(0) == '0')
                                continue;
                            else {
                                if (temp2.charAt(temp2.length()-1) == '0') {
                                    if (temp2.charAt(0) == '0')
                                        continue;
                                    else
                                        count++;
                                } else {
                                    if (temp2.charAt(0) == '0')
                                        count++;
                                    else
                                        count+=temp2.length();
                                }
                            }
                        } else {
                            if (temp1.charAt(0) == '0') {
                                if (temp2.length() == 1)
                                    count++;
                                else {
                                    if (temp2.charAt(temp2.length()-1) == '0') {
                                        if (temp2.charAt(0) == '0')
                                            continue;
                                        else
                                            count+=temp2.length();
                                    }
                                }
                            } else {
                                if (temp2.length() == 1)
                                    count+=temp1.length();
                                else {
                                    if (temp2.charAt(temp2.length()-1) == '0') {
                                        if (temp2.charAt(0) == '0')
                                            continue;
                                        else
                                            count+=temp1.length();
                                    } else {
                                        if (temp2.charAt(0) == '0')
                                            count+=temp1.length();
                                        else
                                            count+=(temp1.length()*temp2.length());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (temp2.length() == 1)
                        count++;
                    else {
                        if (temp2.charAt(temp2.length()-1) == '0') {
                            if (temp2.charAt(0) == '0')
                                continue;
                            else
                                count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
