## Today I Learned ... 
그 날 깨달은 것들을 정리해 두는 곳입니다. 

#### 2020-03-15 
Singly Linked List 는 항상 헤드로부터 타고 들어가서 접근한다. 따라서 어느 작업을 할 때든 헤드를 알고 있어야 
내부 요소들에 접근할 수 있다. 같은 맥락에서 리스트를 잘라서 붙이는 경우 헤드만 가져다가 붙여도 리스트 전체를 붙이는 꼴이 된다.

#### 2020-03-16
* 삭제되거나 이동할 원소들은 변수에 저장해둔다. 
* 원래의 특성을 복구해야 할 경우에 변수에 저장해둔다. 
* **진몽이의 알고리즘 특강** 
    * 문제의 조건을 바탕으로 구현을 할 때 논리적으로 빈 틈이 있는지 먼저 확인하자. 
    * ex. 트리 순회의 결과가 같다고 해서 트리의 구조가 같음을 보장할 수 없다. (하지만 트리의 구조가 같으면 순회 결과가 같음.)
    * 펜윅트리는 역원이 존재하는 연산에 대해서만 사용한다.
     (더하기, 곱셈, XOR 연산 등. 최대 최소 구하는데는 Segment tree 를 사용한다.)
    * **분할정복으로 푸는 것 고려하기.** 
* `System.in` 은 `ctrl + D` 를 누르기 전까지 입력을 대기하는 상태로 남는다. 

```
Scanner sc = new Scanner(System.in); 
...
while(sc.hasNext()){ ... } 
```    
를 하는 경우 `System.in` 으로 인하여 계속해서 입력 대기 상태에 머물게 된다. 

#### 2020-03-17 
* `BufferedReader` 와 `BufferedWriter` 를 사용하는 것이 Scanner 를 사용하는 것 보다 
더 빠르다고 한다. 
* 하지만 왜 자꾸 `flush()`를 해도 엔터키를 눌러야만 값들이 출력되는지 모르겠다 ... 
* 백준 사이트에서 Java 코드를 제출할 때는 `public class Main` 으로 설정한 후 제출해야 한다. 
    * 또한 코드 작성시 남겼던 불필요한 출력문들도 제거해 주어야 한다. 
* Log base 2 를 만들려면 Math.log(x)/Math.log(2) 를 통해 만들어야 한다. 기본 값은 base가 e 이다.
* Double -> Int 로 만들 경우 `new int[(int) Math.round(numOfNodes)];` 와 같이 한다. 

#### 2020-03-18
* 정답의 범위를 확인한다 ... long 인지 int 인지 잘 보고 풀자.
* 엔터 쳐야 값이 나오는 건 문제되지 않는다. 

#### 2020-03-19 
* `BufferedWriter` 는 항상 character 값을 쓰도록 되어있기 때문에 Int 만 넣어서 출력하는 경우 char 값으로 변환되어서 나온다. 
    * 따라서 항상 `BufferedWriter.write(문자열)` 과 같이 작성하도록 주의하자.  
* [세그먼트 트리 문제 : 2357](../src/com/gahee/algorithms/baek/Prob2357.java) 에서 나오는 것 처럼 재귀 쓰는 것 아직도 
많이 익숙하지 않은 것 같다. 많이 연습해서 재귀적 사고 과정을 머리에 넣어두자.
* 최소값과 최대값을 구하는 경우 Integer.MAX_VALUE / MIN_VALUE 사용

#### 2020-03-20
* Sequence 정보가 있을 때는 2차원 DP 를 사용한다. 
* `TIP!` 2차원 DP 가 채워지는 방향을 잘 보자. (대각선의 위로 채워지는지, 아래로 채워지는지 확인할 것)
* 윈도우(일정한 구간)를 정해서 배열을 순회하는 것을 Window Sliding 이라고 한다.
* 진몽이의 알고리즘 특강 과제 
    1. [최대 공통 증가수열 : 7476](https://www.acmicpc.net/problem/7476)
    2. [Longest Common Subsequence : 9251](https://www.acmicpc.net/problem/9251)
    
    
#### 2020-03-23 
* KickStart 2020 round A 참가 

#### 2020-03-25 
* DP 의 핵심은 Memoization Table 을 만드는 것 + Building up a bigger solution 
* 예시 
    1. Assembly line 문제에서는 라인 별 최소 시간을 계산해 두는 테이블과, 해당 시간을 
    얻기 위해 어떤 라인에서 부터 왔는지를 테이블에 따로 기록해둔다. 
    2. LCS 에서는 두 개의 문자열을 이용해 2차원 배열을 만들고, 각 문자들이 같은지, 같다면 어디에서 왔는지, 
    LCS의 개수는 어떻게 되는지 기록해 나간다. 
* [최대 공통 증가수열의 합 : 11055](https://www.acmicpc.net/problem/11055)
    * [11055 코드](../src/com/gahee/algorithms/baek/Prob11055.java)
* [Longest Common Subsequence : 9251](https://www.acmicpc.net/problem/9251)
    * [9251 코드](../src/com/gahee/algorithms/baek/Prob9251.java)
    * LCS 를 출력하라는 문제는 방향 배열도 만들어야 하는데, LCS의 길이만 구하는 경우 길이 배열만 유지하면 된다. 
    