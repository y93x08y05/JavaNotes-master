package com.jack.nowcoder.shell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Jack on 8/18/2018 6:29 PM
 * 社团申请教室无冲突问题，删除一个使得其他无冲突
 * 输入
 * 3
 * 3 10
 * 20 30
 * 1 3
 * 输出
 * 3
 * 1 2 3
 * 输入
 * 4
 * 3 10
 * 20 30
 * 1 3
 * 1 39
 * 输出
 * 1
 * 4
 * 输入
 * 3
 * 1 5
 * 2 6
 * 3 7
 * 输出
 * 0
 */
public class Main2 {
    class Node implements Comparable<Node> {
        public  int l;
        public  int r;
        public Node(){

        }
        public Node(Integer l,Integer r) {
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
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        new Main2().solve();
    }
    private void solve() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        int [][] arr = new int[m][2];
        for (int i=0;i<m;i++){
            String str = sc.nextLine();
            String [] s = str.split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            list.add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        Collections.sort(list);
        int i=0;
        while (i<=list.size()-1) {
            Node temp = list.get(i);
            list.remove(i);
            boolean flag = true;
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j+1).l<list.get(j).r) {
                    flag=false;
                    break;
                }
            }
            if (flag) {
                for (int k=0;k<arr.length;k++) {
                    if (temp.l==arr[k][0]&&temp.r==arr[k][1])
                        ans.add(k+1);
                }
            }
            i++;
            list.add(temp);
            Collections.sort(list);
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int q=0;q<ans.size();q++) {
            sb.append(ans.get(q));
            if (q!=ans.size()-1)
                sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
