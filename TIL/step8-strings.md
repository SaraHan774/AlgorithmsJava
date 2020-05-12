# Today I Learned (Details)
백준 단계별 문제풀이의 문자열 파트

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
0. 그나마 쉽게 풀었던 문제 ... [전화번호 누르기 문제](../src/com/gahee/algorithms/kakao/DialPad.java)

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