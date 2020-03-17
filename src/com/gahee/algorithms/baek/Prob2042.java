package com.gahee.algorithms.baek;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prob2042{

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(bufferedReader.readLine()));
            //System.out.println(i + " : " + arrayList.get(i));
        }

        FenwickTree fenwickTree = new FenwickTree(arrayList);
        fenwickTree.treeInit();
//        fenwickTree.printTree();


        int a = 0, b = 0, c = 0;
        StringTokenizer st2 = null;
        for(int i = 0; i < M + K; i++){
            st2 = new StringTokenizer(bufferedReader.readLine());
            a = Integer.parseInt(st2.nextToken());

            if(a == 1){
                b = Integer.parseInt(st2.nextToken());
                c = Integer.parseInt(st2.nextToken());
                fenwickTree.treeUpdate(b, c);
//                fenwickTree.printTree();
            }
            else if(a == 2){
                b = Integer.parseInt(st2.nextToken());
                c = Integer.parseInt(st2.nextToken());
                int result = fenwickTree.getTreeSum(c) - fenwickTree.getTreeSum(b-1);
//                System.out.println("==== result : " + result + " ==== ");
                bufferedWriter.write(result + "\n");
            }
//            System.out.printf("\na : %d, b : %d, c : %d\n", a, b, c);
        }

//        fenwickTree.printTree();
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
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
//            System.out.printf("\nA[%d] : %d\n", i, one);
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
            System.out.printf("\ntree[%d] : %d\n", i, tree[i]);
        }
    }

    //index of the value
    public int getTreeSum(int i){
        int sum = 0;
        while(i > 0){
            sum += tree[i];
            i -= getLastOneBit(i);
        }
        return sum;
    }

    //3 번째 숫자를 6으로 바꾼다
    //tree[3], tree[3 + 1], tree[4 + 4], ... 업데이트 되어야 함.
    //5 번째 숫자를 2로 바꾼다.
    public void treeUpdate(int i, int num){
        int diff = num - tree[i];
        tree[i] = num;
        i += getLastOneBit(i);
        while(i <= numbersList.size()){
            tree[i] += diff;
            i += getLastOneBit(i);
        }
    }

}
