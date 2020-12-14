### Programming Assignment No.1 

### Programming Assignment No.2

### Programming Assignment No.3 

### Programming Assignment No.4 

#### 문제 

- minCut.txt 파일을 이용해서 문제 해결하기.
  
- 파일은 undirected 그래프에 대한 인접 리스트의 표현을 담고 있다. 
  200개의 정점이 있고 각각 1부터 200까지 라벨이 붙어있음. 파일의 첫 번째 
  컬럼은 정점의 라벨을 나타내고, 특정 row 는 정점과 연결된 다른 정점들을 
  나타낸다.
  
- 예를 들어, 여섯번째 줄은 6, 155, 52, 120 ... 과 같이 숫자가 있고, 이것이 
의미하는 바는 6번 정점이 155, 52, 120 번 정점과 연결되어 있다는 것이다.
  
- **과제 : min cut 문제를 위한 randomized contraction 알고리즘**을 
코딩하고, 주어진 그래프의 min cut 을 계산하라.
  
- **Kargar 의 알고리즘** 
  1. 랜덤하게 하나의 간선을 선택한다. 
  2. 간선 위의 두 정점을 합친다. 
  3. 만약 자기 자신을 가리키는 간선이 생긴다면 이를 제거하라 
  4. 그래프 상에서 정점이 2개밖에 남지 않을 때 까지 이를 반복하라. 