package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/30 20:53
 * LeetCode 337
 * 打家劫舍3
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 例1:
 * 输入: [3,2,3,null,3,null,1]
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 例2:
 * 输入: [3,4,5,1,3,null,1]
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class Rob3 {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        System.out.println(new Rob3().find(node));
    }
    public int find(TreeNode root) {
        int []res=findSub(root);
        return Math.max(res[0],res[1]);
    }
    public int [] findSub(TreeNode root) {
        if (root==null)
            return new int[2];
        int []left=findSub(root.left);
        int []right=findSub(root.right);
        int []res=new int[2];
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=root.val+left[0]+right[0];
        return res;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val=val;
        }
    }
}