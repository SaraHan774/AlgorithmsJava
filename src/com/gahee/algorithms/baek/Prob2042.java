package com.gahee.algorithms.baek;


import java.io.IOException;
import java.util.ArrayList;

public class Prob2042 {

    public static void main(String[] args) throws IOException {
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//        int N = Integer.parseInt(stringTokenizer.nextToken());
//        int M = Integer.parseInt(stringTokenizer.nextToken());
//        int K = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);

        FenwickTree fenwickTree = new FenwickTree(arrayList);
        int [] tree;
        if(fenwickTree.treeInit()){
            tree = fenwickTree.getTree();
        }
        fenwickTree.printTree();

        fenwickTree.treeUpdate(3, 1);

        fenwickTree.printTree();

        int result = fenwickTree.getTreeSum(6);
        System.out.println("sum result : " + result);

    }
}


class FenwickTree{

    private ArrayList<Integer> numbersList;
    private int [] tree;

    public FenwickTree(ArrayList<Integer> numbers){
        numbersList = numbers;
        tree = new int[numbersList.size() + 1];
    }

    public int[] getTree() {
        return tree;
    }

    public int getLastOneBit(int x){
        return x & -x;
    }

    public boolean treeInit(){
        if(numbersList == null){
            return false;
        }

        tree[0] = -1;

        for(int i = 1; i <= numbersList.size(); i++){
            int one = getLastOneBit(i);
            System.out.printf("A[%d] : %d\n", i, one);
            int node = 0;
            while(one > 0){
                node += numbersList.get(i - one);
                --one;
            }
            tree[i] = node;
        }
        return true;
    }

    public void printTree(){
        for (int i = 0; i <= numbersList.size(); i++) {
            System.out.printf("tree[%d] : %d\n", i, tree[i]);
        }
    }

    //index of the value
    public int getTreeSum(int idx){
        int sum = 0;
        while(idx > 0){
            sum += tree[idx];
            idx -= getLastOneBit(idx);
        }
        return sum;
    }

    public void treeUpdate(int i, int num){
        while(i <= numbersList.size()){
             tree[i] += num;
             i += getLastOneBit(i);
        }
    }

}
