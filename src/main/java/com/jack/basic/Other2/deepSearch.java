package com.jack.basic.Other2;

/**
 * Created by zhangta on 1/21/2018.
 * 对一个正整数作如下操作:如果是偶数则除以 2,
 * 如果是奇数则加 1,如此进行直到 1 时操作停止,
 * 求经过 9 次操作变为 1 的数有多少个?
 */
public class deepSearch {
    public  static  int count=0;
    public  static  void deal(int n,int cnt) {
        if(cnt==9){
            count++;
            return;
        }
        if(!(n%2==0))
            deal(2*n,cnt+1);
        else{
            deal(2*n,cnt+1);
            if(n>2)
                deal(n-1,cnt+1);
        }
    }
    public static void main(String [] args) {
        deal(1,0);
        System.out.println(count);
    }
}
