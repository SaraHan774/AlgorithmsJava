# Recursion

#### 2020-05-13 
1. [팩토리얼 구하기](../src/com/gahee/algorithms/baek/P10872.java) 
    * 0! = 1 이라는 부분을 적절히 처리해 주어야 한다. 
```
   private static long factorial(long n) {
        if(n <= 1) { //n==1 이라고 써서 에러남 ...
            return 1;
        }
        return n * factorial(n-1);
    }
```

2. [피보나치 수 구하기](../src/com/gahee/algorithms/baek/P10870.java)
    * 재귀로 풀이

3. [별찍기](../src/com/gahee/algorithms/baek/A2447.java)
    * 분할정복으로 푸는 것인데 ... 정답을 봐도 잘 모르겠다. 

