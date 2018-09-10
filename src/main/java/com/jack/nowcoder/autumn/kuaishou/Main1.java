package com.jack.nowcoder.autumn.kuaishou;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/10 18:39
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(findXiaoShu(a, b));
    }
    private static String findXiaoShu(int a,int b) {
        Map<Long,Integer> map=new HashMap<>();
        List<Long> list=new ArrayList<>();
        int index=0;
        int startIndex=-1;
        StringBuilder sb=new StringBuilder();
        if (b==0)
            return "";
        long num1=a;
        long num2=b;
        if ((num1<0&&num2>0)||(num1>0&&num2<0))
            sb.append("-");
        num1=Math.abs(num1);
        num2=Math.abs(num2);
        long value=num1/num2;
        sb.append(String.valueOf(value));
        num1=(num1%num2)*10;
        while (num1!=0) {
            if (map.containsKey(num1)) {
                startIndex=map.get(num1);
                break;
            } else {
                map.put(num1,index++);
                value=num1/num2;
                num1=(num1%num2)*10;
                list.add(value);
            }
        }
        for (int i=0;i<index;i++) {
            if (i==0) {
                sb.append('.');
            }
            if (i==startIndex) {
                sb.append("(");
            }
            sb.append(list.get(i));
        }
        if (startIndex!=-1)
            sb.append(")");
        return sb.toString();
    }
}