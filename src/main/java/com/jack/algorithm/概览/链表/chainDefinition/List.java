package com.jack.algorithm.概览.链表.chainDefinition;

public interface List {
    int size();
    boolean isEmpty();
    void insert(int index, Object obj) throws Exception;
    void delete(int index) throws Exception;
    Object get(int index) throws Exception;
}