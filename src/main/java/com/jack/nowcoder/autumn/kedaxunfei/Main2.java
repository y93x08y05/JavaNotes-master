package com.jack.nowcoder.autumn.kedaxunfei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 16:33
 * 有n个杀手排成一行，每个杀手都有一个不同的编号(编号为1-n)，
 * 在每个夜晚，杀手都会行动，
 * 如果某个杀手编号大于他右边的杀手的编号，
 * 他就会杀死他右边的杀手，杀手行动是瞬间的，
 * 因此一个人可能某一个夜晚既杀死了别人又被别人杀死，
 * 例如3,2,1这个顺序，在第一个夜晚2会杀死1，同时3也会杀死2。
 * 显而易见，一段时间之后，就不会有人杀或被杀，
 * 平安夜也就到来了，请问在平安夜之前有多少个夜晚。
 * 输入
 * 输入第一行是一个整数n（1≤n≤100000）,表示杀手的数量。
 * 接下来一行有n个数，是一个1-n的全排列。
 * 输出
 * 输出包含一个整数，表示平安夜之前经历了多少个夜晚。
 * 样例输入
 * 10
 * 10 9 7 8 6 5 3 4 2 1
 * 样例输出
 * 2
 * 补充样例
 * 输入样例2
 * 6
 * 1 2 3 4 5 6
 * 输出样例2
 * 0
 * 样例解释：
 * 样例1中杀手的变化为[10 9 7 8 6 5 3 4 2 1]->[10 8 4]->[10]，
 * 故答案为2。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findHowManyPeaceNight(arr));
    }
    private static int findHowManyPeaceNight(int []arr) {
        int res=0;
        List<Integer> list=new ArrayList<>();
        for (int i:arr)
            list.add(i);
        return findHowManyPeaceNight(list,res);
    }
    private static int findHowManyPeaceNight(List<Integer> list,int res) {
        if (list.size()<3)
            return res;
        List<Integer> temp=new ArrayList<>();
        temp.add(list.get(0));
        for (int i=0;i<list.size()-2;i++) {
            if (list.get(i+1)>list.get(i)&&list.get(i+1)>list.get(i+2)) {
                temp.add(list.get(i+1));
                res++;
            }
        }
        temp.clear();
        return findHowManyPeaceNight(temp,res);
    }
}