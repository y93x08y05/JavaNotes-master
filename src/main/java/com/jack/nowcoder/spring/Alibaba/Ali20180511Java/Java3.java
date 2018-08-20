package com.jack.nowcoder.spring.Alibaba.Ali20180511Java;

import java.util.ArrayList;
import java.util.HashMap;
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
public class Java3 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pair> list = new ArrayList<Pair>();
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            int m = Integer.parseInt(sc.nextLine());
            String [] str = new String[m];
            for (int i=0;i<m;i++){
                str[i] = sc.nextLine();
                String [] temp = str[i].split(",");
                list.add(new Pair(temp[0],temp[1]));
            }
            for (int i=0;i<n;i+=2){
                list.add(new Pair(""+(i+1),""+(i+2)));
            }
            HashMap<String,Boolean> map = new HashMap<String,Boolean>();
            for (int i=0;i<list.size();i++){
                if (!map.containsKey(list.get(i).s1)
                        && !map.containsKey(list.get(i).s2)){
                    map.put(list.get(i).s1,true);
                    map.put(list.get(i).s2,false);
                    if (Integer.parseInt(list.get(i).s1)%2==1){
                        map.put(""+(Integer.parseInt(list.get(i).s1)+1),false);
                    }else {
                        map.put(""+(Integer.parseInt(list.get(i).s1)-1),false);
                    }
                    if (Integer.parseInt(list.get(i).s2)%2==1){
                        map.put(""+(Integer.parseInt(list.get(i).s2)+1),true);
                    }else {
                        map.put(""+(Integer.parseInt(list.get(i).s2)-1),true);
                    }
                }else if (map.containsKey(list.get(i).s1)
                        && !map.containsKey(list.get(i).s2)){
                    boolean sta = map.get(list.get(i).s1);
                    map.put(list.get(i).s2,!sta);
                    if (Integer.parseInt(list.get(i).s1)%2==1){
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s1)+1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s1)+1)))==!sta){

                            }else{
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s1)+1),!sta);
                        }
                    }else{
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s1)-1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s1)-1)))==!sta){

                            }else {
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s1)+1),!sta);
                        }
                    }
                    if (Integer.parseInt(list.get(i).s2)%2==1){
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s2)+1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s2)+1)))==sta){

                            }else{
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s1)+1),sta);
                        }
                    }else{
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s2)-1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s2)-1)))==sta){

                            }else {
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s1)+1),!sta);
                        }
                    }
                }else if (map.containsKey(list.get(i).s2)
                        && !map.containsKey(list.get(i).s1)){
                    boolean sta = map.get(list.get(i).s2);
                    map.put(list.get(i).s1,!sta);
                    if (Integer.parseInt(list.get(i).s2)%2==1){
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s2)+1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s2)+1)))==!sta){

                            }else{
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s2)+1),!sta);
                        }
                    }else{
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s2)-1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s2)-1)))==!sta){

                            }else {
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s2)+1),!sta);
                        }
                    }
                    if (Integer.parseInt(list.get(i).s1)%2==1){
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s1)+1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s1)+1)))==sta){

                            }else{
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s1)+1),sta);
                        }
                    }else{
                        if (map.containsKey(""+(Integer.parseInt(list.get(i).s1)-1))){
                            if (map.get((""+(Integer.parseInt(list.get(i).s1)-1)))==sta){

                            }else {
                                System.out.println("no");
                                return;
                            }
                        }else {
                            map.put(""+(Integer.parseInt(list.get(i).s1)+1),sta);
                        }
                    }
                }else {
                    if (map.get(list.get(i).s1) != map.get(list.get(i).s2)){

                    }else{
                        System.out.println("no");
                        return;
                    }
                }
            }
            System.out.println("yes");
        }
    }
    public static class Pair{
        String s1;
        String s2;
        boolean status1;
        boolean status2 = !status1;
        public Pair(){

        }
        public Pair(String s1,String s2){
            this.s1 = s1;
            this.s2 = s2;
        }
        public void setStatus1(boolean status1){
            this.status1 = status1;
        }
        public Pair(String s1,String s2,boolean status1){
            this.s1 = s1;
            this.s2 = s2;
            this.status1 = status1;
        }
    }
}