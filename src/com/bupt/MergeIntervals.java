package com.bupt;


import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        if(intervals == null || intervals.size() == 0)
            return ret;
        intervals.sort((x, y) -> x.start - y.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval: intervals) {
            if(interval.start <= end) {
                end = interval.end;
            } else {
                ret.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }


        return ret;
    }



}
