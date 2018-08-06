package com.bupt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequent {

    @Test
    public void test() {
        int[] nums = {1,1,1,2,2,3};
        List<Integer> list = topKFrequentForInteger(nums, 2);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
    }



    public List<Integer> topKFrequentForInteger(int[] nums, int k) {

        List<Integer> ret = new ArrayList<>();
        ArrayList[] arry = new ArrayList[nums.length + 1];
        for(int i = 0; i < arry.length; i++) {
            arry[i] = new ArrayList();
        }
        Arrays.stream(nums)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.reducing(0, x -> 1, Integer::sum)
                        )
                )
                .entrySet()
                .stream()
                .forEach(x -> arry[x.getValue()].add(x.getKey()));
        for(int i = arry.length - 1; ret.size() < k; i--) {
            if(arry[i] != null)
                ret.addAll(arry[i]);
        }

        return ret;
    }

    public List<String> topKFrequentForString(String[] words, int k) {

        List<String> ret = new ArrayList<>();
        PriorityQueue[] bucket = new PriorityQueue[words.length + 1];
        for(int i = 0; i < bucket.length; i++) {
            bucket[i] = new PriorityQueue();
        }
        Arrays.asList(words)
                .stream()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.reducing(0, x -> 1, Integer::sum))
                )
                .entrySet()
                .stream()
                .forEach(x -> bucket[x.getValue()].add(x.getKey()));
        for(int i = bucket.length - 1; ret.size() < k; i--) {
            while(ret.size() < k && bucket[i].size() > 0) {
                ret.add((String)bucket[i].poll());
            }
        }
        return ret;

    }
}
