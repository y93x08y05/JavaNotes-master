package com.jack.nowcoder.spring.ArrowOffer;

import java.util.HashMap;

public class ReBuildBinaryTree {
    public static void main(String [] args) {
        int pre[] = {1,2,4,7,3,5,6,8};
        int between[] = {4,7,2,1,5,3,8,6};
        reBuildTree(pre,between);
    }
    static class TreeNode {
        TreeNode left;
        TreeNode right;

        public TreeNode(int i) {
        }
    }
    public static TreeNode reBuildTree(int pre[],int [] between) {
        if (pre == null || between == null) {
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<between.length;i++) {
            map.put(between[i],i);
        }
        return preIn(pre,0,pre.length-1,between,0,between.length-1);
    }
    public static TreeNode preIn(int [] pre,int pi,int pj,int []n,int ni,int nj) {
        if (pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pi]);
//        int index = map.get(pre[pi]);
//        head.left = preIn(pre,pi+1,pi+index-ni,n,ni,index-1);
//        head.right = preIn(pre,pi+index-ni+1,pj,n,index+1,nj);
        return head;
        }
    }