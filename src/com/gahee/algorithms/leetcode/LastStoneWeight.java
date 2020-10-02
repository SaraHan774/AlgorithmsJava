package com.gahee.algorithms.leetcode;

import java.util.*;

public class LastStoneWeight {

    public static void main(String[] args) {

        int[] stones = {2, 7, 4, 1, 8, 1};
        Solution solution = new Solution();
        int answer = solution.lastStoneWeight(stones);
        System.out.println(answer);
    }

    static class Solution{

        public int lastStoneWeight(int [] stones){
            List<StoneNode> stoneNodes= new ArrayList<>();

            for (int i = 0; i < stones.length; i++) {
                stoneNodes.add(new StoneNode(i, stones[i]));
            }

            int result;
            int i;
            for (i = 0; i < stoneNodes.size();) {

                if(stoneNodes.size() == 1){
                    result = stoneNodes.get(0).value;
                    return result;
                }

                stoneNodes.sort((o1, o2) -> o2.value - o1.value);

                StoneNode first = stoneNodes.get(0);
                StoneNode second = stoneNodes.get(1);;

                StoneNode[] order = first.findLargerIdx(second);

                if(order != null){
                    stoneNodes.set(0, new StoneNode(order[0].index, first.value - second.value));
                    stoneNodes.remove(order[1]);
                }else{
                    stoneNodes.remove(first);
                    stoneNodes.remove(second);
                }
            }
            return 0;
        }
    }

    static class StoneNode{
        int index;
        int value;

        public StoneNode(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public StoneNode [] findLargerIdx(StoneNode node){
            if(this.value > node.value){
                return new StoneNode[]{this, node};
            }else if(this.value < node.value){
                return new StoneNode[]{node, this};
            }else{
                return null;
            }
        }

        @Override
        public String toString() {
            return "{" +
                    value +
                    '}';
        }
    }
}