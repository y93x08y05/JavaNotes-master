package com.jack.nowcoder.toutiao.TOUTIAO20180812;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 1:56 PM
 */
public class MergeInterval2 {
    class Node implements Comparable<Node> {
        public  long l;
        public  long r;
        public Node(){

        }
        public Node(Long l,Long r) {
            this.l = l;
            this.r = r;
        }
        @Override
        public int compareTo(Node o) {
            if (o.l==this.l)
                return this.r<o.r?-1:1;
            return this.l<o.l?-1:1;
        }
    }
    public static ArrayList<Node> list = new ArrayList<>();
    public static ArrayList<Node> ans = new ArrayList<>();
    public static int n;
    public static void main(String[] args) {
        new MergeInterval2().solve();
    }
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while (m-->0) {
            String str = sc.next();
            String [] strings = str.split(";");
            for (int i=0;i<strings.length;i++) {
                String [] s = strings[i].split(",");
                list.add(new Node(Long.parseLong(s[0]),Long.parseLong(s[1])));
                n++;
            }
        }
        Collections.sort(list);
        long l = list.get(0).l;
        long r = list.get(0).r;
        for (int i=0;i<list.size();i++) {
            if (list.get(i).l>r) {
                ans.add(new Node(l,r));
                l = list.get(i).l;
                r = list.get(i).r;
            } else
                r = Math.max(r,list.get(i).r);
        }
        ans.add(new Node(l,r));
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<ans.size();i++) {
            sb.append(ans.get(i).l);
            sb.append(",");
            sb.append(ans.get(i).r);
            if (i!=ans.size()-1)
                sb.append(";");
        }
        System.out.println(sb.toString());
    }
}
