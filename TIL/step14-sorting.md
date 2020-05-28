# Sorting 

#### 2020-05-27 

1. [O(N^2) 성능으로 정렬하기](../src/com/gahee/algorithms/baek/P2750.java)
    * 버블 정렬으로 하면 엔제곱 성능이 나온다. 
    * Java 의 Collections.sort() 함수는 내부적으로 머지 소트를 이용하므로 NlogN 의 성능이다. 

2. [NlogN Merge Sort 구현하기](../src/com/gahee/algorithms/baek/P2751.java)
    * Merge Sort 를 쌩으로 구현해야만 시간초과가 뜨지 않는다.
    
3. [Counting Sort 구현하기](../src/com/gahee/algorithms/baek/P10989.java)
    * Buffered Reader, Writer 를 사용하지 않고 Scanner 나 System.out.println 을 
    사용하면 시간초과가 난다. 
    
4. [통계학](../src/com/gahee/algorithms/baek/P2108.java)
    * 최빈값을 구하는 부분에서 자꾸만 틀린다. 
    * 다음에 다시 시도해 봐야겠다. 
    
#### 2020-05-28    

5. [주어진 숫자들을 자릿수의 내림차순 정렬해서 출력](../src/com/gahee/algorithms/baek/P1427.java)
    * toCharArray() -> Arrays.sort() -> 역순으로 출력 
    
6. [좌표 정렬하기 - x좌표 기준](../src/com/gahee/algorithms/baek/P11650.java)
7. [좌표 정렬하기 - y좌표 기준](../src/com/gahee/algorithms/baek/P11650.java)
    * Comparable 인터페이스를 구현하고, 정렬 기준을 명시해준다. 
    * Point 객체를 출력했을 때 `x y` 형식으로 출력되도록 toString 을 오버라이링 해준다. 
    
8. [단어 정렬](../src/com/gahee/algorithms/baek/P1181.java)
    * Arrays.sort(arr, new Comparator()) 을 통해서 정렬의 기준을 정한다. 
    * 만약 길이가 같다면 String1.compareTo(String2) 를 써서 사전 순으로 정렬한다. 
    * 출력할때는 i 가 arr.length - 1 보다 작으면서, i 와 i+1번째 단어가 같은지 확인한다. 
    같다면 출력하지 않고 continue 를 통해서 스킵한다. 

9. [나이순 정렬](../src/com/gahee/algorithms/baek/P10814.java)
    * 나이순대로 정렬할 수 있도록 compareTo 함수를 정의해준다. 
    * **Stable Sort 가 가능한 알고리즘으로 다시 풀어보자.** 