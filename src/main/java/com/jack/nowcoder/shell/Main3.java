package com.jack.nowcoder.shell;

import java.util.Arrays;

/**
 * Created by Jack on 8/18/2018 8:35 PM
 * 扑克牌问题，最少多少轮把手中的牌出完
 * 52张牌随机抽取20张
 * 单牌：任意一张牌
 * 对子：两张大小相同的牌
 * 三带：三张大小相同的牌加任意一张牌
 * 四带：四张大小相同的牌加任意两张牌
 * 顺子：至少五张大小连续的牌
 */
public class Main3 {
    public static void main(String[] args) {
        String s = "8K67A65K27T59K346AK2";
        System.out.println(findCount(s));
    }
    private static int findCount(String s) {
        char [] c = s.toCharArray();
        Arrays.sort(c);
        System.out.println(c);
        return 0;
    }
}
