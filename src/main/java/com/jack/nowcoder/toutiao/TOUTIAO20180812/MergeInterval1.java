package com.jack.nowcoder.toutiao.TOUTIAO20180812;

import java.util.*;

/**
 * Created by Jack on 8/12/2018 9:42 AM
 */
public class MergeInterval1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<m;i++) {
            String [] temp = sc.nextLine().split(";");
            for (int j=0;j<temp.length;j++) {
                list.add(temp[j]);
            }
        }
        for (int i=0;i<list.size();i++) {
            String [] s = list.get(i).split(",");
            int x1 = Integer.valueOf(s[0]);
            int y1 = Integer.valueOf(s[1]);
            for (int j=i+1;j<list.size();j++) {
                String [] s1 = list.get(j).split(",");
                int x2 = Integer.valueOf(s1[0]);
                int y2 = Integer.valueOf(s1[1]);
                if (y1<x2 || y2<x1)
                    continue;
                else if (x1>=x2 && x1<=y2){
                    list.remove(i);
                    list.remove(j-1);
                    if (y1>y2)
                        list.add(x2+","+y1);
                    else
                        list.add(x2+","+y2);
                    break;
                } else if (x2>=x1 && x2<=y1) {
                    list.remove(i);
                    list.remove(j-1);
                    if (y1>y2)
                        list.add(x1+","+y1);
                    else
                        list.add(x1+","+y2);
                    break;
                }
            }
        }
        for (int i=0;i<list.size();i++) {
            String [] s = list.get(i).split(",");
            int x1 = Integer.valueOf(s[0]);
            int y1 = Integer.valueOf(s[1]);
            for (int j=i+1;j<list.size();j++) {
                String [] s1 = list.get(j).split(",");
                int x2 = Integer.valueOf(s1[0]);
                int y2 = Integer.valueOf(s1[1]);
                if (y1<x2 || y2<x1)
                    continue;
                else if (x1>=x2 && x1<=y2){
                    list.remove(i);
                    list.remove(j-1);
                    if (y1>y2)
                        list.add(x2+","+y1);
                    else
                        list.add(x2+","+y2);
                    break;
                } else if (x2>=x1 && x2<=y1) {
                    list.remove(i);
                    list.remove(j-1);
                    if (y1>y2)
                        list.add(x1+","+y1);
                    else
                        list.add(x1+","+y2);
                    break;
                }
            }
        }
        Collections.sort(list);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        HashSet<String> hashSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            String [] s = list.get(i).split(",");
            map.put(Integer.valueOf(s[0]),Integer.valueOf(s[1]));
        }
        for (Map.Entry p : map.entrySet()) {
            sb.append(p.getKey()).append(",").append(p.getValue()).append(";");
        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-1));
    }
}
