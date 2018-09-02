package com.jack.nowcoder.spring.tencent.T2018Spring;

import java.util.Scanner;

/**
 * Created by Jack on 9/1/2018 9:43 AM
 * 画家小Q又开始他的艺术创作。小Q拿出了一块有NxM像素格的画板,
 * 画板初始状态是空白的,用'X'表示。
 * 小Q有他独特的绘画技巧,每次小Q会选择一条斜线, 如果斜线的方向形如'/',
 * 即斜率为1,小Q会选择这条斜线中的一段格子,都涂画为蓝色,用'B'表示;
 * 如果对角线的方向形如'\',即斜率为-1,小Q会选择这条斜线中的一段格子,
 * 都涂画为黄色,用'Y'表示。
 * 如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,
 * 用'G'表示。
 * 小Q已经有想画出的作品的样子,
 * 请你帮他计算一下他最少需要多少次操作完成这幅画。
 * 输入描述：
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数N和M(1 <= N, M <= 50),
 * 表示画板的长宽。
 * 接下来的N行包含N个长度为M的字符串,
 * 其中包含字符'B','Y','G','X',分别表示蓝色,黄色,绿色,空白。
 * 整个表示小Q要完成的作品。
 * 输出描述：
 * 输出一个正整数, 表示小Q最少需要多少次操作完成绘画。
 * 输入例子：
 * 4 4
 * YXXB
 * XYGX
 * XBYY
 * BXXY
 * 输出例子：
 * 3
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();
        char [][]arr=new char[N][M];
        for (int i=0;i<N;i++) {
            arr[i]=sc.nextLine().toCharArray();
        }
        System.out.println(findMin(arr,N,M));
    }
    private static int findMin(char [][]arr,int N,int M) {
        int count=0;
        boolean [][]v1=new boolean[N][M];
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (!v1[i][j]&&(arr[i][j]=='Y'||arr[i][j]=='G')) {
                    count++;
                    int x=i;
                    int y=j;
                    while (x<N&&y<M&&!v1[x][y]&&(arr[x][y]=='Y'||arr[x][y]=='G')) {
                        v1[x++][y++]=true;
                    }
                }
            }
        }
        boolean [][]v2=new boolean[N][M];
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (!v2[i][j]&&(arr[i][j]=='B'||arr[i][j]=='G')) {
                    count++;
                    int x=i;
                    int y=j;
                    while (x<N&&y>=0&&!v2[x][y]&&(arr[x][y]=='B'||arr[x][y]=='G')) {
                        v2[x++][y--]=true;
                    }
                }
            }
        }
        return count;
    }
}
