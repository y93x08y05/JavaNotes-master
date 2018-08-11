package com.jack.arrowOffer;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Jack on 7/30/2018 10:15 PM
 * min function to get stack most min element
 */
public class Main14 {
    private static Stack<Integer> stack = new Stack<Integer>();
    private static void push(int node) {
        stack.push(node);
    }
    private static void pop() {
        stack.pop();
    }
    private static int top() {
        return stack.peek();
    }
    public static void main(String[] args) {
        push(1);
        push(3);
        push(2);
        System.out.println(min());
    }
    public static int min() {
        int min = top();
        int temp;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}
