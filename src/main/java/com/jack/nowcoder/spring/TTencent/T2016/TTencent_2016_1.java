package com.jack.nowcoder.spring.TTencent.T2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangta on 2/2/2018.
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，
 * 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 * 测试样例：
 * 1
 * 返回：["0","1"]
 * 方法一：递归
 * 递归的思路就是n位gray码是由n-1位gray码生成，举个例子简单一些：
 * 比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
 * 那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
 * 添加1后需要顺序反向就变成(110,111,101,100)
 * 组合在一起就是(000,001,011,010,110,111,101,100)
 * 方法二：利用公式G(n) =  n XOR (n/2)，求得gray码的十进制之后再转换成二进制字符串
 */
public class TTencent_2016_1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.next());
            System.out.println(getGray(n));
        }
    }
    public static List<String> getGray(int n) {
        List<String> gray = new ArrayList<>();
        if(n == 1){
            gray.add("0");
            gray.add("1");
            return gray;//返回函数调用处继续执行后续代码
        }
        List<String> last_gray = getGray(n-1);
        for(int i = 0; i < last_gray.size(); i++){
            gray.add("0"+last_gray.get(i));
        }
        for(int i = last_gray.size()-1; i >= 0; i--){
            gray.add("1"+last_gray.get(i));
        }
        return gray;
    }
}
