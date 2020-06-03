# Graph Basics 

#### 2020-05-29 

* 인천대학교 전경구 교수님 - 알고리즘

### 그래프 활용 
- 도로 표시 
- 인접한 영역을 그래프로 표시 (서로 연결이 되어 있음을 표시)
- 과목간의 선, 후수 관계 표시. A를 먼저 들어야 B를 들을 수 있다. 

### 그래프 용어 
- 정점 (Vertex, Node) 
- 간선 (Edge)

### 그래프의 종류 
- Undirected graph : 방향성이 없는 edge 로 이루어진 그래프  
- Directed graph : 방향성이 있는 (화살표로 가리키는 등) edge 로 이루어진 그래프
- Weighted graph : Edge 위에 10, 5, 11 과 같이 숫자 있는 것을 가중치라 한다. 
- Adjacent Vertex : A 의 adjacent vertex 는 B 와 C 이다 / C 의 adjacent vertex 는 A 이다. 

### Degree : Edge 의 개수 
- 들어오는 화살표 : In - degree 
- 나가는 화살표 : out - degree 

### Cycle 
- 경로를 이었을 때 출발과 도착이 같은 것 

### Complete graph 
- 모든 vertex 가 adjacent vertex 로 연결되어 있는 경우. 
- A - B, C, D 와 연결, B - C, D 와 연결, C - D 와 연결 된 경우. 
- 정점이 n 개 일 때, n*(n-1)/2 이다. 


### 그래프의 구현 
- 2차원 배열을 이용한다. 
- 그래프의 노드는 배열의 인덱스, 0 과 1 사이에 간선이 있다면 배열의 원소로 1을 넣고, 연결이 되어있지 않으면 0을 원소로 넣는다. 
- 방향성있는 그래프일 때에는 배열이 대칭성을 띄지 않는다. 행은 도착노드, 열은 시작 노드라고 생각하자. 
- 간선이 몇 개 없는 경우 2차원 배열로 표현하면 공간 낭비가 심해진다. 이를 극복하기 위한 방법이 Singly Linked List 를 사용하는 방법이다.


### 단일 연결 리스트로 그래프 표현하기 
- 0번 노드 -> 1번과 연결 -> 2번과 연결 -> … 
- 1번 노드 -> 0번과 연결 -> 2번과 연결 … 

* Edge 가 많을때는 단일 연결 리스트도 공간을 많이 차지하게 됨. 

### Edge 개수
- 많다 : dense graph 라고 한다. 2차원 배열
- 적다 : sparse graph 라고 한다. SLL 을 이용 (단일 연결 리스트)

* 하지만 꼭 위의 기준에 맞추기 보다는, 해결하려는 문제에 따라 알맞게 선택하자. DLL을 사용해도 되고, 다른 자료 구조를 사용해도 OK

### 코드 
* [2차원 배열로 그래프 표현하기](../src/com/gahee/algorithms/graph/GraphArray.java)
* [단일 연결 리스트로 그래프 표현하기](../src/com/gahee/algorithms/graph/GraphSLL.java) 


# DFS (Depth First Search) : 노드를 쭉 타고 들어간다! 

* 하나의 vertex 에서 시작하여 graph 의 모든 vertex 를 방문하는 알고리즘. 
    * 그래프의 모든 연결된 정점을 중복 없이 방문. 
* 두 가지 알고리즘 
    1. DFS : 깊이 위주로 검색 
    2. BFS (Breadth First Search) : 넓이 위주로 검색 
    
### DFS 
* 미로 찾기와 비슷하다. 
    * 길이 막히면 갈림길이 있었던 곳으로 돌아와서 다시 시작 
    * 스택을 이용한다. 
    
### Walk-through
* Visited array 를 두어서 방문한 곳을 표시한다. 
* Stack 은 막다른 길에 들어섰을 때 다시 돌아나오기 위해 사용한다. 
* 방문 -> 방문한 노드 배열에 체크 -> 스택에 방문한 노드 push, 
방문한 노드에서 더 이상 갈 곳이 없으면 stack pop  
    * 이렇게 뒤로 돌아가는 것을 back tracking 이라고 한다. 
    * pop한 노드도 배열 방문했다고 그대로 둔다.
* 이미 방문한 노드이면 다른 노드를 선택하도록 한다. 
* backtrack 과정 : 방문할 수 있는 곳이 더 이상 없으면 (배열에서 check 된 상태이면)
stack 에서 계속해서 pop 해준다. 
* 스택이 비었으면 종료한다. 



#### 2020-06-03

### Code 

