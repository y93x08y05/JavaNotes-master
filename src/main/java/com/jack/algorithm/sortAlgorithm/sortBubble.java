package com.jack.algorithm.sortAlgorithm;

/**
 * Created by zhangta on 1/5/2018.
 * 冒泡排序是相邻两个之间进行比较,时间复杂度为O(n^2)
 *
 * 衡量排序算法：时间复杂度，空间复杂度，稳定性
 * 时间复杂度：关键字比较次数以及记录移动次数
 * 空间复杂度，排序算法额外辅助内存
 * 稳定性，两个记录之间关键字值相等并排序后先后次序保持不变则稳定，否则不稳定
 */
public class sortBubble {
    public static void main(String[] args){
        int score[] = {67, 69, 75, 87, 89, 90, 99, 100};
        for (int i = 0; i < score.length -1; i++){
            for(int j = 0 ;j < score.length - i - 1; j++){
                if(score[j] < score[j + 1]){
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
            System.out.print("第" + (i + 1) + "次排序结果：");
            for(int a = 0; a < score.length; a++){
                System.out.print(score[a] + "\t");
            }
            System.out.println("");
        }
        System.out.print("最终排序结果：");
        for(int a = 0; a < score.length; a++){
            System.out.print(score[a] + "\t");
        }
    }
}
