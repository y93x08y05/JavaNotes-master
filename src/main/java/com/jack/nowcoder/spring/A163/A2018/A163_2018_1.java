package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/6/2018.
 * 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在
 * 一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法
 * 币产生更多的魔法币。
 * 魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
 * 魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
 * 小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰
 * 好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
 */
public class A163_2018_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int coinCount = in.nextInt();
            StringBuilder sb = new StringBuilder();
            while (coinCount > 0) {
                if (coinCount % 2 == 0) {
                    coinCount = (coinCount - 2) / 2;
                    sb.append("2");
                } else {
                    coinCount = (coinCount - 1) / 2;
                    sb.append("1");
                }
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
