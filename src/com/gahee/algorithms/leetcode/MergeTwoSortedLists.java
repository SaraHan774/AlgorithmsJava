package com.gahee.algorithms.leetcode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {

    ListNode listNode = null;
    ListNode head = null;


    //하나의 리스트에 담는 방법 ...
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        head = new ListNode(0);
        listNode = head;

        ListNode p1 = l1; //들어온 헤드를 저장해야 한다.
        ListNode p2 = l2;

        while(p1 != null && p2 != null){
            System.out.println(p1.val + ", " + p2.val);
            if(p1.val < p2.val){
                listNode.next = p1;
                p1 = p1.next;
            }else{
                listNode.next = p2;
                p2 = p2.next;
            }
            listNode = listNode.next;
        }
        if(p1 != null){
            System.out.println("p1 != null");
            listNode.next = p1; //p1, p1.next ... 다 연결되는 것과 마찬가지
            //어차피 연결이 다 되어있으므로 한꺼번에 가져다 붙이는 것.
        }
        if(p2 != null){
            System.out.println("p2 != null");
            listNode.next = p2;
        }

        return head.next;
    }

}

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(30);
        l1.next.next = new ListNode(40);
        l1.next.next.next = new ListNode(60);
        l1.next.next.next.next = new ListNode(100);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);

        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(l1, l2);

        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
