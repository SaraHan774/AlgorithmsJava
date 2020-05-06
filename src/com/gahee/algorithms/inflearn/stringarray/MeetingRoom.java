package com.gahee.algorithms.inflearn.stringarray;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;

    Interval(){
        this.start = 0;
        this.end = 0;
    }

    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class MeetingRoom {

    public static void main(String[] args) {

        MeetingRoom meetingRoom = new MeetingRoom();
        Interval interval1 = new Interval(15, 20);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(0, 30);

        Interval [] intervals = {interval1, interval2, interval3};
        System.out.println(meetingRoom.solve(intervals));
    }

    public boolean solve(Interval [] intervals){
        // 배열로 받은 애를 null check 해준다.
        if(intervals == null){
            return false;
        }
        print(intervals);

        Arrays.sort(intervals, comparator);
        System.out.println("After sorting");
        print(intervals);

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1].end > intervals[i].start){
             //  끝나는 시간이 이후의 시작 시간보다 더 뒤에 있다면
                return false;
            }
        }
        // 끝나는 시간이 이후의 시작 시간보다 더 앞에 있다면
        return true;
    }

    public void print(Interval [] intervals){
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            System.out.println(interval.start + " " + interval.end);
        }
    }

    Comparator<Interval> comparator = Comparator.comparingInt(o -> o.start);
}
