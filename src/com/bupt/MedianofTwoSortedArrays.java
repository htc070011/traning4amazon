package com.bupt;

import org.junit.Test;

public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int len = nums1.length + nums2.length;
        int l = 0, r = nums1.length;
        int l1 = 0, r1 = 0, l2 = 0, r2 = 0;
        double ret = 0;

        while(l <= r) {
            int mid = l + ((r - l) >> 1);
            l1 = mid == 0? Integer.MIN_VALUE: nums1[mid - 1];
            r1 = mid == nums1.length? Integer.MAX_VALUE: nums1[mid];
            l2 = len / 2 - mid == 0? Integer.MIN_VALUE: nums2[len / 2 - mid - 1];
            r2 = len / 2 - mid == nums2.length? Integer.MAX_VALUE: nums2[len / 2 - mid];
            if(l1 > r2) {
                r = mid - 1;
            } else if(l2 > r1) {
                l = mid + 1;
            } else {
                if(len % 2 == 0) {
                    ret = ((double)Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    ret = (double)Math.min(r1, r2);
                }
                break;
            }
        }

        return ret;
    }
    @Test
    public void test() {
        int[] arry1 = {1,2};
        int[] arry2 = {3,4};
        double ret = findMedianSortedArrays(arry1,arry2);
        System.out.println(ret);
    }
}
