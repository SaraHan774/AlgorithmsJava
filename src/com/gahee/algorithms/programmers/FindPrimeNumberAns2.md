### 소수 찾기 문제 답안 2 

```java
import java.util.HashSet;
class Solution {

    public int solution(String numbers) {
        
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set); //순열을 찾는 함수를 호출, set에 담는다. 

        int count = 0;
        
        //셋 안에서 소수를 찾아본다. 
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }        
        
        return count;
    }

    public boolean isPrime(int n){
        // 0 이나 1은 소수가 아님 
        if(n==0 || n==1) return false;
        //3에서 시작해서 3의 제곱까지 확인, 
        //3에다가 2를 더하는건 짝수는 무조건 소수가 아니기 때문. 
        //5에서 시작해서 5의 제곱까지 확인 ... 반복. 
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            //만약 i 로 나누어진다면 false 를 반환. 소수가 아님. 
            if(n%i==0) return false;
        }
        //만약 i 가 자기 자신까지 갔다면 소수인것. return true. 
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
    }

}
```