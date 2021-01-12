# Today I Learned (Summary)
그 날 깨달은 것들을 정리해 두는 곳입니다. 

## 2020-03

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

* 2D 배열 첫 열 첫 행 0으로 초기화 하는 방법 
```
        for (int i = 0; i < c1.length; i++) {
            lcs[i][0] = 0;
        }
        for (int i = 0; i < c2.length; i++) {
            lcs[0][i] = 0;
        }
```

## 2020-05

#### 2020-05-06 
* Comparator 사용하기 
```
Comparator<Interval> comparator = Comparator.comparingInt(o -> o.start);
Arrays.sort(intervals, comparator);
```
* 인트 값을 기준으로 start 가 작은 것부터 큰 순으로 정렬하는 것.
* 새로운 배열을 꼭 만들지 않아도 되는 상황
```
//Move zeros : 0이 아닌 곳의 숫자를 원래의 배열의 앞부터 채워넣으면 된다. 
     for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != 0) {
                // 0 이 아닌 것을 배열의 처음부터 다시 집어넣는다.
                // 새로운 배열을 만들지 않아도 된다.
                numbers[index] = numbers[i];
                index++;
            }
        }
```

#### 2020-05-12 
* String 을 다루는 데 있어서 기본적인 것들 
    * `String.indexOf()` 
    * ASCII 값들 : a -> 97, z -> 122, A -> 65
    * 영어 알파벳은 26개
* 교훈 : **별도의 자료구조를 사용하지 않아도 되는가에 대해서 더 깊게 고민하자.**

#### 2020-05-13 
* 배운것의 응용과 새로운 방법의 고안 - 둘 사이의 절묘한 줄타기의 연속이다. 물론 아예 새로운 것은 없겠지만. 
* 좀 더 도전적인 시도를 하는 노력을 해보자. 
* String.contains() 와 HashMap.contains() 의 정확한 성능 차이는?

#### 2020-05-29 
* 클래스의 필드값으로 접근해서 값을 setting 하는 것과, getter 로 접근해서 
값을 set 하는 것은 다르다. get 한 결과가 null 이면, 해당 필드에는 값을 set 할 수 없다. 

## 2020-10 

#### 2020-10-06 
* Java 에서 Heap 을 사용하고자 할 때는 PriorityQueue 클래스를 사용한다. 
* 기본적으로는 Min Heap 이며, Max Heap 으로 사용하고자 할 때는 생성자에 Comparator 를 다시 만들어서 넣어주어야 한다. 

```java
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
```

* Enhanced For loop 를 잘 사용하자. 

```java
    for (int stone : stones) {
        maxHeap.add(stone);
    }
```

#### 2020-10-07 
* Arrays.sort() 는 듀얼 피봇 퀵소트를 사용하며 성능은 NlogN 이다. 
* loop 를 두 번 돌아야 할 때 이렇게 하지 않아도 되는 방법이 있는지 생각해보자 !   

#### 2020-10-08 
* **중복 => 해시 를 떠올리는 것이 효율적이다.** O(1) 만에 탐색이 가능하다. 

#### 2020-10-14 
* PriorityQueue 의 poll 함수는 비어있으면 null 를 반환한다. 반드시 isEmpty 로 확인한 후 poll 연산을 쓰도록 하자.

#### 2020-10-20 
* 배열을 풀로 2중 순회하기 전에 그렇지 않아도 되는 방법이 있는지 확인하기.
* nCk 로 풀 수 있음에도 N*N 으로 푸는 일은 있어서는 안된닷 ... 

```java
for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                //j 가 i 의 접두사가 되는가? 
                if(phone_book[i].startsWith(phone_book[j])){return false;}
                //i 가 j의 접두사가 되는가? 
                if(phone_book[j].startsWith(phone_book[i])){return false;}
            }
        }
```

* PhoneBook 문제에 대한 다른 풀이 

