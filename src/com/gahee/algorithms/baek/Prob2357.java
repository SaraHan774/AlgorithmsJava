package com.gahee.algorithms.baek;

import java.io.*;
import java.util.StringTokenizer;

public class Prob2357 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println("N : " + N + " M : " + M);

        StringTokenizer st2;
        int [] arr = new int[N + 1];
        arr[0] = -1;

        for (int i = 1; i < N + 1; i++) {
            st2 = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
            System.out.printf("arr[%d] : %d\n", i, arr[i]);
        }

        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.treeInit(1, 1, arr.length - 1);
        segmentTree.printTree();

        int a, b;
        for (int i = 0; i < M; i++) {
            st2 = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st2.nextToken());
            b = Integer.parseInt(st2.nextToken());

            // Not sure yet.
//            bw.write(segmentTree.findMin(a, b) + " ");
//            bw.write(segmentTree.findMax(a, b) + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

}

class SegmentTree{

    int [] arr;
    int [] tree;

    double treeHeight;
    double numOfNodes;

    SegmentTree(int [] arr){
        this.arr = arr;
        treeHeight = Math.ceil(Math.log(arr.length)/Math.log(2));

        for (int i = 0; i <= treeHeight; i++) {
            numOfNodes += Math.pow(2, i);
        }
//        System.out.println("Num of Nodes : " + numOfNodes);
        tree = new int[(int) Math.round(numOfNodes)];
    }

    public int treeInit(int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }

        int left = treeInit(node*2, start, (start  + end)/2);
        int right = treeInit(node*2 + 1, (start+end)/2 + 1, end);
        if(left > right){
            return tree[node] = left;
        }else{
            return tree[node] = right;
        }
    }

    public void printTree(){
        for (int i = 1; i < tree.length; i++) {
            System.out.printf("tree[%d] : %d\n", i, tree[i]);
        }
    }


    public int findMin(int a, int b){
        return 0;
    }

    //node 가 담당하는 구간이 start ~ end
    //구해야 하는 범위는 left ~ right (a, b)
    public int findMax(int node, int start, int end, int left, int right){

        return 0;
    }


}
