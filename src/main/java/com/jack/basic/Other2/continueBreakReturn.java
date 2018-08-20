package com.jack.basic.Other2;
/**
 * break和continue都可以用在循环语句中，break还可以用在switch中
 * break可以跳出当前的循环中，让本次循环终止，执行循环下边的语句
 * 忽略循环体中其他语句和循环条件测试，只能跳出一层循环
 * 如果多层循环，则需要按层进行多次跳出
 * 当break出现在循环体中的switch语句题内，则结束本次switch循环
 * return从当前的方法中退出，返回到调用该方法的语句处继续执行
 * return返回一个值给调用该方法的语句，返回值的数据类型必须与声明该方法
 * 时返回的值一致
 * return不返回值时，即中断函数的执行，返回函数调用处
 * continue只能终止本次循环，跳过当前这次循环中continue语句后还没有执行的语句
 * 继续下一轮的循环条件判断
 * 终止当前的循环过程，但是并不跳出循环，而是继续下一轮的循环
 * 只能结束循环中的一次判断过程，不能终止循环继续进行
 */
public class continueBreakReturn {
    public static void main(String [] args){
        int m=10;
        for (int n=0;n<m;n++){
            if (n==2){
                return;
            }
            System.out.println(n);
        }
    }
}