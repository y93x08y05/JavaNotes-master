package com.jack.algorithm.classicAlgorithm;

/**
 * 数组加水的问题，数组代表柱子高度，求能围住的最大水量
 */
public class ArrayAddWater {
    public static void main(String [] args){
        int a [] = {5,2,3,6,4};
        System.out.println(getWater1(a));
        System.out.println(getWater2(a));
        System.out.println(getWater3(a));
    }
    /**
     * 从左到右遍历每根柱子，遍历时求出每根柱子左边最高右边最高的值
     * 利用两者之间最小值减去柱子高度，然后依次累加即为总水量
     * 时间复杂度O(n^2)，空间复杂度O(1)
     */
    public static int getWater1(int a []){
        int water = 0;
        if (a == null || a.length <= 1){
            return 0;
        }
        int leftLargest ;
        int rightLargest ;
        for (int i=0;i<a.length;i++){
            leftLargest = 0;
            rightLargest = 0;
            for (int j=0;j<i;j++){
                leftLargest = Math.max(leftLargest,a[j]);
            }
            for (int j=a.length-1;j>i;j--){
                rightLargest = Math.max(rightLargest,a[j]);
            }
            water+=Math.min(leftLargest,rightLargest)>a[i] ? Math.min(leftLargest,rightLargest)-a[i] : 0;
        }
        return water;
    }
    /**
     * 利用左数组存储每个元素左边最大值
     * 利用右数组存储每个元素右边最大值
     * 最后一次遍历求出每个元素的注水量
     * 利用空间换时间降低算法时间复杂度至O(n)，空间复杂度也为O(n)
     * @param a
     * @return
     */
    public static int getWater2(int a []){
        int water = 0;
        if (a == null || a.length <= 1){
            return 0;
        }
        int leftLargest = 0;
        int rightLargest  = 0;
        int left [] = new int [a.length];
        int right [] = new int[a.length];
        for (int i=0;i<a.length;i++){
            leftLargest = Math.max(leftLargest,a[i]);
            left[i] = leftLargest;
        }
        for (int i=a.length-1;i>=0;i--){
            rightLargest = Math.max(rightLargest,a[i]);
            right[i] = rightLargest;
        }
        for (int i=0;i<a.length;i++) {
            water += Math.min(left[i], right[i]) > a[i] ? Math.min(left[i], right[i]) - a[i] : 0;
        }
        return water;
    }

    /**
     * 时间复杂度为O(n),且空间复杂度为O(1)
     * left和right为左右移动的指针，保证左右最大值为当前元素左右最大值
     * @param a
     * @return
     */
    public static int getWater3(int a []){
        int water = 0;
        if (a == null || a.length <= 1){
            return 0;
        }
        int leftLargest = 0;
        int rightLargest = 0;
        int left = 0;
        int right = a.length-1;
        while (left < right) {
            leftLargest = Math.max(a[left],leftLargest);
            rightLargest = Math.max(a[right],rightLargest);
            if (leftLargest > rightLargest) {
                water += rightLargest - a[right--];
            } else {
                water += leftLargest - a[left++];
            }
        }
        return water;
    }
}