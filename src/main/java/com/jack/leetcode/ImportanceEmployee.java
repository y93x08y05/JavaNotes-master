package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/26/2018 9:32 PM
 * LeetCode 690
 * find Importance of Employee
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
