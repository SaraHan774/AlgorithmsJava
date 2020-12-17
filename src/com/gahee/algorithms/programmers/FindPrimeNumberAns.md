#### 프로그래머스 소수찾기 문제 해답 

* 참고 블로그 링크 [LINK](https://velog.io/@qweadzs/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%86%8C%EC%88%98-%EC%B0%BE%EA%B8%B0java)
* 코드 with comments [CODE](./FindPrimeNumber1.java)

---

```java

import java.util.*;
class Solution {
    int[] num;
	TreeSet<Integer> set;
	boolean[] visited;
	int answer = 0;
    String numbers="";
    
    public int solution(String numbers) {
        num = new int[numbers.length()];
        set = new TreeSet();
        
        
        visited = new boolean[num.length];
        this.numbers = numbers;
        
        for (int i = 0; i < num.length; i++) { // num배열에 숫자 하나씩 뜯어서 저장
			num[i] = numbers.charAt(i) - '0';
		}

		Arrays.sort(num);// 오름차순 정렬

		for (int i = 0; i < numbers.length(); i++) { // 숫자 조합 구하기
			int[] list = new int[i + 1];
			// *** 리스트의 역할은 무엇인가? ***
            // *** depth = 0 부터 시작해서 길이가 1인 것 부터 조합을 찾아나간다. *** 
			combination(0, i + 1, -1, list);
		}

		boolean[] prime = new boolean[set.last() + 1];
		prime[0] = prime[1] = true;
		// 소수 체크
		for (int i = 2; i <= Math.sqrt(set.last()); i++) {
			if (prime[i])
				continue;
			for (int j = i + i; j <= set.last(); j += i) {
				prime[j] = true;
			}
		}
		for(Integer i : set) {
			if(!prime[i])
				answer++;
		}
        
        return answer;
    }
    
    void combination(int depth, int length, int com, int[] list) {
        //만약 depth 와 길이가 같아진다면 중간 결과들을 이어붙여서 셋에 저장한다. 
		if (depth == length) { // 종료 지점
			String tmp = "";
			for (int i = 0; i < list.length; i++) {// list에 들어있는 숫자 붙여서 set에 저장
				tmp += list[i];
			}
			set.add(Integer.parseInt(tmp));
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
		    // *** 모든 요소들을 방문하였는지 확인 *** 
			if (!visited[i]) {
				visited[i] = true;
				// *** 해당 depth 를 인덱스로 삼아서 숫자를 저장 *** 
				list[depth] = num[i];// list에 저장
                // *** depth 를 증가시키고 재귀 호출 *** 
				combination(depth + 1, length, i, list);
				visited[i] = false;
			}

		}
	}
}
```


#### combination 함수를 출력해보면 

```
[0] //비어있는 한개짜리 배열을 만든다 
combination  depth = 0 length = 1 com = -1 list = [0]
combination  depth = 1 length = 1 com = 0 list = [0]
combination  depth = 1 length = 1 com = 1 list = [1]
combination  depth = 1 length = 1 com = 2 list = [7]
[0, 0]
combination  depth = 0 length = 2 com = -1 list = [0, 0]
combination  depth = 1 length = 2 com = 0 list = [0, 0]
combination  depth = 2 length = 2 com = 1 list = [0, 1]
combination  depth = 2 length = 2 com = 2 list = [0, 7]
combination  depth = 1 length = 2 com = 1 list = [1, 7]
combination  depth = 2 length = 2 com = 0 list = [1, 0]
combination  depth = 2 length = 2 com = 2 list = [1, 7]
combination  depth = 1 length = 2 com = 2 list = [7, 7]
combination  depth = 2 length = 2 com = 0 list = [7, 0]
combination  depth = 2 length = 2 com = 1 list = [7, 1]
[0, 0, 0]
combination  depth = 0 length = 3 com = -1 list = [0, 0, 0]
combination  depth = 1 length = 3 com = 0 list = [0, 0, 0]
combination  depth = 2 length = 3 com = 1 list = [0, 1, 0]
combination  depth = 3 length = 3 com = 2 list = [0, 1, 7]
combination  depth = 2 length = 3 com = 2 list = [0, 7, 7]
combination  depth = 3 length = 3 com = 1 list = [0, 7, 1]
combination  depth = 1 length = 3 com = 1 list = [1, 7, 1]
combination  depth = 2 length = 3 com = 0 list = [1, 0, 1]
combination  depth = 3 length = 3 com = 2 list = [1, 0, 7]
combination  depth = 2 length = 3 com = 2 list = [1, 7, 7]
combination  depth = 3 length = 3 com = 0 list = [1, 7, 0]
combination  depth = 1 length = 3 com = 2 list = [7, 7, 0]
combination  depth = 2 length = 3 com = 0 list = [7, 0, 0]
combination  depth = 3 length = 3 com = 1 list = [7, 0, 1]
combination  depth = 2 length = 3 com = 1 list = [7, 1, 1]
combination  depth = 3 length = 3 com = 0 list = [7, 1, 0]
5

Process finished with exit code 0
```

#### 좀 더 자세히 로그를 찍어보면 ... 

```
[0]
combination  depth = 0 length = 1 com = -1 list = [0]
combination  depth = 1 length = 1 com = 0 list = [0]
finishing depth 1 com 0
combination  depth = 1 length = 1 com = 1 list = [1]
finishing depth 1 com 1
combination  depth = 1 length = 1 com = 2 list = [7]
finishing depth 1 com 2
[0, 0]
combination  depth = 0 length = 2 com = -1 list = [0, 0]
combination  depth = 1 length = 2 com = 0 list = [0, 0]
combination  depth = 2 length = 2 com = 1 list = [0, 1]
finishing depth 2 com 1
combination  depth = 2 length = 2 com = 2 list = [0, 7]
finishing depth 2 com 2
combination  depth = 1 length = 2 com = 1 list = [1, 7]
combination  depth = 2 length = 2 com = 0 list = [1, 0]
finishing depth 2 com 0
combination  depth = 2 length = 2 com = 2 list = [1, 7]
finishing depth 2 com 2
combination  depth = 1 length = 2 com = 2 list = [7, 7]
combination  depth = 2 length = 2 com = 0 list = [7, 0]
finishing depth 2 com 0
combination  depth = 2 length = 2 com = 1 list = [7, 1]
finishing depth 2 com 1
[0, 0, 0]
combination  depth = 0 length = 3 com = -1 list = [0, 0, 0]
combination  depth = 1 length = 3 com = 0 list = [0, 0, 0]
combination  depth = 2 length = 3 com = 1 list = [0, 1, 0]
combination  depth = 3 length = 3 com = 2 list = [0, 1, 7]
finishing depth 3 com 2
combination  depth = 2 length = 3 com = 2 list = [0, 7, 7]
combination  depth = 3 length = 3 com = 1 list = [0, 7, 1]
finishing depth 3 com 1
combination  depth = 1 length = 3 com = 1 list = [1, 7, 1]
combination  depth = 2 length = 3 com = 0 list = [1, 0, 1]
combination  depth = 3 length = 3 com = 2 list = [1, 0, 7]
finishing depth 3 com 2
combination  depth = 2 length = 3 com = 2 list = [1, 7, 7]
combination  depth = 3 length = 3 com = 0 list = [1, 7, 0]
finishing depth 3 com 0
combination  depth = 1 length = 3 com = 2 list = [7, 7, 0]
combination  depth = 2 length = 3 com = 0 list = [7, 0, 0]
combination  depth = 3 length = 3 com = 1 list = [7, 0, 1]
finishing depth 3 com 1
combination  depth = 2 length = 3 com = 1 list = [7, 1, 1]
combination  depth = 3 length = 3 com = 0 list = [7, 1, 0]
finishing depth 3 com 0
5

Process finished with exit code 0

```