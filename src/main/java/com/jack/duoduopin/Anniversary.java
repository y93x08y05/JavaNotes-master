package com.jack.duoduopin;

import java.util.*;

/**
 * Created by Jack on 8/5/2018 1:01 PM
 * 拼多多王国的城市和道路的拓扑结构比较特别，是一个树状结构
 * 1、每个城市是树的一个节点
 * 2、城市之间的道路是树的一条边
 * 3、树的根节点是首都
 * 拼多多周年庆马上就要到了，是拼多多王国的一个大日子。为了活跃气氛，国王想在道路上布置花灯
 * 花灯比较贵，尽管国王想在所有道路上布置花灯，但是如果要花太多钱的话，过不了财政大臣一关。
 * 国王把这个计划告诉财政大臣，最后商讨出一个方案：
 * 1、一条道路要么不布置花灯，要么整条布置花灯，不能选择其中的某一段布置
 * 2、除非没有道路通向首都，否则至少为一条通向首都的道路布置花灯
 * 3.所有布置花灯的道路构成的子图是连通的，保证国王从首都出发，能通过只走布置的花灯的道路，
 * 把所有的花灯游览完
 * 4、如果某个城市(包括首都)有大于等于2条道路通向子城市，为了防止铺张浪费，最多只能选择其中的
 * 两条路布置花灯
 * 5、布置花灯的道路的总长度设置一个上限
 * 在上述方案下，国王想要使得布置花灯的道路长度越长越好。
 * 输入描述：
 * 每个测试输入包含一个测试用例
 * 输入的第一行是一个正整数m，0<m<=9900，表示布置花灯的道路的总长度的上限
 * 输入的第二行是一个正整数n，n<=100，表示城市的个数
 * 紧接着是n-1行输入，每行三个正整数u,v,d,表示下标为u的城市有一条长度为d的道路通向它的一个子城市v
 * 其中0<=u<n，0<=v<n，0<d<=100.
 * 输出描述：
 * 输出一个正整数，表示能布置花灯的道路长度的最大值
 * 输入例子：
 * 5
 * 5
 * 0 1 1
 * 0 2 2
 * 0 3 3
 * 0 4 4
 * 输出例子：
 * 5
 */
public class Anniversary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int limit = sc.nextInt();
            int len = sc.nextInt();
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            for (int i = 0; i < len; i++) {
                lists.add(new ArrayList<Integer>());
            }
            int[] father = new int[len];
            Arrays.fill(father, -1);
            int[] d = new int[len];
            int root = 0;
            for (int i = 0; i < len - 1; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int value = sc.nextInt();
                d[end] = value;
                lists.get(start).add(end);
                father[end] = start;
            }
            while (root < father.length && father[root] != -1) {
                root++;
            }
            TreeSet<Integer> res = DFS(root, lists, d, limit);
            System.out.println(res.size() == 0 ? 0 : res.last());
        }
        sc.close();
    }
    private static TreeSet<Integer> DFS(int root,List<List<Integer>> lists,int [] d,int limit) {
        if (lists.get(root).size() == 0) {
            TreeSet<Integer> temp = new TreeSet<Integer>();
            temp.add(0);
            return temp;
        }
        List<TreeSet<Integer>> treeSetList = new ArrayList<TreeSet<Integer>>();
        List<Integer> list = lists.get(root);
        for (int i=0;i<list.size();i++) {
            treeSetList.add(DFS(list.get(i),lists,d,limit));
        }
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(0);
        for (int i=0;i<treeSetList.size();i++) {
            TreeSet<Integer> set = treeSetList.get(i);
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                int temp = iterator.next();
                if (d[lists.get(root).get(i)]+temp<=limit)
                    treeSet.add(d[lists.get(root).get(i)]+temp);
            }
        }
        for (int i=0;i+1<treeSetList.size();i++) {
            for (int j=i+1;j<treeSetList.size();j++) {
                TreeSet<Integer> treeSet1 = treeSetList.get(i);
                TreeSet<Integer> treeSet2 = treeSetList.get(j);
                for (Integer integer1 : treeSet1) {
                    for (Integer integer2 : treeSet2) {
                        if (d[lists.get(root).get(i)]+d[lists.get(root).get(j)]+integer1+integer2<=limit) {
                            treeSet.add(d[lists.get(root).get(i)]+d[lists.get(root).get(j)]+integer1+integer2);
                        }
                    }
                }
            }
        }
        return treeSet;
    }
}
