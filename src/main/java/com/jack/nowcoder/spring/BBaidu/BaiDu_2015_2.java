package com.jack.nowcoder.spring.BBaidu;

import java.util.Scanner;

/**
 * 典型的0-1背包问题
 * 已知n个食堂，第i（i属于[1,n])个食堂有m[i]种食物，每种食物有一个价钱c，享受度v，
 * 去一个食堂就餐，花费[bot,top]范围内的钱数（也可以拍桌子走人，哪里都不吃了），
 * 选择若干种食物，使得自己所能获得的享受度最大。同一种食物最多只会点一份。）
 * 现在告诉你所有食堂食物的信息，希望你进行选择搭配，使得得到的享受度最大，并输出这个享受度的值。
 * 输入描述
 *第一行是一个正整数T（1<=T<=20),表示有T组测试数据。
 * 对于每组数据
 * 第一行是三个数n，bot，top，n代表食堂数1<=n<=10），bot是这次吃饭的最低消费，top是这次吃饭的最高消费
 * （0<=bot，top<=10000）
 * 接下来依次是n个食堂的信息，对于第i个食堂
 * 第一行是一个数m[i]（o<=m[i]<=100)，代表第i个食堂的食物数
 * 第二行有2*m[i]个数，分别是c[i][1]，v[i][1]，c[i][2]，v[i][2]，……c[i][m[i]]，v[i][m[i]]
 * c[i][j]表示第i个餐厅第j种食物的价钱，v[i][j]代表第i个餐厅第j种食物给带来的享受度。
 * 输出描述
 * 对于每组数据，请输出一行，每行一个正整数。表示所能获得的最大享受度。
 * 数据结果保证不会超过2^31-1.
 * 输入
 * 2
 * 2 10 20
 * 5
 * 1 1 2 1 5 1 10 1 20 1
 * 5
 * 1 2 2 2 5 2 10 2 20 2
 * 2 10 10
 * 1
 * 5 1
 * 1
 * 5 1
 * 输出
 * 8
 * 0
 */
public class BaiDu_2015_2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int testDataCount = scan.nextInt();
        int mostEnjoy[] = new int[testDataCount];
        for(int i=0;i<testDataCount;i++){
            int diningHallCount = scan.nextInt();
            int diningEnjoy[] = new int[diningHallCount];
            int bot=scan.nextInt();
            int top=scan.nextInt();
            for(int j=0;j<diningHallCount;j++){
                int foodCount=scan.nextInt();
                int AllFood[][] = new int [foodCount+1][top+1];
                int []foodCast = new int[foodCount+1];
                int []foodEnjoy = new int[foodCount+1];
                for(int k=1;k <= foodCount;k++){
                    foodCast[k] = scan.nextInt();
                    foodEnjoy[k] = scan.nextInt();
                }
                diningEnjoy[j] = getEnjoy(AllFood, foodCast, foodEnjoy, foodCount, top,bot);
            }
            int mostDiningEnjoy = -1;
            for(int l=1;l < diningHallCount;l++){
                mostDiningEnjoy = Math.max(diningEnjoy[l],diningEnjoy[l-1]);
                diningEnjoy[l] = mostDiningEnjoy;
            }
            mostEnjoy[i] = mostDiningEnjoy;
        }
        for(int m = 0 ; m < testDataCount ; m++){
            System.out.println(mostEnjoy[m]);
        }
    }
    public static int getEnjoy(int AllFood[][],int foodCast[],int foodEnjoy[],int foodCount,int top,int bot){
        for(int i=1;i<=foodCount;i++){
            for(int j=1;j<=top;j++){
                if(j>=foodCast[i] ){
                    AllFood[i][j] = Math.max(AllFood[i-1][j],AllFood[i-1][j-foodCast[i]]+foodEnjoy[i]);
                }else
                    AllFood[i][j] = AllFood[i-1][j];
                System.out.print(AllFood[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return AllFood[foodCount][top] == AllFood[foodCount][bot-1] ? 0 : AllFood[foodCount][top];
    }
}