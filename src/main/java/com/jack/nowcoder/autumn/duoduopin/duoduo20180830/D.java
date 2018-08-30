package com.jack.nowcoder.autumn.duoduopin.duoduo20180830;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 10:24 PM
 */
public class D {
    Scanner scanner = new Scanner(System.in);
    int n;
    int l;
    int flag;
    int vis[][];
    String []str = new String[2005];
    HashMap<String,Integer> mp = new HashMap<>(2005);
    char []ans;
    void solve(){
        n = scanner.nextInt();
        l= scanner.nextInt();
        flag = 0;
        ans = new char[l];
        vis = new int[l][26];
        for(int i=0;i<n;i++){
            String s = scanner.next();
            for(int j=0;j<l;j++){
                vis[j][s.charAt(j)-'A']=1;
            }
            if(mp.containsKey(s)){
                mp.put(s,mp.get(s)+1);
            }else{
                mp.put(s,1);
            }
        }
        dfs(0);
        if(flag==0) System.out.println("-");
    }
    void dfs(int len) {
        if(flag==1)return;
        if(len==l){
            String s = new String(ans);
            if(!mp.containsKey(s)){
                System.out.println(s);
                flag = 1;
            }
            return;
        }
        for(int j=0;j<26;j++){
            if(vis[len][j]==1){
                ans[len] = (char)('A'+j);
                dfs(len+1);
            }
        }
    }
    public static void main(String[] args) {
        new D().solve();
    }
}
