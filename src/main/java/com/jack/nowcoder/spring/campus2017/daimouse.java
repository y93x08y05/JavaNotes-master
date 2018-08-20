package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/12/2018.
 * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，
 * 每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，用一个数字代表它的力量，
 * 如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，
 * 袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，
 * 求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
 * 输入描述
 * 输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
 * 输出描述
 * 输出最少的跳数，无法到达输出-1
 * 输入
 * 5
 * 2 0 1 1 1
 * 输出
 * 4
 */
public class daimouse {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] string;
        int n;

        while((str = br.readLine()) != null){
            n = Integer.parseInt(str.trim());
            str = br.readLine();
            string = str.trim().split(" ");
            int[] input = new int[n];
            for(int i = 0; i < n; ++i)
                input[i] = Integer.parseInt(string[i]);
            int step = 1;
            int now = input[0];
            int next = now;
            for(int i = 1; i < n; ++i){
                if(i == now){
                    next = Math.max(next, i + input[i]);
                    if(next == now){
                        System.out.println(-1);
                        break;
                    }
                    ++step;
                    now = next;
                    if(next >= n){
                        System.out.println(step);
                        break;
                    }
                } else{
                    next = Math.max(next, i + input[i]);
                    if(next >= n){
                        System.out.println(++step);
                        break;
                    }
                }
            }
        }
    }
}