```java
class Solution {
    public boolean solution(String[] phone_book) {
      boolean answer = true;

        String k;
        for (int i = 0; i < phone_book.length; i++) {
            k = phone_book[i];
            int lenK = k.length(); 
            for (int j = i + 1; j < phone_book.length; j++) {
                String p = phone_book[j]; 
                int lenP = p.length(); 
                
                if(lenP >= lenK){
                    String pSub = p.substring(0, lenK);
                    if(pSub.equals(k)){
                        answer = false; 
                        return answer; 
                    }
                }else{
                    String kSub = k.substring(0, lenP);
                    if(kSub.equals(p)){
                        answer = false; 
                        return answer; 
                    }
                }
            }
        }
        return answer;
    }
}
```

#### 2020-12-05
* 우선순위 Heap 을 이용한 문제풀이
* 스코빌지수 구하기 문제 [(코드)](../src/com/gahee/algorithms/programmers/Scoville1.java)
* 교훈 : 좀 더 적극적으로 테스트 케이스를 만들어서 코드를 시험해보자.

#### 2020-12-06 
* 교훈 : 문제를 읽고 바로 구현하려 들기보다는 로직을 잘 설계하는 데 초점을 맞추자. 
나의 코드에 대해서 좀 더 확신을 가져야 한다.
  
#### 2020-12-14 
* 2D 배열을 첫번째것 기준으로 정렬할 경우 

```java
Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
```

* 클래스를 Comparable 로 만들 때 
* 클래스를 만들어야 할 경우 가급적 toString 을 오버라이딩 하는 것을 습관화 하자. 
```java
    static class Job implements Comparable{
        int reqTime;
        int duration;

        public Job(int reqTime, int duration) {
            this.reqTime = reqTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.duration, ((Job)o).duration);
        }

        @Override
        public String toString() {
            return "Job{" +
                    "reqTime=" + reqTime +
                    ", duration=" + duration +
                    '}';
        }
    }
```

#### 2020-12-16 
* 프린터 문제 풀이 [(코드)](../src/com/gahee/algorithms/programmers/Printer2.java)
* class Job 을 만들어서 풀었는데 클래스 없이 푼 코드를 보아도 이해가 잘 안된다 ㅠㅠ 
* 남이 짠 코드를 잘 이해하려면 어떻게 해야할까 ... 너무 어렵쓰. 

#### 2020-12-18 
* Double Ended Priority Queue 를 구현하는 문제!
* 최대값과 최소값을 찾는 것을 둘 다 상수 시간 안에 하고 싶을 때 필요한 자료구조. 
* max heap min heap 양 쪽에 서로의 노드간에 포인터가 있어야 한다. 제대로 구현하는건 어떻게 될지 잘 모르겠음. 
* [코드](../src/com/gahee/algorithms/programmers/DoublePriorityQueue.java)

#### 2020-12-26 
* 백준에서 DFS BFS 구현 문제를 풀었다. 우습게 보았으나 5번의 런타임 에러 끝에 반례를 발견하였다. 
* 2-3 / 1 과 같이 1이 다른 노드들과 연결되어 있지 않은 경우, 1부터 탐색을 시작하면 1을 출력하고 바로 프로그램이 종료되어야 한다. 
하지만 이런 에러 처리를 해주지 않았기 때문에 계속해서 런타임 에러가 발생하였다. .... 😖
* [DFS&BFS](../src/com/gahee/algorithms/baek/P1260.java)
<br/><br/>

* 프로그래머스 네트워크 문제 풀이 [코드](../src/com/gahee/algorithms/programmers/Network1.java)
* BFS 로 탐색 하면서 뭉쳐있는? 컴포넌트들이 몇 개 있는지 세는 방식으로 구현했다... 사실 뭔가 삘로 구현한 것이기 때문에 
정확히 왜 이렇게 설계했고, 왜 맞았는지 자신있게 얘기하지는 못하겠음 ... ;;;
  
# 2021 Happy New Year ! 🏳‍🌈

