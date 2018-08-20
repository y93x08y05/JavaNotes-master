package com.jack.nowcoder.spring.A163.SpringJava0617;
import java.util.Vector;
public class P3 {
    int count = 21;
    public void count() {
        System.out.println(++count);
    }
    public static void main(String args[]) {
        new P3().count();
        new P3().count();
    }
}