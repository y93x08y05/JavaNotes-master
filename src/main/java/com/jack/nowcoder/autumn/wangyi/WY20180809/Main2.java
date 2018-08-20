package com.jack.nowcoder.autumn.wangyi.WY20180809;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 8/11/2018 11:01 AM
 * 成员列表问题
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            int level = sc.nextInt();
            String name = sc.next();
            User user = new User(name,level,0);
            list.add(user);
        }
        int m = sc.nextInt();
        for (int i=0;i<m;i++) {
            String name = sc.next();
            int op = sc.nextInt();
            for (User user : list)
                if (user.name.equals(name))
                    user.state = op;
        }
        printGroup(list);
    }
    static class User {
        String name;
        int level;
        int state;
        public User(String name,int level,int state) {
            this.name = name;
            this.level = level;
            this.state = state;
        }
    }
    private static void printGroup(List<User> list) {
        list.sort((o1, o2) -> {
            if (o1.state > o2.state)
                return -1;
            else if (o1.state < o2.state)
                return 1;
            else {
                if (o1.level > o2.level)
                    return -1;
                else if (o1.level < o2.level)
                    return 1;
                else
                    return o1.name.compareTo(o2.name);
            }
        });
        for (User user : list)
            System.out.println(user.name);
    }
}
