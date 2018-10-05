package com.jack.leetcode;

import com.jack.util.ChainCreate;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/4 19:06
 * LeetCode 109
 * 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按照升序排序，将其转换为高度平衡的二叉搜索树
 * 一个高度平衡的二叉搜索树是指一个二叉树的每个节点的左右两个子树的高度差
 * 的绝对值不超过1
 * 例：
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：
 * [0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedListToBST {
    public static void main(String[] args) {
        int []arr={-10,-3,0,5,9};
        new SortedListToBST().find(new ChainCreate().create(arr));
    }
    public TreeNode find(ChainCreate.Node head) {
        if (head==null)
            return null;
        return find(head,null);
    }
    public TreeNode find(ChainCreate.Node head,ChainCreate.Node tail) {
        if (head==tail)
            return null;
        ChainCreate.Node fast=head;
        ChainCreate.Node slow=head;
        while (fast!=tail&&fast.next!=tail) {
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.data);
        root.left=find(head,slow);
        root.right=find(slow.next,tail);
        return root;
    }
}