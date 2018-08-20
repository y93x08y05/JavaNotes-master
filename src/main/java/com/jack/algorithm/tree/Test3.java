package com.jack.algorithm.tree;

/**
 * 数组没有重复值，是二叉搜索树后序遍历的结果
 * 二叉树的后序遍历为左、右、根的顺序
 * 如果一个数组是二叉树后序遍历的结果，则头节点一定是数组的最后一个元素
 * 搜索二叉树的性质：
 * 比后序数组最后一个元素值小的数组会在数组的左边
 * 比后序数组最后一个元素值大的数组会在数组的右边
 * 左子树比根小，右子树比根大
 * 如果不满足这种情况，则不是二叉搜索树后序遍历的结果。
 * 数组划分为左边数组和右边数组，即二叉树分出了左右子树，则递归进行判断。
 */
public class Test3 {
    class Node {
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    public boolean isPostArray(int [] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return isPostOrder(array,0,array.length-1);
    }
    public boolean isPostOrder(int [] array,int start,int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i=start;i<end;i++) {
            if (array[end] > array[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPostOrder(array,start,end-1);
        }
        if (less != more-1) {
            return false;
        }
        return isPostOrder(array,start,less) && isPostOrder(array,more,end-1);
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int [] arr = {1,2,3,4,5,6,7};
        test3.isPostArray(arr);
    }
}