package com.jack.nowcoder.autumn.duxiaoman;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/13 16:02
 * 在Z省，有若干个城市坐落在一条直线上，
 * 从左到右依次标号1,2,3,…，其中每个城市有一个火车站点，
 * 现今已经开放了n条火车路线，
 * 第i条火车路线是从第Yi个城市到第Xi个城市，
 * 因为Z省地势奇特，标号小的城市地势较低，所以火车是从高往低开的，
 * 再通过神秘力量传送回高地，即Yi一定大于Xi，
 * 它在沿途的所有城市都会停靠
 * （显然不包括起点Yi，但是包括终点Xi），
 * 火车停靠就需要火车站台来运营维护。
 * 火车站台随着运营线路的数量不同，其损耗速度、维护成本也各异，
 * 现在我们想知道所有站台中，所运营的线路数最大是多少。
 * 输入
 * 第一行一个数n。（1≤n≤100000）
 * 接下来n行每行两个数Xi和Yi，分别代表第i条火车路线的终点和起点。
 * （1≤Xi<Yi≤1e5）
 * 输出
 * 共一行，一个非负整数，表示最大运营路线数。
 * 样例输入
 * 4
 * 4 7
 * 2 6
 * 2 5
 * 1 2
 * 样例输出
 * 3
 * Hint
 * 第一条涉及站台6，5，4
 * 第二条涉及站台5，4，3，2
 * 第三条涉及站台4，3，2
 * 第四条涉及站台1
 * 所以显然站台4运营的线路最多，有3条
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++) {
            int start=sc.nextInt();
            int end=sc.nextInt();
            for (int j=start;j<end;j++) {
                if (map.containsKey(j))
                    map.put(j,map.get(j)+1);
                else
                    map.put(j,1);
            }
        }
        int val=Integer.MIN_VALUE;
        Iterator iterator=map.values().iterator();
        while (iterator.hasNext())
            val=val>(int)iterator.next()?val:(int)iterator.next();
        val=val==Integer.MIN_VALUE?0:val;
        System.out.println(val);
    }
}