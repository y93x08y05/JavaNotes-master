package com.jack.algorithm.概览.链表.chainTable;

import java.util.Stack;

/**
 * 两个栈实现队列
 * peek方法不改变栈顶的值，pop方法会把栈顶的值删除
 * peek方法和pop方法都会返回栈顶的值
 */
public class Test8 {
    public static Stack<Integer> stackPush = new Stack<>();
    public static Stack<Integer> stackPop  = new Stack<>();

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        for (int i=0;i<arr.length;i++) {
            add(arr[i]);
        }
        System.out.println(poll());
        while (!stackPop.empty()) {
            System.out.println(stackPop.pop());
        }
    }
    public static void add(int pushInt) {
        stackPush.add(pushInt);
    }
    public static int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is Empty");
        } else if (stackPop.empty()){
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    public static int peek(){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is Empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}