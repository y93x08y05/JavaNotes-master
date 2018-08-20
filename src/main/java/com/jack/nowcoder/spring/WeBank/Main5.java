package com.jack.nowcoder.spring.WeBank;

/**
 * a只提供最高位的1，只需要考虑b和c
 */

import java.util.Scanner;

public class Main5 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(b-c+1);
    }
}