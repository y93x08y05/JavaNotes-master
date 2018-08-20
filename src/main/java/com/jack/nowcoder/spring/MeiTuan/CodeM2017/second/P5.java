package com.jack.nowcoder.spring.MeiTuan.CodeM2017.second;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 围棋是起源于中国有悠久历史的策略性棋类游戏，规则如下：
 * （1）棋盘19*19
 * （2）棋子分黑白两色，双方各执一色
 * （3）下法：每次黑或白着一子与棋盘的空点上，棋子下定后，不再向其他点移动
 * （4）棋子的气：一个棋子在棋盘上，与它相邻的空点是这个棋子的气，相邻是指
 * 两个点有公共边，相邻的点、上如果有同色棋子存在，这些棋子就相互连接成一个
 * 不可分割的整体，气合并计算。相邻的点上如果有异色棋子存在，此处气便不存在。
 * （5）提子，把无气之子清理出棋盘的手段叫做“提子”，提子有两种：
 * 着子后，对方棋子无气，应立即提取对方无气之子；
 * 着子后，双方棋子都是无气状态，应立即提取对方无气之子。
 * （6）禁着点：棋盘上的任何一空点，如果某方在此下子，会使该子立即呈现
 * 无气状态，同时又不能提取对方的棋子。
 * （7）禁止全局同形，无论哪一方，在成功进行了着子，提子操作后，棋盘局面
 * 不能和任何之前的局面相同。
 * 输入一些操作，从空棋盘开始模拟这些操作，
 * 对于每一步，若结果不正确，则输出对应的miss并且忽略这个操作，并在最后
 * 输出棋盘的局面。
 * 输入描述：
 * 第一行，测试数据数组<=100
 * 第二行，每组测试数据，执行的步数n<=2000
 * 然后n行
 * B x y
 * W x y
 * 其中二元组x，y表示围棋棋盘上第x行第y列对应的点
 * 输入数据保证是黑白轮流下的。
 * 输出描述：
 * 多行
 * 对于miss的情况，输出是那种错误格式，其中：
 * miss 1表示下的位置已经有棋了
 * miss 2表示违反规则6
 * miss 3表示违反规则7
 * 对于正常的操作，不用输出。
 * 最后输出最终棋盘，B表示黑子，W表示白子，空的输出“.”字符
 * 输入：
 * 1
 * 12
 * B 1 3
 * W 1 2
 * B 2 4
 * W 2 1
 * B 1 1
 * W 2 3
 * B 3 3
 * W 3 2
 * B 1 1
 * W 2 3
 * B 2 2
 * W 2 3
 * 输出
 * miss 2
 * miss 2
 * miss 1
 * miss 3
 * .WB................
 * WB.B...............
 * .WB................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 * ...................
 *
 * */
public class P5 {
    public static int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};//判断是否被周围棋子环绕
    public static int goNum = 19;
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//一共有多少组
        while (n-- > 0) {
            int num = scanner.nextInt();//一组一共走了多少步
            char [][] go = new char[goNum][goNum];//代表棋盘的每一个点
            //给每一个点赋初始值.表示此处没有棋子
            for (int i=0;i<go.length;i++) {
                for (int j=0;j<go.length;j++) {
                    go[i][j] = '.';
                }
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            check(go,arrayList);
            while (num-- > 0) {
                String op = scanner.next();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                x -= 1;//下的位置放到数组中减一为下标值
                y -= 1;//下的位置放到数组中减一为下标值
                char a = op.charAt(0);
                char b = a == 'B'?'W':'B';//判断是黑子还是白子
                if (go[x][y] != '.') {//如果下的位置不为.则表示该位置已经有棋子了
                    System.out.println("miss 1");
                } else {
                    char [][]nextGo = new char[goNum][goNum];//新建棋盘
                    copy(nextGo,go);//拷贝一份初始棋盘
                    nextGo[x][y] = a;//将所下棋子赋值到对应位置
                    int [][] via = new int[goNum][goNum];//新建棋盘，初始值为0
                    boolean isOk = dfs(x,y,a,via,nextGo);
                    for (int i=0;i<dir.length;i++) {
                        int tx = x + dir[i][0];
                        int ty = y + dir[i][1];
                        if (tx>=0 && tx<goNum && ty>=0 && ty<goNum &&
                                via[tx][ty] == 0 && nextGo[tx][ty] == b &&
                                !dfs(tx,ty,b,via,nextGo)) {
                            //判断满足条件的点，四周有空的点，并且
                            pick(tx,ty,b,nextGo);
                            isOk = true;
                        }
                    }
                    //对isOK做两次判断
                    if (isOk) {
                        //之前的局面都会保存下来，之后的与之前的进行比较
                        //如果与之前的局面相同，则输出false。否则为true
                        if (check(nextGo,arrayList)) {
                            copy(go,nextGo);
                        } else {
                            System.out.println("miss 3");
                        }
                    } else {
                        System.out.println("miss 2");
                    }
                }
            }
            //打印最终的输出结果
            for (int i=0;i<goNum;i++) {
                for (int j=0;j<goNum;j++) {
                    System.out.print(go[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static boolean check(char [][]next, ArrayList<Long> arrayList) {
        long has1 = 0;
        for (int i=0;i<goNum;i++) {
            for (int j=0;j<goNum;j++) {
                has1 = has1*131+next[i][j];//char类型的.转为long，值是46
            }
        }
        if (arrayList.contains(has1)) {
            return false;
        }
        arrayList.add(has1);
        return true;
    }
    public static void copy(char [][]next,char [][]go) {
        for (int i=0;i<goNum;i++) {
            for (int j=0;j<goNum;j++) {
                next[i][j] = go[i][j];
            }
        }
    }
    public static boolean dfs(int x, int y, char op, int [][]via,char [][]next) {
        //检查某点是否被不同的点所围绕
        if (next[x][y] == '.') return true;
        if (next[x][y] != op) return false;
        via[x][y] = 1;//说明x、y的点是op
        boolean isOK = false;
        for (int i=0;i<dir.length;i++) {
            //依次判断左、下、右、上四个位置
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (tx>=0 && tx<goNum && ty>=0 && ty<goNum && via[tx][ty] == 0) {
                //判断四个点只要有一个点是空着的，用或语句判断就输出true
                isOK |= dfs(tx,ty,op,via,next);
            }
        }
        return isOK;
    }
    public static void pick(int x, int y, char op, char [][]next) {
        next[x][y] = '.';
        for (int i=0;i<dir.length;i++) {
            int tx = x+dir[i][0];
            int ty = y+dir[i][1];
            if (tx>=0 && tx<goNum && ty>=0 && ty<goNum &&
                    next[tx][ty] == op) {
                //递归四个点，无返回值
                pick(tx,ty,op,next);
            }
        }
    }
}