package com.jack.train.AIQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/9/15 8:58
 * 爱奇艺2018秋季校招Java工程师第一场-选择题
 */
public class AiQ {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student(10));
        list.add(new Student(18));
        list.add(new Student(15));
        Collections.sort(list);
        System.out.println(list.get(1).age);
    }
}
class Student implements Comparable<Student> {
    Integer age;
    public Student(Integer age) {
        this.age=age;
    }
    @Override
    public int compareTo(Student o) {
        return o.age.compareTo(this.age);
    }
}