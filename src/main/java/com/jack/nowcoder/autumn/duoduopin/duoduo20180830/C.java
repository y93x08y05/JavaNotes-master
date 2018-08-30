package com.jack.nowcoder.autumn.duoduopin.duoduo20180830;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 10:12 PM
 */
public class C {
    Scanner scanner = new Scanner(System.in);
    int a;
    int b;
    int vis[] = new int[9000005];
    void solve(){
        a = scanner.nextInt();
        b = scanner.nextInt();
        a%=b;
        if(a==0){
            System.out.println(0+" "+0);
        }else{
            int x = 1;
            while(vis[a]==0&&a!=0){
                vis[a] = x++;
                a = a*10;
                a%=b;
            }
            if(a==0){
                System.out.println(x-2+" "+0);
            } else{
                System.out.println(vis[a]-1+" "+(x-vis[a]));
            }
        }
    }
    public static void main(String[] args) {
        new C().solve();
    }
}
