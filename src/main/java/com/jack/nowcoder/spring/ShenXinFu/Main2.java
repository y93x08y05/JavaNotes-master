package com.jack.nowcoder.spring.ShenXinFu;
import java.util.Scanner;
public class Main2 {
    public String findStr(String s){
        if(s==null){
            return null;
        }
        int max=0;
        int first=0;
        String res = null;
        for(int i=1;i<s.length();i++){
            for(int k=0,j=0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i))
                    k++;
                else
                    k=0;
                if(k>max){
                    max=k;
                    first=j-max+1;
                }
            }
            if(max>0){
                res = s.substring(first, first+max);
//                System.out.println(res);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Main2().findStr(sc.next()).length()*2);
    }
}