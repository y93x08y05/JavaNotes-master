package com.jack.nowcoder.autumn.xiaomi;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/27 13:56
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<List<Integer>> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            String []str=sc.nextLine().split(" ");
            List<Integer> set=new ArrayList<>();
            for (int j=0;j<str.length;j++){
                set.add(Integer.parseInt(str[j]));
            }
            Collections.sort(set);
            list.add(set);
        }
        find(list);
    }
    private static void find(List<List<Integer>> list){
        if (list.size()==0||list==null){
            System.out.println(0);
            System.out.println(0);
        } else if (list.size()==1){
            System.out.println(1);
            Set<Integer> set=new HashSet<>();
            for (int i=0;i<list.get(0).size();i++){
                set.add(list.get(0).get(i));
            }
            System.out.println(set.size());
        } else {
            List<List<Integer>> res=new ArrayList<>();
            res.add(list.get(0));
            for (int i=1;i<list.size();i++){
                boolean flag=false;
                for (int j=0;j<res.size();j++){
                    if (list.get(i).get(0)<=
                            res.get(j).get(res.get(j).size()-1)){
                        res.get(j).addAll(list.get(i));
                        Collections.sort(res.get(j));
                        flag=true;
                        continue;
                    }
                }
                if (!flag){
                    res.add(list.get(i));
                }
            }
            List<Set<Integer>> setList=new ArrayList<>();
            for (int i=0;i<res.size();i++){
                Set<Integer> set=new HashSet<>();
                for (int j=0;j<res.get(i).size();j++){
                    set.add(res.get(i).get(j));
                }
                setList.add(set);
            }
            System.out.println(setList.size());
            int most=0;
            for (int i=0;i<setList.size();i++){
                if (setList.get(i).size()>most){
                    most=setList.get(i).size();
                }
            }
            System.out.println(most);
        }
    }
}