package com.jack.algorithm.经典算法.跳跃表;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: Jack
 * @Date: 2019/2/28 16:39
 */
public class SkipList<T> {
    public static void main(String[] args) {
        SkipList<String> list = new SkipList<>();
        list.put(1.0, "1.0");
        System.out.println(list);
        list.put(2.0, "2.0");
        System.out.println(list);
        list.put(3.0, "3.0");
        System.out.println(list);
        list.put(4.0, "4.0");
        System.out.println(list);
        list.put(4.0, "5.0");
        System.out.println(list);
        list.delete(3.0);
        list.delete(3.5);
        System.out.println(list);
        System.out.println("查找4.0" + list.get(4.0));
    }
    private static class SkipNode<E> {
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
    private static final int MAX_LEVEL = 1 << 6;
    private SkipNode<T> top;
    private int level = 0;
    private Random random = new Random();
    public SkipList() {
        this(4);
    }
    public SkipList(int level) {
        this.level = level;
        int i = level;
        SkipNode<T> temp = null;
        SkipNode<T> prev = null;
        while (i-- != 0) {
            temp = new SkipNode<T>(null, Double.MIN_VALUE);
            temp.down = prev;
            prev = temp;
        }
        top = temp;
    }
    private int getRandomLevel() {
        int lev = 1;
        while (random.nextInt() % 2 == 0)
            lev++;
        return lev > MAX_LEVEL ? MAX_LEVEL : lev;
    }
    public T get(double score) {
        SkipNode<T> t = top;
        while (t != null) {
            if (t.score == score)
                return t.val;
            if (t.next == null) {
                if (t.down != null) {
                    t  = t.down;
                    continue;
                } else
                    return null;
            }
            if (t.next.score > score) {
                t = t.down;
            } else
                t = t.next;
        }
        return null;
    }
    public void put(double score, T val) {
        SkipNode<T> t = top, cur = null;
        List<SkipNode<T>> path = new ArrayList<>();
        while (t != null) {
            if (t.score == score) {
                cur = t;
                break;
            }
            if (t.next == null) {
                path.add(t);
                if (t.down != null) {
                    t = t.down;
                    continue;
                } else {
                    break;
                }
            }
            if (t.next.score > score) {
                path.add(t);
                if (t.down == null) {
                    break;
                }
                t = t.down;
            } else {
                t = t.next;
            }
        }
        if (cur != null) {
            while (cur != null) {
                cur.val = val;
                cur = cur.down;
            }
        } else {
            int lev = getRandomLevel();
            if (lev > level) {
                SkipNode<T> temp = null;
                SkipNode<T> prev = top;
                while (level++ != lev) {
                    temp = new SkipNode<T>(null, Double.MIN_VALUE);
                    path.add(0, temp);
                    temp.down = prev;
                    prev = temp;
                }
                top = temp;
                level = lev;
            }
            SkipNode<T> downTemp = null, temp = null, prev = null;
            for (int i = level - 1; i >= level - lev; i--) {
                temp = new SkipNode<T>(val, score);
                prev = path.get(i);
                temp.next = prev.next;
                prev.next = temp;
                temp.down = downTemp;
                downTemp = temp;
            }
        }
    }
    public void delete(double score) {
        SkipNode<T> t = top;
        while (t != null) {
            if (t.next == null) {
                t = t.down;
                continue;
            }
            if (t.next.score == score) {
                t.next = t.next.next;
                t = t.down;
                continue;
            }
            if (t.next.score > score)
                t = t.down;
            else
                t = t.next;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SkipNode<T> t = top, next = null;
        while (t != null) {
            next = t;
            while (next != null) {
                sb.append(next.score + " ");
                next = next.next;
            }
            sb.append("\n");
            t = t.down;
        }
        return sb.toString();
    }
}