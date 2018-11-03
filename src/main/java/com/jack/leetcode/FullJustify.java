package com.jack.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/19 19:21
 * LeetCode 68
 * 文本左右对齐
 * 给定一个单词数组和一个长度maxWidth，重新排版单词，使得成为每行
 * 刚好有maxWidth个字符，且左右两端对齐的文本。你应该使用贪心算法
 * 来放置给定的单词，即尽可能多的往每行中放置单词。必要时可用空格填充
 * 使得每行恰好有maxWidth个字符。
 * 要求尽可能均匀分配单词间的空格数量，如果某一行单词间的空格不能均匀分配，
 * 则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不能插入额外的空格。
 * 说明：
 * 单词是指由非空格字符组成的字符序列
 * 每个单词的长度大于0，小于等于maxWidth
 * 输入单词数组words至少包含一个单词
 * 例1:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 例2:
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 例3:
 * 输入:
 * words = ["Science","is","what","we","understand","well",
 * "enough","to","explain","to","a","computer.",
 * "Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class FullJustify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxWidth = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        System.out.println(fullJustify(str, maxWidth));
    }
    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        List<String> tmpList = new LinkedList<>();
        int length = words.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += words[i].length() + 1;
            tmpList.add(words[i]);
            if (i + 1 < length && count + words[i + 1].length() > maxWidth) {
                int neededSpace = maxWidth - count + 1;
                int size = tmpList.size();
                int average,extra;
                if (size == 1) {
                    average = neededSpace;
                    extra = 0;
                } else {
                    average = neededSpace / (size - 1);
                    extra = neededSpace % (size - 1);
                }
                StringBuilder spaceStr = new StringBuilder();
                for (int j = 0; j < average; j++) {
                    spaceStr.append(' ');
                }
                StringBuilder sb = new StringBuilder();
                while (!tmpList.isEmpty()) {
                    String tmp = tmpList.get(0);
                    tmpList.remove(0);
                    sb.append(tmp);
                    if (tmpList.isEmpty()) {
                        break;
                    }
                    sb.append(' ');
                    sb.append(spaceStr);
                    if (extra > 0) {
                        sb.append(' ');
                        extra--;
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
                res.add(new String(sb));
                count = 0;
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while (!tmpList.isEmpty()) {
            sb1.append(tmpList.get(0));
            tmpList.remove(0);
            sb1.append(' ');
        }
        while (sb1.length() < maxWidth)
            sb1.append(' ');
        if (sb1.length() > maxWidth)
            sb1.deleteCharAt(maxWidth);
        res.add(sb1.toString());
        return res;
    }
}