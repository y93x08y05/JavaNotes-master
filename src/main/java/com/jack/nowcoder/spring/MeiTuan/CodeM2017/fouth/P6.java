package com.jack.nowcoder.spring.MeiTuan.CodeM2017.fouth;

import java.util.Scanner;

/**
 * 美团旅行团队最近打算退出一项新服务，为景区的各个景点规划
 * 游览路线，提升游客满意度。其中一个重要的问题是对于一个景区
 * 道路网，求出游客的满意度的期望值。基于游客的喜好差异，我们
 * 需要对男性游客和女性游客的满意度分别计算，景区被描述成一张
 * n个点，m条边的无向图（无重边，无自环），每个点代表一个景区，
 * 第i个景点游览时间耗费ci分钟，会让男性游客和女性游客的满意度
 * 分别增加h1i和h2i（满意度初始值都为0），每条边代表一条路，第i
 * 条边连接编号为xi，yi的两个景点，从景点xi走到yi和从yi走到xi的
 * 时间都是ti分钟。
 * 每个游客在景区中最长可以游览k分钟，最开始会随机的通过不同大门
 * 进入到一个景区开始游览，每游览完一个项目，游客会等概率随机选择
 * 一个可以从当前景点直接到达且来得及游览的景点作为下一个游览目标
 * （已经游览过的景点也会因为有各种新活动而让游客再次考虑，所有这里
 * 不区分景区是否已经游览过），如果游览完一个景点后，周围没有来得及
 * 游览的景点，本次游玩就结束了。
 * 分别计算小y和妹子在游玩结束后开心度的期望。
 * 输入描述：
 * 第一行给出三个空格隔开的整数，分别表示n，m，k
 * (0 < n ≤ 100, 1 * 60 ≤ k ≤ 8 * 60)
 * 接下来的n行，每行三个空格隔开的整数，
 * 分别表示ci, h1i, h2i (10 ≤ ci ≤ 60，0 < h1i, h2i ≤ 100)
 * 接下来的m行，每行三个空格隔开的整数，
 * 分别表示xi, yi, ti (0 < ti ≤ 15)
 * 输出描述：
 * 两个用空格隔开的实数，分别表示小y和妹子开心度的期望，精确到
 * 小数点后5位。
 * 输入
 * 5 4 60
 * 25 12 83
 * 30 38 90
 * 16 13 70
 * 22 15 63
 * 50 72 18
 * 2 1 7
 * 3 1 7
 * 4 3 1
 * 5 3 10
 * 输出
 * 39.20000 114.40000
 */
public class P6 {
    public static int n;
    public static int m;
    public static int t;
    public static int [] c = new int[105];
    public static int [] h1 = new int[105];
    public static int [] h2 = new int[105];
    public static int [] s = new int[105];
    public static int [] nt = new int[20009];
    public static int [] e = new int[20009];
    public static int [] w = new int[20009];
    public static double [][] dp = new double[105][60*8+5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int [][] arr2 = new int[m][3];
        for (int i=0;i<n;i++) {
            c[i] = sc.nextInt();
            h1[i] = sc.nextInt();
            h2[i] = sc.nextInt();
        }
        int cnt = 1;
        for (int i=1;i<m;i++) {
            arr2[i-1][0] = sc.nextInt();
            arr2[i-1][1] = sc.nextInt();
            arr2[i-1][2] = sc.nextInt();
            nt[cnt] = s[arr2[i-1][0]];
            s[sc.nextInt()] = cnt;
            e[cnt] = arr2[i-1][1];
            w[cnt++] = arr2[i-1][2];
            nt[cnt]=s[arr2[i-1][0]];
            s[arr2[i-1][0]]=cnt;
            e[cnt]=arr2[i-1][1];
            w[cnt++]=arr2[i-1][2];
        }
        System.out.print(String.format("%.5f",f(h1)));
        System.out.print(" ");
        System.out.print(String.format("%.5f",f(h1)));
    }
    public static double f(int h[]) {
        double ans=0;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=t; j++) {
                dp[i][j]=0;
            }
        }
        for(int i=1; i<=n; i++) {
            dp[i][c[i]]=1.0/n;
        }
        for(int i=0; i<=t; i++) {
            for(int j=1; j<=n; j++) {
                ans+=dp[j][i]*h[j];
            }
            for(int j=1; j<=n; j++) {
                int sum=0;
                for(int k=s[j];~k>0; k=nt[k]) {
                    if(t-i>=w[k]+c[e[k]]) {
                        sum++;
                    }
                }
                if(sum==0) {
                    continue;
                }
                for(int k=s[j];~k>0; k=nt[k]) {
                    if(t-i>=w[k]+c[e[k]]) {
                        dp[e[k]][i+w[k]+c[e[k]]]+=dp[j][i]/sum;
                    }
                }
            }
        }
        return ans;
    }
}