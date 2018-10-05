package com.jack.leetcode;

import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 22:14
 * LeetCode 105
 * 从前序与后序遍历构造二叉树，假设树中没有重复的元素
 * 例：
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreePreInOrder {
    public static void main(String[] args) {
        int []preOrder={3,9,20,15,7};
        int []inOrder={9,3,15,20,7};
        new BuildTreePreInOrder().find(preOrder,inOrder);
    }
    public TreeNode find(int []preOrder,int []inOrder) {
        return find(preOrder,inOrder,0,0,inOrder.length-1);
    }
    public TreeNode find(int []pre,int []in,int preStart,int inStart,int inEnd) {
        if (preStart>pre.length-1||inStart>inEnd)
            return null;
        TreeNode root=new TreeNode(pre[preStart]);
        int index=0;
        for (int i=inStart;i<=inEnd;i++) {
            if (root.val==in[i]) {
                index=i;
                break;
            }
        }
        root.left=find(pre,in,preStart+1,inStart,index-1);
        root.right=find(pre,in,preStart+index-inStart+1,index+1,inEnd);
        return root;
    }
}