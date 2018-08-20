package com.jack.nowcoder.spring.JingDong;

/**
 * https://www.nowcoder.com/discuss/72849?type=0&order=0&pos=6&page=1
 * 京东2018Java开发实习生编程题解网址路径
 */

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long num = sc.nextInt();
            for (int i=0;i<num;i++){
                long value = sc.nextInt();
                boolean isHave = false;
                if (value % 2 != 0){
                    System.out.println("No");
                }else {
                    for (int j=2;j<=value-2;j=j+2){
                        if (value % j == 0){
                            if ((value / j) % 2 == 1){
                                isHave = true;
                                System.out.println((value / j) + " " + j);
                                break;
                            }
                        }
                    }
                    if (!isHave){
                        System.out.println("No");
                    }
                }
            }
        }
    }
}