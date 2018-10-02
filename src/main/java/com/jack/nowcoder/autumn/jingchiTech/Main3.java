package com.jack.nowcoder.autumn.jingchiTech;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：
 小A最近新学了一种扑克的游戏。
 在这个游戏中，最后进行比拼的玩家会各自拥有一副由5张扑克牌构成的牌组，
 而这个牌组最大的玩家获得胜利。
 这个牌组将会由每个玩家自己所拥有的2张私有牌和5张所有人都可以使用的
 公共牌中选择出来。因此如果有两名玩家进行比较牌组大小时，
 两个牌组可能同时包含同样的牌。
 这里进行游戏的扑克牌共有52张，
 共有2,3,4,5,6,7,8,9,T,J,Q,K,A这13种类型的牌，
 每一种有4张（因此在一个牌组中，同种类的牌最多只会出现4张）。
 此处为了方便，不考虑花色的情况，即对于每一种牌，如K，4张K的地位是等价的。
 不同种的牌之间有大小的关系，为A>K>Q>J>T>9>8>7>6>5>4>3>2。
 5张牌所能构成的牌组有以下几种情况：
 四条：5张牌中有4张相同的种类。如AAAAQ。
 当两副牌均为四条时，相同的那个种类的牌较大者较大。
 如AAAAQ大于KKKKQ。
 当两副牌均为四条且相同的种类的牌也相同时，第5张牌较大者较大。
 如AAAAQ大于AAAAJ。
 葫芦（三带二）：5张牌中共有两种牌，一种有3张，一种有2张。
 如AAAKK。当两副牌均为葫芦时，3张的那种牌较大者较大。
 如AAAQQ大于KKKQQ。当两副牌均为葫芦且3张的牌相同时，2张的牌较大者较大。
 如AAAKK大于AAAQQ。
 顺子：5张牌是大小连续的。如34567。
 注意此处有唯一一个特殊情况A2345也是顺子，但此刻A视为1，
 因此这个顺子中最大的牌是5。同时TJQKA也是顺子，
 此时A依然按照单张牌中最大的计算。当两副牌均为顺子时，
 最大的牌较大者较大。
 如23456大于A2345;789TJ大于45678;TJQKA则是最大的顺子。
 三条：5张牌中有3张相同的牌，剩下的2张与这3张牌种类不同且互相种类不同。
 如AAAKQ。当两副牌均为三条时，相同的那个种类的牌较大者较大。
 如AAAKQ大于KKKAQ。当两副牌均为三条且相同种类的牌相同时，
 剩下2张牌中最大的那张较大者较大。如AAAKJ大于AAAQJ。
 当两副牌均为三条且相同种类的牌相同且剩下2张牌中最大的那张也相同时，
 第5张牌较大者较大。如AAAKQ大于AAAKJ。
 两对：5张牌中共有三种牌，其中有两种各有2张，第三种有1张。
 如AAKKQ。此处定义“对子”为一个由两张相同的牌组成的牌组。
 如AAKKQ就有一个对子AA和另一个对子KK。
 对子的大小由组成对子的牌的种类决定。如AA大于KK。
 当两副牌均为两对时，最大的对子较大者较大。
 如AAQQJ大于KKQQJ。当两副牌均为两对且最大的对子相同时，
 第二个对子较大者较大。如AAKKJ大于AAQQJ。
 当两副牌均为两对且两个对子都相同时，第5张牌较大者较大。
 如AAKKQ大于AAQQJ。
 一对：5张牌中有一个对子，剩下的3张牌种类与这个对子不同且互相种类不同。
 如AAKQJ。当两副牌均为一对时，对子较大者较大。如AAQJT大于KKQJT。
 当两副牌均为一对且对子相同时，比较剩下的3张牌。优先比较3张中最大的，
 如AAKJT大于AAQJT。若最大的相同，则比较第2大的，如AAKQT大于AAKJT。
 否则比较最小的，如AAKQJ大于AAKQT。
 散牌：牌组不符合任意以上的牌型则为散牌。
 散牌无法构成顺子且5张牌种类均不同。如AKJ54。
 当两副牌均为散牌时，优先比较最大的。如A7654大于K7654。
 若最大的相同则比较次大的。如AK765大于AQ765。
 若再相同则比较第3大的，以此类推。
 不同的牌组类型中，四条>葫芦>顺子>三条>两对>一对>散牌。
 小A作为一个新手，并不能熟练的记忆上述的牌型。
 现在有两副牌组，小A并没有办法快速的判断哪一个更大，你能帮助他吗？
 输入
 第一行是一个不超过100的正整数n，表示一共有n组测试数据。
 每一组数据包含两行，分别代表两个牌组。
 接下来2n行，每2行代表两幅要进行比较的牌组。
 每副牌组由5个被空格隔开的正整数表示。
 其中10代表T，11代表J，12代表Q，13代表K，14代表A。
 因此五个数将会在2到14之间。
 输入保证合法，如不会出现2到14以外的数，同样的数也不会出现超过4次。
 输出
 输出共n行，每行一个整数0或1或2。
 对于每组测试数据，1代表第1个牌组较大，2代表第2个牌组较大，0代表一样大。
 样例输入
 3
 2 3 4 5 6
 4 4 4 4 11
 2 3 8 9 10
 10 9 8 3 2
 4 4 7 8 7
 4 4 8 7 8
 样例输出
 2
 0
 2
 Hint
 对于第一组数据，牌组1是顺子，牌组2是四条，因此牌组2较大。
 对于第二组数据，两个牌组完全一致，因此一样大。
 对于第三组数据，两个牌组均为两对，但牌组1最大的对子由7构成，
 牌组2最大的对子由8构成，因此牌组2较大。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for (int i=0;i<n;i++) {
            String []str1=sc.nextLine().split(" ");
            String []str2=sc.nextLine().split(" ");
            int []arr1=new int[str1.length];
            int []arr2=new int[str2.length];
            for (int p=0;p<arr1.length;p++) {
                arr1[p]=Integer.parseInt(str1[p]);
            }
            for (int q=0;q<arr2.length;q++) {
                arr2[q]=Integer.parseInt(str2[q]);
            }
            System.out.println(find(arr1, arr2));
        }
    }
    public static Map<Integer,Integer> map1=new HashMap<>();
    public static Map<Integer,Integer> map2=new HashMap<>();
    public static int find(int []arr1,int []arr2) {
        for (int i=0;i<arr1.length;i++) {
            if (map1.containsKey(arr1[i]))
                map1.put(arr1[i],map1.get(arr1[i])+1);
            else
                map1.put(arr1[i],1);
        }
        for (int j=0;j<arr2.length;j++) {
            if (map2.containsKey(arr2[j]))
                map2.put(arr1[2],map2.get(arr2[j])+1);
            else
                map2.put(arr2[j],1);
        }
        return find(map1,map2);
    }
    public static int find(Map<Integer,Integer> map1,Map<Integer,Integer> map2) {
        String s1=find(map1);
        String s2=find(map2);
        return 0;
    }
    public static String find(Map<Integer,Integer> map) {
        if (map.size()==2) {
            Iterator<Integer> iterator=map.values().iterator();
            while (iterator.hasNext()) {
                if (iterator.next()==4)
                    return "sitiao";
                else if (iterator.next()==3) {
                    return "hulu";
                }
            }
        } else if (map.size()==3) {


        }
        return "";
    }
}