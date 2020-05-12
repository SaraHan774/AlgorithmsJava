package com.gahee.algorithms.baek;

import java.io.*;
import java.util.StringTokenizer;

public class P2357 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
//        System.out.println("N : " + N + " M : " + M);

        StringTokenizer st2;
        int [] arr = new int[N + 1];
        arr[0] = -1;

        for (int i = 1; i < N + 1; i++) {
            st2 = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
//            System.out.printf("arr[%d] : %d\n", i, arr[i]);
        }

        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.maxTreeInit(1, 1, arr.length - 1);
        segmentTree.minTreeInit(1, 1, arr.length - 1);
//        segmentTree.printTrees();

        int a, b;
        for (int i = 0; i < M; i++) {
            st2 = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st2.nextToken());
            b = Integer.parseInt(st2.nextToken());

            // Not sure yet.
            bw.write(segmentTree.findMin(1, 1, arr.length - 1, a, b) + " ");
            bw.write(segmentTree.findMax(1, 1, arr.length - 1, a, b) + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

}

class SegmentTree{

    int [] arr;
    int [] maxTree;
    int [] minTree;

    double treeHeight;
    double numOfNodes;

    SegmentTree(int [] arr){
        this.arr = arr;
        treeHeight = Math.ceil(Math.log(arr.length)/Math.log(2));

        for (int i = 0; i <= treeHeight; i++) {
            numOfNodes += Math.pow(2, i);
        }
//        System.out.println("Num of Nodes : " + numOfNodes);
        maxTree = new int[(int) Math.round(numOfNodes)];
        minTree = new int[(int) Math.round(numOfNodes)];
    }

    private int getMid(int start, int end){
        return (start + end)/2;
    }

    public int maxTreeInit(int node, int start, int end){
        if(start == end){
            return maxTree[node] = arr[start];
        }
        int left = maxTreeInit(node*2, start, (start  + end)/2);
        int right = maxTreeInit(node*2 + 1, (start+end)/2 + 1, end);
        if(left > right){
            return maxTree[node] = left;
        }else{
            return maxTree[node] = right;
        }
    }

    public int minTreeInit(int node, int start, int end){
        if(start == end){
            return minTree[node] = arr[start];
        }
        int left = minTreeInit(node*2, start, (start  + end)/2);
        int right = minTreeInit(node*2 + 1, (start+end)/2 + 1, end);
        if(left < right){
            return minTree[node] = left;
        }else{
            return minTree[node] = right;
        }
    }

/*    public void printTrees(){
        System.out.println("===Printing MAX TREE===");
        for (int i = 1; i < maxTree.length; i++) {
            System.out.printf("tree[%d] : %d\n", i, maxTree[i]);
        }
        System.out.println("===Printing MIN TREE===");
        for (int i = 1; i < minTree.length; i++) {
            System.out.printf("tree[%d] : %d\n", i, minTree[i]);
        }
    }*/


    public int findMin(int node, int start, int end, int left, int right){
//        System.out.printf("node : %d, left : %d, right : %d, start : %d, end : %d\n", node,left, right, start, end);
        //left 와 right 가 완전히 벗어나 있는 경우
        if(left > end || right < start){
            return Integer.MAX_VALUE;
        }
        //left 와 right 를 완전히 포함하는 경우
        if(left <= start && end <= right){
            return minTree[node];
        }
        int l = findMin(node*2, start, getMid(start, end), left, right);
        int r = findMin(node * 2 + 1, getMid(start, end) + 1, end, left, right);

        return Math.min(l, r);
    }

    //node 가 담당하는 구간이 start ~ end
    //구해야 하는 범위는 left ~ right (a, b)
    public int findMax(int node, int start, int end, int left, int right){
//        System.out.printf("node : %d, left : %d, right : %d, start : %d, end : %d\n", node,left, right, start, end);

        if(left > end || right < start){
            return Integer.MIN_VALUE;
        }
        if(left <= start && right >= end){
            return maxTree[node];
        }
        int l =  findMax(node*2, start, getMid(start, end), left, right);
        int r =  findMax(node * 2 + 1, getMid(start, end) + 1, end, left, right);

        return Math.max(l, r);
    }

}
