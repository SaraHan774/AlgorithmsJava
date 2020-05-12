package com.gahee.algorithms.baek;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2042 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        ArrayList<Long> arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arrayList.add(Long.parseLong(bufferedReader.readLine()));
            //System.out.println(i + " : " + arrayList.get(i));
        }

        FenwickTree fenwickTree = new FenwickTree(arrayList);
        fenwickTree.treeInit();
//        fenwickTree.printTree();


        long a = 0, b = 0, c = 0;
        StringTokenizer st2 = null;
        for(int i = 0; i < M + K; i++){
            st2 = new StringTokenizer(bufferedReader.readLine());
            a = Long.parseLong(st2.nextToken());

            if(a == 1){
                b = Long.parseLong(st2.nextToken());
                c = Long.parseLong(st2.nextToken());
                fenwickTree.treeUpdate(b, c);
//                fenwickTree.printTree();
            }
            else if(a == 2){
                b = Long.parseLong(st2.nextToken());
                c = Long.parseLong(st2.nextToken());
                long result = fenwickTree.getTreeSum(c) - fenwickTree.getTreeSum(b-1);
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

    private ArrayList<Long> numbersList;
    private long [] tree;

    public FenwickTree(ArrayList<Long> numbers){
        numbersList = numbers;
        tree = new long[numbersList.size() + 1];
    }

    public long[] getTree() {
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
            long node = 0;
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
    public long getTreeSum(long i){
        long sum = 0;
        while(i > 0){
            sum += tree[(int)i];
            i -= getLastOneBit((int)i);
        }
        return sum;
    }

    //3 번째 숫자를 6으로 바꾼다
    //tree[3], tree[3 + 1], tree[4 + 4], ... 업데이트 되어야 함.
    //5 번째 숫자를 2로 바꾼다.
    public void treeUpdate(long i, long num){
        long diff = num - (getTreeSum(i) - getTreeSum(i - 1));
//        tree[(int)i] = num;
//        i += getLastOneBit((int)i);
        while(i < tree.length){
            tree[(int)i] += diff;
            i += getLastOneBit((int)i);
        }
    }

}
