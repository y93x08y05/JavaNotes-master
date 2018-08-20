package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/12/2018.
 * 继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：
 * 首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替
 * （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"），
 * 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。
 * 第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，
 * 每行给定一个分身后的电话号码的分身（长度在3到10000之间）。
 * 输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）
 * 输入
 * 4
 * EIGHT
 * ZEROTWOONE
 * OHWETENRTEO
 * OHEWTIEGTHENRTEO
 * 输出
 * 0
 * 234
 * 345
 * 0345
 */
public class phoneNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        while((s=bf.readLine())!=null){
            out(s);
        }
    }
    private static void out(String s) {
        char[] ch =s.toCharArray();
        int numZ=0,numO=0,numW=0,numV=0,numX=0,numG=0,numS=0,numH=0,numI=0,numU=0;
        for (char c:ch){
            switch(c){
                case 'Z':numZ++;break;
                case 'O':numO++;break;
                case 'W':numW++;break;
                case 'V':numV++;break;
                case 'G':numG++;break;
                case 'S':numS++;break;
                case 'H':numH++;break;
                case 'I':numI++;break;
                case 'U':numU++;break;
                case 'X':numX++;break;
            }
        }
        StringBuffer sb =new StringBuffer();
        for (int i=0;i<numG;i++) sb.append('0');
        for (int i=0;i<(numI-numG-numX-numV-numX+numS);i++) sb.append('1');
        for (int i=0;i<numZ;i++) sb.append('2');
        for (int i=0;i<numO-numW-numZ-numU;i++) sb.append('3');
        for (int i=0;i<numW;i++) sb.append('4');
        for (int i=0;i<numH-numG;i++) sb.append('5');
        for (int i=0;i<numU;i++) sb.append('6');
        for (int i=0;i<numV-numS+numX;i++) sb.append('7');
        for (int i=0;i<numX;i++) sb.append('8');
        for (int i=0;i<numS-numX;i++) sb.append('9');
        System.out.println(sb);
        /**
         * ZERO-8=2,ONE-8=3,TWO-8=4,THREE-8=5,FOUR-8=6
         * FIVE-8=7,SIX-8=8,SEVEN-8=9,EIGHT-8=0,NINE-8=1
         */
    }
}
