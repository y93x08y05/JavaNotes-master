package com.jack.nowcoder.spring.campus2017;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhangta on 3/17/2018.
 * 战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。
 * 首都位于一个四面环山的盆地中，周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，
 * 日夜不停的瞭望周围发生的情况。 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，
 * 若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，
 * 则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。
 * 满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。
 * 对于任意相邻的岗哨，一端的岗哨一定可以发现一端点燃的烽烟。
 * 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，她希望你能够帮她解决这个问题
 * 输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),为首都周围的小山数量，
 * 第二行为n个整数，依次表示为小山的高度h（1<=h<=10^9）
 * 对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。
 * 输入
 * 5
 * 1 2 4 5 3
 * 输出 7
 */
class mountain {
    public long val;
    public long num;
    public mountain(long v, long n) {
        this.val = v;
        this.num = n;
    }
}
public class Main___ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        long count = 0;
        while (sc.hasNext()) {
            n = sc.nextInt();
            ArrayList<mountain> mountains = new ArrayList<>();
            int maxIndex = 0;
            int maxHeight = sc.nextInt();
            mountains.add(new mountain(maxHeight, 1));
            // 合并相邻相同高度的山，记录最高山的位置
            for (int i = 1; i < n; i++) {
                int val = sc.nextInt();
                if (val == mountains.get(mountains.size() - 1).val)
                    mountains.get(mountains.size() - 1).num++;
                else {
                    mountains.add(new mountain(val, 1));
                    if (val > maxHeight) {
                        maxHeight = val;
                        maxIndex = mountains.size() - 1;
                    }
                }
            }
            // 从最高的山开始，维持单调栈，每次出栈记录符合要求的数量
            Stack<mountain> s = new Stack<>();
            for (int i = 0; i < mountains.size(); i++) {
                int index = (i + maxIndex) % mountains.size();
                while (!s.isEmpty() && mountains.get(index).val > s.peek().val) {
                    mountain m = s.pop();
                    count += m.num + m.num * (m.num - 1) / 2;  // 出栈山顶与左边以及登高的山峰联通数
                    if (!s.isEmpty())
                        count += m.num;   // 出栈山顶与右边的山顶连通数
                }
                if (s.isEmpty() || mountains.get(index).val < s.peek().val) {
                    s.push(mountains.get(index));
                } else {
                    s.peek().num += mountains.get(index).num;
                }
            }
            // 栈中剩余的山出栈
            while (!s.isEmpty()) {
                mountain m = s.pop();
                if (s.size() == 1 && s.peek().num == 1) {
                    count += m.num + m.num * (m.num - 1) / 2;
                }
                else if (s.size() < 1) {
                    count += m.num * (m.num - 1) / 2;
                }
                else {
                    count +=  m.num + (m.num + m.num * (m.num - 1) / 2);  // 只能和左右两边相联通
                }
            }
            System.out.println(count);
        }
    }
}