#### 2021-01-01
* 프로그래머스 단어변환 문제 [코드](../src/com/gahee/algorithms/programmers/WordTarget1.java)
* 처음에는 단어와 단어 사이의 간선을 놓는 과정을 엄청 복잡하게 설계했었는데, 그냥 단어의 철자와 위치가 단어 길이 - 1 이상 개 일치하는 경우
같은 인접 노드로 두면 되었었다. 
* 무방향 그래프로 만들어서 BFS 를 돌렸고, 돌리는 과정에서 탐색할 때마다 시작 노드에서부터의 path 길이를 Map 에 기록하였다. 
* 타겟 단어가 나오면 Map 에서 해당 타겟의 count 를 answer 로 반환한다. 
* 보아하니 다른 분들은 대체적으로 DFS 로 풀었던데, 흠 ... shortest path => BFS 로 생각해서 너무 단순하게 접근하였나 싶다. 

#### 2021-01-01 
* 백준 바이러스 문제 [코드](../src/com/gahee/algorithms/baek/P2606.java)
* 하 ... 
* 일단 BFS 를 사용하는게 맞는데 성급하게 구현해서 DFS로 구현했다가 지우고 다시함. 
* BFS 를 사용했으나 노드를 양방향으로 연결하지 않아서 오답이 나옴 ... 
* 그리고 queue 를 비워주고 채워주는 과정에서 약간 버벅거리는게 있었음 ㅠㅠ 확실히 패턴대로 풀려니 머리가 뻑뻑해지는 듯. 
* 아무리 패턴이 있는 문제이지만 그럴수록 익숙한 패턴을 문제에 대입해 게으르게 풀려고 하는 심리를 버려야겠다. 

#### 2021-01-03
* 백준 가운데를 말해요 문제 [코드](../src/com/gahee/algorithms/baek/P1655.java)
* 두 heap 의 사이즈를 밸런싱 해주는 로직을 간과할 수 있다 .. 조심하기 
* 반환할 때 만약 heapHigh 의 사이즈가 더 크다면 중간값을 반환할 수 있도록 로직을 추가해야 한다.
* NlogN => **숫자가 들어올 때 마다 말해줘야 하는게 포인트**
* (정렬로 푸는 경우) 만약 들어올 때 마다 정렬을 해야하면 N^2logN
```
ex) 
heapLow = [-10000] 
heapHigh = [100, 10000]
이런 상황일 때는 heapHigh 의 100을 반환해 주어야 함. 
```

#### 2021-01-05 
* 코세라 과제 : Median 을 Heap 두개를 두어서 찾는것 [코드](../src/com/gahee/algorithms/coursera/Median.java)
* 백준 문제를 풀면서 구현했던 코드와 거의 동일하다. if-else 문의 구성만 약간씩 다르다. 
* 이 외에 코세라에서 주는 사이즈가 큰 txt 파일을 실수로 git add 해버린 것을 리셋하는 방법을 배웠다. 

```
git reset HEAD <FILE_NAME> 
```

* 위와같이 하면 해당 파일이 git 에서 트래킹 되지 않는다. 

#### 2021-01-07
* 프로그래머스 실력체크 [레벨 1 - 문제 1](../src/com/gahee/algorithms/programmers/StringToNumber.java)
* 프로그래머스 실력체크 [레벨 1 - 문제 2](../src/com/gahee/algorithms/programmers/NTimesArray.java)
* 프로그래머스 실력체크 레벨 2 - 문제 1 (기능개발 문제는 예전에 풀었어서 스킵 ...)
* 프로그래머스 실력체크 [레벨 2 - 문제 2](../src/com/gahee/algorithms/programmers/BinaryConverter.java)



#### Character.isXXX() 메서드 탐색하기 
```java
    private static void charTesting(){
        String s = "av123er   tgs---1781920380r0((^^&*()=";
        char [] chars = s.toCharArray();
        for (char c : chars) {
            if(Character.isDigit(c)){
                System.out.println(c + " is digit");
            }
            else if(Character.isAlphabetic(c)){
                System.out.println(c + " is alphabet");
            }
            else if(Character.isSpaceChar(c)){
                System.out.println("space char");
            }
            else{
                System.out.println("what is this ? " + c);
            }
            if(Character.isLetterOrDigit(c)){
                System.out.println(c +  " is letter or digit");
            }
        }
    }
```

