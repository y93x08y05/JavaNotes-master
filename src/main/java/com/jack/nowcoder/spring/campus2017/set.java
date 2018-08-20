package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zhangta on 3/17/2018.
 * 给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素
 * 每组输入数据分为三行,第一行有两个数字n,m(0 ≤ n,m ≤ 10000)，分别表示集合A和集合B的元素个数。
 * 后两行分别表示集合A和集合B。每个元素为不超过int范围的整数,每个元素之间有个空格隔开
 * 针对每组数据输出一行数据，表示合并后的集合，要求从小到大输出，每个元素之间有一个空格隔开,行末无空格
 * 输入
 * 3 3
 * 1 3 5
 * 2 4 6
 * 输出
 * 1 2 3 4 5 6
 */
public class set {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        Set<Integer> ts = new TreeSet<>();
        while((line=bf.readLine())!=null) {
            int m = Integer.parseInt(line.split(" ")[0]);
            int n = Integer.parseInt(line.split(" ")[1]);
            line = bf.readLine();
            String[] str1 = line.split(" ");
            for(int i=0;i<m;i++) {
                ts.add(Integer.parseInt(str1[i]));
            }

            line = bf.readLine();
            String[] str2 = line.split(" ");
            for(int i=0;i<n;i++) {
                ts.add(Integer.parseInt(str2[i]));
            }
            Iterator<Integer> it = ts.iterator();
            StringBuffer sb = new StringBuffer();
            while(it.hasNext()) {
                sb.append(it.next()+" ");
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
        }
    }
}
