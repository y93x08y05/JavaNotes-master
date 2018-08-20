package com.jack.nowcoder.spring.MeiTuan;

import java.util.Scanner;

/**
 * 输入一行字符串，字符在‘0’和‘9’之间的长度，输出这些字符所不能组成的最小的正整数
 * 比如55不能组成的最小的正整数为1，比如123456789不能组成的最小的正整数为10
 * 统计0-9中数字个数，选出最少的那个，比如3最少，有两个三，答案就是333，
 * 但是0除外，如果有两个0，答案就是1000，没有其他情况
 * 分三种情况：
 * （1）1-9不全有 则挑出1-9中没有的数字中最小的那个
 * （2）1-9全部有，没有0，此时最小的为10
 * （3）1-9全部有，有0
 * 从1-9中找出个数最少的那个数，记为x，其个数记为nx。记0的个数为n0
 * 若nx>n0，输出一个x和n0+1个0
 * 若nx<=0，输出nx+1个x
 */

public class Java2018_2Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] num = new int[10];
        for(char c: s.toCharArray()) {
            num[c - '0']++;
        }
        System.out.println(helper(num));
    }
    public static String helper(int[] num) {
        String[] res = new String[2];
        res[0] = "";
        res[1] = "1";
        int index = 1;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < 10;i++) {
            if(num[i] < min) {
                min = num[i];//记录1-9中个数最少的，并且将个数最少的数记为index
                index = i;
            }
        }
        for(int i = 0; i < min + 1;i++) {
            res[0] = res[0] + index;//记录个数最少的数能够组成的最大数是多少
        }
        for(int i = 0;i<num[0]+1;i++) {
            res[1] = res[1] + "0";//一共有多少个0，给0补1记录用0能组合的最大数
        }
        //计算两个数的大小，并且返回结果值
        if(res[0].length() < res[1].length()) {
            return res[0];
        }else if(res[1].length() < res[0].length()){
            return res[1];
        }else {
            //当两个数的位数相等时，从大到小比较每一位的大小，并且返回值。
            for(int i = 0; i < res[0].length();i++) {
                if(res[0].charAt(i) < res[1].charAt(i)) {
                    return res[0];
                }else if(res[1].charAt(i) < res[0].charAt(i)) {
                    return res[1];
                }
            }
        }
        return res[1];
    }
}