```java
import java.util.Stack;

public class GraphDFS {
    private static final int NUM_VERTEX = 5;

    private Stack<Integer> stack = new Stack<>();
    private int [] visited = new int[NUM_VERTEX];
    private Node [] graph = new Node[NUM_VERTEX];
    
    ...

        
    private class Node{
        //본 클래스에서만 사용될 것이므로 private inner class 로 만들었다.
        int v;
        Node next;

        Node(int v, Node next){
            this.v = v;
            this.next = next;
        }
    }
```

* 필요한 자료구조 
  * 방문한 배열을 담을 visited array 
  * 노드들을 연결할 그래프를 위한 graph array 
  * 백트래킹을 위한 stack (Java 에서는 `java.util.stack` 을 사용하였다)
  * 노드를 표현할 Node class 



```java
//Node v1과 v2 를 연결한다.
public void addEdge(int v1, int v2, int doReverse){
    Node newNode = new Node(v2, null);
    Node curNode = graph[v1];

    if(curNode == null){
        graph[v1] = newNode;
    }else{
        //현재 노드의 다음 노드가 null 이 아닐때까지 탐색
        while(curNode.next != null){
            //다음 노드로 이동
            curNode = curNode.next;
        }
        //다음 노드가 null 이므로 마지막 노드이다.
        //새로운 노드를 마지막 노드의 다음 노드로 연결한다.
        curNode.next = newNode;
    }
    if(doReverse == 1){
        //v2 와 v1 을 연결한다.
        addEdge(v2, v1, 0);
    }
}
```

* 간선들을 연결할 메서드. 
* doReverse 를 이용해서 v1 - v2 연결, v2 - v1 연결 과정을 단순화 한다. 



```java
//현재 정점과 연결된 다음 노드를 찾는다.
public int findNextVertex(int v){
    Node curNode = graph[v];

    while(curNode != null){
        if(visited[curNode.v] == 0){
            return curNode.v;
        }
        curNode = curNode.next;
    }
    return -1;
}
```

* 그래프를 타고 들어가서 방문했던 노드인지 확인하고, 방문하지 않았으면 해당 노드를 반환한다. 



```java
//정점 v 로부터 탐색을 시작한다.
public void doDFS(int v){
    System.out.println("visited " + v);
    visited[v] = 1; //정점을 방문했다고 표시한다.
    stack.push(v); //일단 스택에 넣고 시작한다.

    //stack 이 비어있지 않을 동안
    while(!stack.isEmpty()){
        int nextVertex;
        nextVertex = findNextVertex(stack.peek());
        if(nextVertex == -1){
            //더 이상 stack 의 top 에 있는 것으로는 확인 불가.
            //갈 데가 없으므로 백트래킹
            stack.pop();
        }else{
            System.out.println("visited " + nextVertex);
            visited[nextVertex] = 1;
            stack.push(nextVertex);
        }
    }
}
```

* 스택의 맨 위에 있는 노드와 연결된 노드가 있는지 확인한다. 
  * 만약 있다면 해당 노드의 정점이 nextVertex 가 된다. 
  * 해당 노드를 방문하고, 해당 노드의 정점을 방문했다고 표시한다. 
  * 그리고 스택에 방문한 정점을 push 한다. 
* 만약 스택의 맨 위에 있는 노드와 연결된 모든 노드들을 방문했다면 
  * stack을 pop 한다. 
* stack 이 비어있지 않다면, 위의 과정을 스택이 빌 때 까지 반복한다. 



# BFS (Breadth First Search) : 노드의 주변을 먼저 탐색한 후 들어간다!

  

### Code 

```java
//넓이 우선 탐색을 진행한다.
public void doBFS(int v){
    queue.add(v); //방문한 정점을 큐에 넣는다.
    visited[v] = 1; //방문 했다고 표시한다.
    System.out.println("visited " + v);

    while(!queue.isEmpty()){
        //queue 의 front 와 연결된 간선이 있는가?
        int front = queue.poll();
        Node curNode = graph[front];

        while(curNode.next != null){
            curNode = curNode.next;
            //queue 의 front 와 연결된 정점들을 방문 했는가?
            if(visited[curNode.v] != 1){
                visited[curNode.v] = 1;
                queue.add(curNode.v);
                System.out.println("visited " + curNode.v);
            }
        }

    }
}
```

* Stack 대신 Queue 를 이용한다. 먼저 탐색했던 것과 연결된 정점이 있는지 확인한 후 그 다음 정점으로 넘어간다. 



<img src="image-20200603150817310.png" alt="image-20200603150817310" style="zoom: 33%;" />

* 위와같은 그래프를 만든다고 할 때의 BFS 의 결과는 다음과 같다. 

```
visited 0
visited 2
visited 4
visited 1
visited 3
```

