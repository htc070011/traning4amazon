package com.bupt;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> table = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        int m = s.length(), n = p.length();
        int count = n;

        for(int i = 0; i < n; i++) {
            char ch = p.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }

        int start = 0, end = 0;
        while(end < m) {
            char ch = s.charAt(end);
            if(table.containsKey(ch)) {
                table.put(ch, table.get(ch) + 1);
                count--;
            }
        }
        return null;
    }


}
