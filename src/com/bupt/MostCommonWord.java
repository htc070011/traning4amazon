package com.bupt;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MostCommonWord {

    @Test
    public void test() {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";

//        String word = mostCommonWord(s, new String[]{"hit"});
//        String word = mostCommonWordByStream(s, new String[]{"hit"});
        String a = "a.";
        String[] str = a.replaceAll("\\pP", "").split(" ");

//        System.out.println(word);
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


    public String mostCommonWordByStream(String paragraph, String[] banned) {

        Set<String> set = new HashSet<>(Arrays.asList(banned));
        return Arrays.asList(
                paragraph.replaceAll("\\pP", "")
                        .toLowerCase()
                        .split(" "))
                .stream()
                .filter(x -> !set.contains(x))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.maxBy(Map.Entry.comparingByValue())).get().getKey();
    }

}
