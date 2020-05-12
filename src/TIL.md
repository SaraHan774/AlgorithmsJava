# Today I Learned ... 
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
* String 을 계속해서 append 해 나가야 할 때는 `string += string1` 과 같은 방법 보다는 
StringBuilder 를 사용하자. 

```
StringBuilder answer = new StringBuilder();
        int leftNum = -1, rightNum = -2;
        
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                answer.append("L");
                leftNum = n;
        ... 
``` 
* 카카오 여름 인턴십 문제를 풀어보았다. 한 문제 밖에 제대로 풀지 못했지만, 
그래도 문제를 보니 1년 동안 집중해서 공부하면 될 수 있을 것이라는 확신이 들었다. 
정해진 계획들을 잘 따라서 앞으로 정말 열심히 한 번 해봐야지. 
* 그나마 쉽게 풀었던 문제 ... [전화번호 누르기 문제](../src/com/gahee/algorithms/kakao/DialPad.java)

#### 오늘의 문제 
1. [ASCII 숫자로 출력하기](../src/com/gahee/algorithms/baek/P11654.java)
    * BufferedReader 는 읽는 것들을 character 로 변환한다는 것을 두 달 전에 써놨건만 또 까먹고 문제를 이상하게 풀었다.
2. [들어온 숫자들을 합해서 출력하기](../src/com/gahee/algorithms/baek/P11720.java)
    * char 과 같은 primitive type 들은 int 로 변환하는 메서드를 갖고 있지 않다. 따라서 int로 형변환을 한 후에 얻은 아스키 코드 값에서 
    48을 빼주어야 원래의 int 값을 얻을 수 있다. 
    
```
for (int i = 0; i < N; i++) {
            K = (int)numbers[i] - 48;
            answer += K;
        }
``` 

3. [알파벳이 들어있다면 찾은 위치 출력하기](../src/com/gahee/algorithms/baek/P10809.java)
    * ASCII 값으로 소문자 a 는 97 이고 z 는 122 이다. 
    * 총 26개의 알파벳이 있다. 
    * 중복될 경우에도 첫 인덱스를 갖고 있도록 하기 위해서 Map.contains() 를 사용했다. 
    * 처음에 ArrayList 를 쓸지, Array 를 쓸지 잘 정하고 사용하자. 되돌아 가야 하는 경우에 많이 헷갈린다. 

```
for (int i = 0; i < 26; i++) {
            System.out.print(input.indexOf((char)(i+97)) + " ");
        }
```
 
* **위와 같이 `String.indexOf()` 를 사용하면 정말 한줄로 풀 수 있는 문제였다.** 

4. [주어진 횟수만큼 반복해서 출력하기](../src/com/gahee/algorithms/baek/P2675.java)
    * 특별히 어려운 문제가 아니었다.
    
5. [가장 많이 등장한 문자 출력하기](../src/com/gahee/algorithms/baek/P1157.java)
    * 만약 제일 많이 등장한 문자가 여러개인 경우 '?' 를 출력해야 한다. 
    * 여러개였을때 어떻게 처리할지 고민을 좀 했다. 처음에는 같은 경우 boolean isEqual 을 true 로 만들고 
    밑에서 출력할때 이 boolean 값에 따라 출력하도록 했는데, 뒤에 더 많이 반복되는 문자가 나올 수 
    있는 경우를 미처 생각하지 못한 사고였다. 그래서 문자의 끝까지 비교할 수 있도록 하고, 최종적으로 
    charMax 가 뭔지에 따라 출력하도록 바꾸었다. 
    
```
input = input.toUpperCase();

        int arr [] = new int[26];
        int max=0;
        char result = '?';
        for(int i=0; i<input.length(); i++){
            // 문자의 위치에 맞게 배열의 인덱스를 1 증가 
            arr[input.charAt(i) - 65]++;
            // 해당 인덱스의 요소가 max 인지 판별 
            if(max < arr[input.charAt(i)-65]){
                max = arr[input.charAt(i)-65];
                result = input.charAt(i);
            }
             //만약 max 와 값이 같다면 result 를 '?' 로 지정한다. 
            else if(max == arr[input.charAt(i)-65]){
                result ='?';
            }
        }

        System.out.print(result);
        
```

* 중복 제거에 집착해서 굳이 Map 을 사용할 필요는 없었다. 다른 정답을 보니 위의 방법처럼 하여 메모리를 훨씬 적게 사용하였다. 
물론 시간은 내 방법이 조금 더 빠르긴 했다. 
* 알파벳이 26개 이므로 원소 26개짜리 배열을 만든다. 만든 후 -65 를 해서 알파벳 순서에 맞게 배열의 인덱스를 가리킬 수 있게 한다.