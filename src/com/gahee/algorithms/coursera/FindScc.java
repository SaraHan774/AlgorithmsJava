package com.gahee.algorithms.coursera;

import java.util.ArrayList;

public class FindScc {

    ArrayList<Node> [] graph;
    int finishedTime = 0;
    Node s = null;

    public FindScc(ArrayList<Node> [] graph){
        this.graph = graph;
    }

    public void depthFirstLoop(){

    }

    class Node{
        int finishedTime;
        int value;
        Node leader;

        public Node(int value){
            this.value = value ;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
