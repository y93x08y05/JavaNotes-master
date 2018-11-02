package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/22 11:08
 * LeetCode 854
 * 相似度为K的字符串
 * 如果可以通过将A中的两个小写字母精确地交换位置K次得到与B相等的字符串，
 * 我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
 * 给定两个字母异位词A和B，返回A和B的相似度K的最小值。
 * 例1：
 * 输入：A = "ab", B = "ba"
 * 输出：1
 * 例2：
 * 输入：A = "abc", B = "bca"
 * 输出：2
 * 例3：
 * 输入：A = "abac", B = "baca"
 * 输出：2
 * 例4：
 * 输入：A = "aabc", B = "abca"
 * 输出：2
 * 1 <= A.length == B.length <= 20
 * A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
 */
public class SimilarityString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        System.out.println(find(A, B));
    }
    private static int find(String A, String B) {
        int i;
        int len = B.length();
        for (i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i))
                break;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(A, i));
        Set<String> set = new HashSet<>();
        set.add(A);
        int res = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int k = 0; k < n; k++) {
                int index = Objects.requireNonNull(queue.peek()).f;
                String str = Objects.requireNonNull(queue.peek()).s;
                queue.poll();
                if (str.equals(B))
                    return res;
                while (index < len && str.charAt(index) == B.charAt(index))
                    index++;
                for (int j = index + 1; j < len; j++) {
                    if (str.charAt(j) == B.charAt(index) && str.charAt(j) != B.charAt(j)) {
                        str = swap(str, index, j);
                        if (!set.contains(str)) {
                            queue.offer(new Pair(str, index + 1));
                            set.add(str);
                        }
                        str=swap(str, index, j);
                    }
                }
            }
            res++;
        }
        return res;
    }
    private static String swap(String m, int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(m, 0, a).append(m, b, b + 1).append(m, a + 1, b).append(m, a, a + 1).append(m.substring(b + 1));
        return sb.toString();
    }
    static class Pair {
        String s;
        int f;
        public Pair(String s, int f) {
            this.s = s;
            this.f = f;
        }
    }
}