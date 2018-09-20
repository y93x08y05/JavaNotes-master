package com.jack.util;

/**
 * @Author: Jack
 * @Date: 2018/9/20 14:14
 * 前缀树又称为字典树，单词查找树，是一种多路树形结构，是
 * 哈希树的变种，和hash效率差不多，是一种用于快速检索的多叉树结构
 * 其核心思想是以空间换时间，缺点是内存消耗大。
 * 典型应用是统计和排序大量的字符串
 * Trie的特性：
 * 1、根节点不包含字符，除根节点外的每一个子节点都包含一个字符
 * 2、从根节点到某一节点的路径上的字符连接起来，就是该节点对应的字符串
 * 3、每个节点的所有子节点包含的字符都不相同
 * 4、每条边对应一个字母，每个节点对应一个前缀，叶节点对应最长前缀。
 * 问题1
 * 一个文本文件，大约有一万行，每行一个词，要求统计出其中最频繁出现的前10个词，
 * 请给出思想，给出时间复杂度分析。
 * 用Trie树统计每个词出现的次数，时间复杂度是O(n*le)（le表示单词的平均长度）
 * 然后是找出出现最频繁的前10个词。也可以用堆来实现，时间复杂度是O(n*lg10)。
 * 总的时间复杂度，是O(n*le)与O(n*lg10)中较大的哪一个。
 */
public class Trie {
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode node=this.root;
        for (char c:word.toCharArray()) {
            if (node.children[c-'a']==null) {
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.item=word;
    }
    public boolean search(String word) {
        TrieNode node=this.root;
        for (char c:word.toCharArray()) {
            if (node.children[c-'a']==null) {
                return false;
            }
            node=node.children[c-'a'];
        }
        return node.item.equals(word);
    }
    public boolean startWith(String prefix) {
        TrieNode node=this.root;
        for (char c:prefix.toCharArray()) {
            if (node.children[c-'a']==null) {
                return false;
            }
            node=node.children[c-'a'];
        }
        return true;
    }
}
class TrieNode {
    TrieNode []children=new TrieNode[26];
    String item="";
    public TrieNode() {

    }
}