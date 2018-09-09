package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/26/2018 9:32 PM
 * LeetCode 690
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。
 * 那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，
 * 员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，
 * 但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。
 * 因此员工1的总重要度是 5 + 3 + 3 = 11。
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 */
public class ImportanceEmployee {
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<>();
        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        List<Integer> list3= new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list.add(new Employee(1,5,list1));
        list.add(new Employee(2,3,list2));
        list.add(new Employee(3,3,list3));
        int id=1;
        System.out.println(getImportance0(list, id));
        System.out.println(getImportance1(list, id));
        System.out.println(getImportance2(list, id));
        System.out.println(getImportance3(list, id));
    }
    //suitable id has sorted
    private static int getImportance0(List<Employee> employees,int id) {
        Employee leader=employees.get(id-1);
        int importance=leader.importance;
        List<Integer> subordinates=leader.subordinates;
        for (Integer i:subordinates) {
            importance+=getImportance0(employees,i);
        }
        return importance;
    }
    //suitable id not mergeSort
    private static int getImportance1(List<Employee> employees,int id) {
        int importance=0;
        List<Integer> subordinates;
        for (Employee e:employees) {
            if (e.id==id) {
                importance=e.importance;
                subordinates=e.subordinates;
                for (Integer i:subordinates)
                    importance+=getImportance1(employees,i);
                break;
            }
        }
        return importance;
    }
    private static int getImportance2(List<Employee> employees,int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for (int i=0;i<employees.size();i++) {
            map.put(employees.get(i).id,employees.get(i));
        }
        Queue<Employee> queue=new LinkedList<>();
        queue.offer(map.get(id));
        int importance=0;
        while (!queue.isEmpty()) {
            Employee leader=queue.poll();
            importance+=leader.importance;
            List<Integer> subordinates=leader.subordinates;
            for (Integer i:subordinates) {
                queue.offer(map.get(i));
            }
        }
        return importance;
    }
    private static int getImportance3(List<Employee> employees,int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for (int i=0;i<employees.size();i++) {
            map.put(employees.get(i).id,employees.get(i));
        }
        return getSubImportance(map,id);
    }
    public static int getSubImportance(Map<Integer,Employee> map,int i) {
        Employee leader=map.get(i);
        int importance=leader.importance;
        List<Integer> subordinates=leader.subordinates;
        for (Integer k:subordinates) {
            importance+=getSubImportance(map,k);
        }
        return importance;

    }
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        Employee(int id,int importance,List<Integer> subordinates) {
            this.id=id;
            this.importance=importance;
            this.subordinates=subordinates;
        }
    }
}
