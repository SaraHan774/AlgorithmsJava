package com.gahee.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseList {

    //n개의 원소를 가지는 단순 연결 리스트를 역순으로 바꾸는 수행시간 O(n) 짜리 비재귀 프로시저를 제시하라.
    private List<ListNode> listNodes = new ArrayList<>();

    public ReverseList(List<ListNode> listNodes){
        this.listNodes = listNodes;
    }


}

class ListNode{
    ListNode nextNode;
    int data;
}
