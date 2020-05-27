# Sorting 

#### 2020-05-27 

1. [O(N^2) 성능으로 정렬하기](../src/com/gahee/algorithms/baek/P2750.java)
    * 버블 정렬으로 하면 엔제곱 성능이 나온다. 
    * Java 의 Collections.sort() 함수는 내부적으로 머지 소트를 이용하므로 NlogN 의 성능이다. 

#### 2020-05-28 

2. [NlogN Merge Sort 구현하기](../src/com/gahee/algorithms/baek/P2751.java)
    * Merge Sort 를 쌩으로 구현해야만 시간초과가 뜨지 않는다.