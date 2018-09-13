package com.jack.nowcoder.spring.MeiTuan.CodeM2017.second;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 美团点评上有很多餐馆优惠券，用户可以在美团点评APP上购买。每张优惠券有一个唯一
 * 的正整数编号。当用户在相应餐馆就餐时，可以在餐馆使用优惠券进行消费。优惠券的
 * 购买和使用按照时间顺序逐行记录在日志文件中，运营人员会定期抽查日志文件看业务
 * 是否正确。业务正确定义为：一个优惠券必须购买之后才能使用。
 * 某次抽查时，发现有硬盘故障，历史日志中有部分行损坏，这些行的存在是已知的，但是
 * 行的内容读不出来。假设损坏的行可以是任意的优惠券的购买和使用。
 * 询问这次抽查中业务是否正确，若有错，输出最早出现错误的那行，求出最大S,使得
 * 记录1到S-1满足要求，没有错误，则输出-1。
 * 输入描述：
 * m分别表示m条记录。(1<=m<=5*10^5)
 * 下面有m行，格式为：
 * I x (I为Input的缩写，表示购买优惠券x)
 * O x (O为Output的缩写，表示使用优惠券x)
 * ？(表示这条记录不知道)
 * 输出描述：
 * -1或x(1<=x<=m)，x为使得1到x-1这些记录合法的最大行号。
 * 输入
 * 0
 * 1
 * O 1
 * 2
 * ？
 * O 1
 * 3
 * I 1
 * ？
 * O 1
 * 2
 * I 2
 * O 1
 * 输出：
 * -1
 * 1
 * -1
 * -1
 * 2
 */
public class P6 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNumber = 100005;
        int m = scanner.nextInt();
        int res = -1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int []cnt = new int[maxNumber];
        int []la = new int[maxNumber];
        for (int i=1;i<=m;i++) {//遍历m行数据的每一行，进行记录判断
            String op = scanner.next();
            if (op.equals("?")) {
                arrayList.add(i);//添加未知行所在的行号
                continue;//停止后边代码执行，继续循环
            }
            int x = scanner.nextInt();
            /**
             * 当相同优惠券编号被使用多次时，输入一次+1,输出一次-1。
             * 每次累加判断是否存在同一优惠券编号输出次数大于输入次数
             * 如果存在，此时再利用find去查看之前有多少次未知行
             * 判断是否能够抵消掉输出
             */
            cnt[x] += (op.equals("I") ? 1 : -1);
            if (cnt[x] < 0 || cnt[x] > 1) {
                //当有输出时，判断输出之前是否有"?"，可用其充当输入
                int t = find(la[x],arrayList);
                if (t == -1) {
                    res = i;
                    break;
                }
                arrayList.remove(t);
                cnt[x] = cnt[x] < 0 ? 0 : 1;//count[x]小于0取0，大于1取1
            }
            la[x] = i;//记录优惠券的行数到优惠券所在编号为下标的数组列表
        }
        System.out.println(res);
    }
    public static int find(int la,ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0) {//判断是否存在未知行
            return -1;
        }
        int low = 0;
        int high = arrayList.size()-1;
        while (low < high) {
            int mid = (low + high) / 2;
            int t = arrayList.get(mid);
            if (t < la) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int res;
        if (arrayList.get(low) > la) {
            res = low;
        } else {
            res = -1;
        }
        return res;
    }
}