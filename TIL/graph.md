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
	• 많다 : dense graph 라고 한다. 2차원 배열
	• 적다 : sparse graph 라고 한다. SLL 을 이용 (단일 연결 리스트)

* 하지만 꼭 위의 기준에 맞추기 보다는, 해결하려는 문제에 따라 알맞게 선택하자. DLL을 사용해도 되고, 다른 자료 구조를 사용해도 OK

### 코드 
* [2차원 배열로 그래프 표현하기](../src/com/gahee/algorithms/graph/GraphArray.java)
* [단일 연결 리스트로 그래프 표현하기](../src/com/gahee/algorithms/graph/GraphSLL.java) 


