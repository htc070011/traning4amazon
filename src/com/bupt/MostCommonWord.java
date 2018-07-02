package com.bupt;

import org.junit.Test;

import java.util.*;


public class MostCommonWord {

    @Test
    public void test() {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";

        String word = mostCommonWord(s, new String[]{"hit"});

        System.out.println(word);
    }


    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> banSet = new HashSet<>(Arrays.asList(banned));

        String[] para = paragraph.replaceAll("\\pP", "").toLowerCase().split("\\s+");

        Map<String, Integer> map = new HashMap();
        for(String str: para) {
            if(!banSet.contains(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
