package com.jack.nowcoder.spring.Alibaba.Ali20180511Java;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 阿里巴巴客服管理员管理着n个服务小组，他需要为每一组安排客服24小时值班。
 * 为简单起见，假设每组只有2个客服，一天只需要1个客服上班，并且一些客服由于
 * 某些原因不能在同一天上班。
 * 已经对客服进行编号，第i(i>=1 && i<=n)个组的客服编号为2*i-1和2*i。并且
 * 知道了m种如下约束关系，客服编号a和客服编号b不能一起上班。
 * 管理员需要聪明的你帮忙判断今天是否存在可行的方案，既满足m条约束关系，
 * 又能让每个组都有1个客服上班。
 * 输入：n(代表有n个组)
 * m(m条约束关系)，接下来会有m行
 * a,b(代表a,b两位客服标号不能同时上班)
 * 输出：判断有没有可行方案，不可行输出no,可行输出yes
 * 典型的2-SAT模板题
 * 输入范例：
 * 4
 * 3
 * 1,4
 * 2,3
 * 7,3
 * 输出范例：yes
 * 输入范例：
 * 4
 * 6
 * 1,3
 * 1,4
 * 2,3
 * 5,7
 * 5,8
 * 6,2
 * 输出范例：no
 */
public class Java1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TwoSat t = new TwoSat();
        t.init(n);
        for (int i=0;i<m;i++){
            String s = sc.nextLine();
            String [] ss = s.split(",");
            int a = Integer.parseInt(ss[0])-1;
            int b = Integer.parseInt(ss[1])-1;
            t.add_diredge(a,b^1);
            t.add_diredge(b,a^1);
        }
        boolean k = t.solve();
        if (k){
            pw.println("yes");
        } else {
            pw.println("no");
        }
        pw.flush();
    }
}
class TwoSat{
    Edge[] edges;
    int [] s,dfn,low,stack,belong;
    int c;
    int n;
    boolean [] mark,instack;
    int [] head;
    int maxn = 2005;
    int maxm = 4000005;
    int [] to;
    int [] next;
    int cnt,bcount,dindex,top;
    TwoSat(){
        to = new int[maxm];
        next = new int[maxm];
        head = new int[maxn];
        s = new int[maxn];
        mark = new boolean[maxn];
        dfn = new int[maxn];
        low = new int[maxn];
        stack = new int[maxn];
        belong = new int[maxn];
        instack = new  boolean[maxn];
    }
    void init(int n_) {
        this.n = n_;
        cnt = 0;
        Arrays.fill(head,-1);
        Arrays.fill(mark,false);
        top = 0;
        bcount = 0;
        dindex = 0;
        Arrays.fill(dfn,0);
    }
    boolean solve() {
        for (int i=0;i<2*n;i++){
            if (dfn[i] == 0)
                tarjan(i);
        }
        for (int i=0;i<2*n;i=i+2){
            if (belong[i] == belong[i+1]) return false;
        }
        return true;
    }
    void add_diredge(int u,int v) {
        to[cnt] = v;
        next[cnt] = head[u];
        head[u] = cnt++;
    }
    void tarjan(int u){
        dfn[u] = low[u] = ++dindex;
        stack[++top] = u;
        instack[u] = true;
        for (int i=head[u];i!=-1;i=next[i]){
            int v = to[i];
            if (dfn[v] == 0){
                tarjan(v);
                low[u] = Math.min(low[u],low[v]);
            }else if (instack[v] && dfn[v] < low[u]){
                low[u] = dfn[v];
            }
        }
        if (dfn[u] == low[u]){
            bcount++;
            int v;
            do {
                v = stack[top--];
                instack[v] = false;
                belong[v] = bcount;
            }while (u != v);
        }
    }
}
class Edge{
    int to,next;
}