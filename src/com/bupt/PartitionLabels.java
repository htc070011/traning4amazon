package com.bupt;


import java.util.ArrayList;
import java.util.List;


public class PartitionLabels {


    /*
    *
    * We need an array last[char] -> index of S where char occurs last. Then, let anchor and j be the
    * start and end of the current partition. If we are at a label that occurs last at some index after j,
    * we'll extend the partition j = last[c]. If we are at the end of the partition (i == j) then we'll
    * append a partition size to our answer, and set the start of our new partition to i+1.
    *
    * */


    public List<Integer> partitionLabels(String S) {

        int[] last = new int[26];

        List<Integer> ret = new ArrayList<>();

        int len = S.length();

        for(int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int ptr = 0, start = 0;
        for(int i = 0; i < len; i++) {
            ptr = Math.max(last[i], ptr);
            if(ptr == i) {
                ret.add(ptr - start + 1);
                start = ptr + 1;
            }
        }
        return ret;
    }

}
