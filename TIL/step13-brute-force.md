# Brute Force 

#### 2020-05-26

1. [블랙잭](../src/com/gahee/algorithms/baek/P2798.java)
    * 주어진 카드를 모두 비교하여 합이 M을 초과하지 않는 최대 숫자의 합을 출력한다. 
    * 3중 for loop 를 돌면서 모든 카드의 Combination 을 구한다. 
2. [가장 작은 생성자 구하기](../src/com/gahee/algorithms/baek/P2231.java)
    * char - 48 을하면 해당 char 가 숫자였을 때 제대로된 int 값을 구할 수 있다. 
    * 주어진 숫자에서 1을 빼면서 생성자가 될 수 있는지 따져본다.  
3. [덩치 비교하기](../src/com/gahee/algorithms/baek/P7568.java)
    * 몸무게와 키를 필드로 갖는 Person 클래스를 만들고 클래스에 Comparable 인터페이스를 구현한다. 
    * Arrays.fill() 함수를 이용해 등수를 담을 배열을 1로 초기화한다. 
    * 몸무게가 나보다 큰 사람이 있다면 등수 배열의 숫자에 1을 더해나간다. 
4. [체스판 칠하기](../src/com/gahee/algorithms/baek/P1018.java)
    * 어떤 칸에서 칠해야 하는지 판별하는 코드를 작성해야 한다. 
    * 매우 노가다 스럽게 작성해서 결국 맞추기는 맞췄다 ㅠㅠ  
5. [666이 들어간 숫자들](../src/com/gahee/algorithms/baek/P1436.java)
    * 숫자를 666 에서부터 1 씩 증가시킨다. 이 숫자를 String 으로 바꾼 후 N번째로 나타나는 666이 들어간 
    숫자를 찾을때까지 .contains("666"); 을 해준다. 
    * 노가다ㅠㅠ 