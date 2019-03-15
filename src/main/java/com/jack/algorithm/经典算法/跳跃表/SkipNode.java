package com.jack.algorithm.经典算法.跳跃表;

/**
 * @Author: Jack
 * @Date: 2019/2/28 16:47
 */
public class SkipNode<E> {
    E val;
    double score;
    SkipNode<E> next, down;
    SkipNode() {

    }
    SkipNode(E val, double score) {
        this.val = val;
        this.score = score;
    }
}