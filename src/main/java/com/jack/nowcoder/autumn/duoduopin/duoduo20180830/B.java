package com.jack.nowcoder.autumn.duoduopin.duoduo20180830;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 10:11 PM
 */
public class B {
    Scanner scanner = new Scanner(System.in);
    int n;
    int m;
    char str[][] = new char[12][12];
    void  solve(){
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i=0;i<n;i++){
            String s = scanner.next();
            str[i] = s.toCharArray();
        }
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(str[j][i]=='.')continue;
                if(str[j][i]=='x')continue;
                int k = j;
                while(k<n){
                    str[k][i]='.';
                    k++;
                    if(k<n&&str[k][i]!='.'){
                        str[k-1][i]='o';
                        break;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.printf("%c",str[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new B().solve();
    }
}
