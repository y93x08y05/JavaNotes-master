package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/17/2018.
 * 计算机中经常用不同的进制表示一个数，如十进制数123表达为16进制时只包含两位数7、11（B），
 * 用八进制表示为三位数1、7、3，按不同进制表达时，各个位数的和也不同，
 * 如上述例子中十六进制和八进制中各位数的和分别是18和11,。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？
 * 她希望你能帮她解决这个问题？ 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式
 * 输入中有多组测试数据，每组测试数据为一个整数A(1 ≤ A ≤ 5000).
 * 对每组测试数据，在单独的行中以X/Y的形式输出结果。
 * 输入5：输出7/2
 */
public class meanValue {
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num  = Integer.parseInt(br.readLine().toString());
        int sum = 0;
        for(int i=2;i<num;i++){
            int temp = num;
            while (temp!=0){
                sum+=temp%i;
                temp=temp/i;
            }
        }
        //判断分子分母是否可约
        int count = num-2;
        int min = Math.min(sum,count);
        for (int i=min;i>=2;i--){
            if ((sum%i==0)&&(count%i==0)){
                sum=sum/i;
                count=count/i;
            }
        }
        System.out.println(sum + "/" + count);
    }
}
