package com.gahee.algorithms.leetcode;

//2020-03-16

public class SameTree {

    //트리의 값들이 같은건지 재귀적으로 부모, 자식들을 비교하며 true, false 를 리턴한다.
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //and 를 먼저 걸어주는 것이 좋다.
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){val = x;}
}

