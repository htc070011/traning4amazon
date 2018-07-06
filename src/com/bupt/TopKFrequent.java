package com.bupt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
//import static java.util.stream.Collectors.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequent {

    @Test
    public void test() {
        int[] nums = {1,1,1,2,2,3};
        List<Integer> list = topKFrequent(nums, 2);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
    }



    public List<Integer> topKFrequent(int[] nums, int k) {

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
}