#### 이진수로 변환하는 방법 
* 숫자를 2로 나눈 결과가 0보다 클 동안 2로 나눈 나머지를 스트링 빌더에 어펜드 한다. 
* 결과를 reverse() 함수로 뒤집어준다. 
* 예시 코드 [MakeBinary.java](../src/com/gahee/algorithms/programmers/MakeBinary.java)
```java
    public static void main(String[] args) {
        int num = 17;
        StringBuilder stringBuilder = new StringBuilder();
        while(num/2 > 0){
        stringBuilder.append(num%2);
        num = num/2;
        }
        System.out.println("num => " + num);
        // 4 / 2 => 2 / 2 => 1 / 2 => 1, 0, 0 순서대로 와야 함. 
        // 5 / 2 => 2 / 2 => 1 / 2 => 1, 0, 0, 1 이 되어야 함. 
        // 이렇게 되므로 ... 마지막에는 항상 1이 나오는 것을 append 해주어야 함. 
        stringBuilder.append("1");

        System.out.println(stringBuilder.reverse());
        } 
```

#### 2021-01-11 

* Java int [ ] 를 List 로 변환하기 

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

List<Integer> lostList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
```

* List.remove(Object) 를 할 때 숫자 값을 찾아서 지우는 경우 (인덱스로 찾는 것 말고) Integer 값으로 박싱을 해주어야 한다. 
  * `List.remove((Integer) (numberElement))` 와 같이 해주어야 함! 안그러면 인덱스를 찾는걸로 인식해서 인덱스 바운드를 벗어났다는 
  예외를 던질 수 있음. 
    
#### 프로그래머스 **GREEDY** 문제 풀이 
  1. [체육복 빌려주기](../src/com/gahee/algorithms/programmers/GymClothes1.java) 
    * 체육복의 여분이 있더라도 자신이 도난당한 경우라면 이를 제외해주어야 함. 
  2. [큰 수 만들기](../src/com/gahee/algorithms/programmers/MakeBigNumber1.java)
    * 숫자의 최대 길이가 100만 이어서, 테스트 케이스 2개에서 자꾸만 시간 초과가 뜬다 ... 
    * 어떻게 하면 줄일 수 있을지 ...?
     
#### IPortfolio 코딩테스트 문제 
1. 서술형 2문제 
  - URL Encoding 을 사용하는 이유와 방법을 서술하시오. 
  - DB 에서 index 를 사용하는 이유와 장단점을 서술하시오. 

2. 알고리즘 세 문제 
  1. Palindrome **[결과 : 33.9/40 - 성능 테스트 1개 fail]**
    - 팰린드롬이 들어가 있는 문자열이 주어진다. ex. abacedp - aba 가 팰린드롬 
    - 문자열의 길이는 최대 2500이며 영어 소문자로만 이루어져있다. 
    - 이 때 해당 문자열 안의 모든 palindrome 중 가장 길이가 긴 것의 길이를 반환하라.
  2. 인접한 숫자와의 차이가 K 이하이도록 숫자들을 swap **[못풀었음]**
    - 자연수의 배열이 주어진다. 
    - 각 자연수들을 swap 하여서 인접한 숫자와의 차이가 K이하이도록 배열을 재구성한다.
    - 이 때 최소 swap 의 횟수를 구하라. 
  3. 영화의 상영 순서대로 영화의 이름이 배열에 담겨 주어진다. **[Map 과 Priority Queue 사용하여 해결]**
    - 영화가 두 번 상영 되었으면 배열에 두번 등장함
    - 각 영화의 상영 횟수가 많은 순서대로 배열에 담아 출력, 만약 상영 횟수가 같다면 이름의 알파벳 순으로 출력하라. 
     (Map 사용하는 문제)

3. SQL 2문제 
  - GROUP BY, COUNT 사용 문제 
  - ROUND(AVG(열), 2) 사용 문제 