package com.bupt;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class FindAnagrams {

    @Test
    public void test() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println("has done");
    }

    public List<Integer> findAnagrams(String s, String p) {

        int[] table = new int[26];
        List<Integer> ret = new ArrayList<>();
        int m = s.length(), n = p.length();
        int count = n;
        for(int i = 0; i < n; i++) {
            char ch = p.charAt(i);
            table[ch - 'a']++;
        }

        int start = 0, end = 0;
        while(end < m) {
            if(table[s.charAt(end++) - 'a']-- > 0) count--;
            if(count == 0) ret.add(start);
            if(end - start >= n && table[s.charAt(start++) - 'a']++ >= 0) count++;
        }
        return ret;
    }


}
