package com.jack.nowcoder.spring.JingDong;

import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long num = sc.nextInt();
            for (int i=0;i<num;i++){
                String s = sc.next();
                int left = 0;
                int right = 0;
                int count = 0;
                boolean is = false;
                for(int j = 0; j < s.length(); j++){
                    if(s.charAt(j)=='('){
                        count++;
                    }
                    if(s.charAt(j)==')'){
                        count--;
                    }
                    if (right - left > 1){
                        System.out.println("No");
                        is = true;
                        break;
                    }
                }
                if (!is){
                    System.out.println("Yes");
                }
            }
        }
    }
}