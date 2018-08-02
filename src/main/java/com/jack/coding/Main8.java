package com.jack.coding;

/**
 * Created by Jack on 7/30/2018 8:53 PM
 *  2*1 rectangular to cover bigger rectangular
 *  use n 2*1 rectangular to cover a 2*n bigger rectangular
 *  how many method to cover this bigger rectangular
 */
public class Main8 {
    public static void main(String[] args) {
        int target = 4;
        System.out.println(cover(target));
    }
    public static int cover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return cover(target-1) + cover(target-2);
    }
}
