package com.bupt;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
*
[1,5,9,1,5,9]
k = 2
t = 3
false



Given an array of integers, find out whether there are two distinct indices i and j in the array such that
the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
* */

public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || t < 0)
            return false;
        Map<Long, Long> bucket = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            long mappedNumber = (long)nums[i] - Integer.MIN_VALUE;
            long index = mappedNumber / ((long)t + 1);
            if(bucket.containsKey(index) || (bucket.containsKey(index - 1) && mappedNumber - bucket.get(index - 1) <= t)
                    || (bucket.containsKey(index + 1) && bucket.get(index + 1) - mappedNumber <= t) )
                return true;
            bucket.put(index, mappedNumber);
            if(bucket.entrySet().size() > k) {
                bucket.remove(((long)nums[i - k] - Integer.MIN_VALUE)/ ((long)t + 1));
            }
        }
        return false;
    }

    @Test
    public void test() {
        boolean ret = containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3);
        System.out.println(ret);

    }
}


