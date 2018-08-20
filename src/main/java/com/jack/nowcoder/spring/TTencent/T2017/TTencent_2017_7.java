package com.jack.nowcoder.spring.TTencent.T2017;

import java.util.Scanner;

/**
 * Created by zhangta on 1/10/2018.
 * geohash编码：geohash常用于将二维的经纬度转换为字符串，
 * 分为两步：第一步是经纬度的二进制编码，第二步是base32转码。
 *此题考察纬度的二进制编码：
 * 算法对纬度[-90, 90]通过二分法进行无限逼近（取决于所需精度，本题精度为6）。
 * 注意，本题进行二分法逼近过程中只采用向下取整来进行二分，针对二分中间值属于右区间。
 * 算法举例如下： 针对纬度为80进行二进制编码过程：
 * 1) 区间[-90, 90]进行二分为[-90, 0),[0, 90]，成为左右区间，可以确定80为右区间，标记为1；
 * 2) 针对上一步的右区间[0, 90]进行二分为[0, 45),[45, 90]，可以确定80是右区间，标记为1；
 * 3) 针对[45, 90]进行二分为[45, 67),[67,90],可以确定80为右区间，标记为1；
 * 4) 针对[67,90]进行二分为[67, 78),[78,90]，可以确定80为右区间，标记为1；
 * 5) 针对[78, 90]进行二分为[78, 84),[84, 90]，可以确定80为左区间，标记为0；
 * 6) 针对[78, 84)进行二分为[78, 81), [81, 84)，可以确定80为左区间，标记为0；
 * 输入包括一个整数n,(-90 ≤ n ≤ 90)
 * 输出二进制编码
 * 输入
 * 80
 * 输出
 * 111100
 */
public class TTencent_2017_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();
            int low = -90;
            int high = 90;
            for(int i = 0; i < 6; i++) {
                if(n >= (low + high) / 2) {
                    System.out.print("1");
                    low = (low + high) / 2;
                } else {
                    System.out.print("0");
                    high = (low + high) / 2;
                }
            }
            System.out.println();
        }
        input.close();
    }
}
