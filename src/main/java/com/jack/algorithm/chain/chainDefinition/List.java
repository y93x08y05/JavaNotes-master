package com.jack.algorithm.chain.chainDefinition;

public interface List {
    int size();
    boolean isEmpty();
    void insert(int index, Object obj) throws Exception;
    void delete(int index) throws Exception;
    Object get(int index) throws Exception;
}