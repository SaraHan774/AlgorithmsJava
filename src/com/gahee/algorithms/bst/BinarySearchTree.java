package com.gahee.algorithms.bst;


public class BinarySearchTree{

    public BinarySearchTree(){

    }

    public Node createNode(int data){
        return new Node(null, null, null, data);
    }

    public void insertNode(Node rootNode, int data){
        //만약 트리가 존재하지 않는다면
        Node newNode = createNode(data);

        Node parent = null;
        Node child = rootNode;
        while(child != null){
            parent = child;
            if(newNode.key < child.key){
                child = child.left;
            }else{
                child = child.right;
            }
        }
        newNode.parent = parent;
        if(parent == null){
            rootNode = newNode;
        }else if(newNode.key < parent.key){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
    }

    /*BST 의 특징은 루트를 기준으로 오른쪽은 루트보다 크거나 같은 노드,
    * 왼쪽은 루트보다 작은 노드들이 들어온다는 것이다. 따라서 검색 시
    * 검색 대상으로 들어온 key 값이 루트보다 작은지 큰지 판별하여 왼쪽을
    * 탐색할지 오른쪽을 탐색한지 결정한다. */
    public Node treeSearch(Node rootNode, int searchKey){
        if(rootNode == null || searchKey == rootNode.key){
            return rootNode;
        }
        //찾고자 하는 key 값이 루트의 key 값 보다 작은 경우 왼쪽을 탐색.
        if(searchKey < rootNode.key){
            return treeSearch(rootNode.left, searchKey);
        }else{
            return treeSearch(rootNode.right, searchKey);
        }
    }

    public Node treeMinimum(Node rootNode){
        while(rootNode.left != null){
            rootNode = rootNode.left;
        }
        //더 이상 왼쪽으로 내려갈 수 없는 경우
        return rootNode;
    }

    public Node treeMaximum(Node rootNode){
        while(rootNode.right != null){
            rootNode = rootNode.right;
        }
        //더 이상 오른쪽으로 내려갈 수 없는 경우
        return rootNode;
    }

    // 직후원소 : 현재 원소보다 큰 값들 중 가장 장은 원소
    public Node treeSuccessor(Node node){
        if(node.right != null){
            //만약 right 가 비어있지 않다면 오른쪽 중에서 가장 작은 값 반환
            return treeMinimum(node.right);
        }
        //오른쪽이 없는 경우
        Node parentNode = node.parent;
        while(parentNode != null && node == parentNode.right){
            //만약 자기 자신이 parent 의 오른쪽 자식이라면
            //parent 의 왼쪽 자식이 될 때 까지 올라간다
            node = parentNode;
            parentNode = parentNode.parent;
        }
        //만약 자기 자신이 parent 의 왼쪽 자식이라면
        //그냥 parent 노드를 반환한다.
        return parentNode;
    }

    //직전원소 : 현재 원소보다 작은 값들 중 가장 큰 원소
    public Node treePredecessor(Node node){
        //나의 왼쪽은 항상 나보다 작다.
        if(node.left != null){
            return treeMaximum(node.left);
        }
        //만약 왼쪽 노드가 없는 경우
        Node parentNode = node.parent;
        while(parentNode != null && node == parentNode.left){
            node = parentNode;
            parentNode = node.parent;
        }
        //자기 자신이 parent 노드의 오른쪽 자식이라면 그냥
        //parent 노드를 반환한다.
        return parentNode;
    }

}

class Node{
    Node left;
    Node right;
    Node parent;
    int key;

    public Node(Node left, Node right, Node parent, int key) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.key = key;
    }
}

