package com.jack.nowcoder.autumn.bianlifeng;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/28 10:07
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(",");
        int m=Integer.parseInt(str[0]);
        int n=Integer.parseInt(str[1]);
        System.out.println(find(n, m));
    }
    private static List<List<Integer>> find(int m, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        dfs(res,temp,m,n,1);
        return res;
    }
    private static void dfs(List<List<Integer>> res,List<Integer> temp,int n,int k,int m) {
        if (k==0) {
            int sum=0;
            for (int i=0;i<temp.size();i++){
                sum+=temp.get(i);
            }
            if (sum<=n){
                if (!res.contains(temp))
                    res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i=m;i<=n;i++) {
            temp.add(i);
            for (int j=m;j<=n;j++) {
                dfs(res,temp,n,k-1,j);
            }
            temp.remove(temp.size()-1);
        }
    }
}