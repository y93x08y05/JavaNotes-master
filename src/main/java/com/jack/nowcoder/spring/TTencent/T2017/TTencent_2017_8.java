package com.jack.nowcoder.spring.TTencent.T2017;

import java.util.ArrayList;

/**
 * Created by zhangta on 1/10/2018.
 * 腾讯大厦有39层，你手里有两颗一模一样的玻璃珠。当你拿着玻璃珠在某一层往下扔的时候，
 * 一定会有两个结果，玻璃珠碎了或者没碎。大厦有个临界楼层。低于它的楼层，往下扔玻璃珠，
 * 玻璃珠不会碎，等于或高于它的楼层，扔下玻璃珠，玻璃珠一定会碎。玻璃珠碎了就不能再扔。
 * 现在让你设计一种方式，使得在该方式下，最坏的情况扔的次数比其他任何方式最坏的次数都少。
 * 也就是设计一种最有效的方式。
 * 用户随机选一层i，扔下去，有两个结果：
 * 碎掉，或者没有碎掉。
 * 1.如果碎掉，去试验前i-1层，那么最多需要i-1次再加上碎掉的那一次，最多就是i次。
 * 2.如果没有碎掉，等于说从第i+1层往后，也还是有两个弹珠，这就回到了递归的思路上了。
 * 在这种没有碎掉的情况下，假如总共有N层，那么N层的最多次数等于N-i层的最多次数。所以
 * 针对用户随机选择的这一层i， 以上1和2两种情况， 求其最大值就是最差情况下的次数。
 * 用户随机选择的这个i，也可以变化的，取值 1,2,3...N. 那么我们就会得到不同的值。
 * 针对1,2,3...N. 会有N个，所有这些值中取最小，就是最优解。
 * 用F（N）表示这个最优解，那么F（0）由于没有楼层，所以一定等于0，也就是说不需要实验。
 * F（0） = 0;
 * F（N）= min（max（1, F(N-1) + 1)， max（2， F（N-2）+ 1)... max(N, F（0）+ 1））
 * F（0） = 0;
 * F（1） = 1;
 * F (2) = min(max(1, F(1）+ 1）， max（2， F（0） + 1）） = 2；
 * 可以使用递归算法求得其值，最终的结果是9次。
 */
public class TTencent_2017_8 {
    public static int getOptimalStep(int N, int[] results, int[] selection) {
        if (N == 0) {
            results[N] = 0;
            return 0;
        }
        if (results[N - 1] >= 0) {
            return results[N - 1];
        }
        int selectedIndex = 0;
        int min = -1;
        for (int i = 0; i < N; i++) {
            int max = Math.max(i + 1, getOptimalStep(N - i - 1, results, selection) + 1);
            if (min < 0) {
                min = max;
                selectedIndex = i;
            } else {
                if (min > max) {
                    selectedIndex = i;
                    min = max;
                }
            }
        }
        selection[N - 1] = selectedIndex;
        results[N - 1] = min;
        return min;
    }
    public static void main(String[] args) {
        int N = 39;
        int[] results = new int[N];
        for (int i = 0; i < results.length; ++i) {
            results[i] = -1;
        }
        int[] selection = new int[N];
        System.out.println("optimal steps:" + getOptimalStep(N, results, selection));
        ArrayList<Integer> steps = new ArrayList<>();
        int current = N - 1;
        int selectPosition = 0;
        while (true) {
            if (current < 0) {
                break;
            }
            selectPosition = selectPosition + selection[current];
            steps.add(selectPosition);
            selectPosition = selectPosition + 1;
            current = N - 1 - selectPosition;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("selections:");
        sb.append("[");
        for (int i = 0; i < steps.size(); ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(steps.get(i) + 1);
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
