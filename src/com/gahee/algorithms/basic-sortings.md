## Sortings 

### 1. Selection Sort
* 핵심 : 현재 요소 a[i] 와 a[i+1] ~ a[n-1] 까지의 요소 중 가장 작은 요소를 교환한다.
* 성능 : 늘 가장 작은 요소를 찾기 위해 순회해야 하기 때문에 N^2 의 성능. (quadratic)

### 2. Insertion Sort 
* 핵심 : a[i] 의 이전의 요소들을 j 로 다시 돌며 a[j] 보다 큰 값을 그 이전 값과 계속해서 비교하며 교환한다.
a[i] 이하의 요소들은 정렬이 보장된다. (grabs an element and brings it back to order)
* 성능 : 이중루프를 돌아야 하기 때문에 N^2 의 성능. (평균적으로 1/4 * N^2 의 성능이라는 proposition 있다)
* Best Case : ascending 정렬이 되어있다면 0 번 교환, N-1번 비교 
* Worst Case : descending 정렬이 되어있는 경우, 1/2*N^2 번 교환&비교
* Inversion : pair of keys that are out of order. 
* An array is partially sorted if the number of inversion is <= c*N (부분적으로 정렬되어 있으면 삽입 정렬이 
선형 시간안에 끝날수도 ...?)

### 3. Shell Sort 
* 핵심 : 삽입 정렬은 한 번에 하나의 요소만을 옮기기 때문에 비효율적. 여러 위치의 요소들을 옮기자.(h-sorting the array)
삽입 정렬과 같지만, a[i] 왼쪽의 요소들을 비교하면서 교환, 정렬할 때 간격을 h 만큼 잡고 한다. 
* h - sort (h : 13, 4, 1)
* 배열을 처음엔 7-sort 했다가, 3-sort 했다가 마지막으로 1-sort 하는 예시. (여러번의 pass 를 거친다)
* 어떤 increment sequence 를 사용해야 하는가? 
    * Powers of Two? No.
    * Powers of two minus one? Maybe. 1, 3, 7, 15, 31 ... 
    * 3x + 1 ? OK. 1, 4, 13, 40 ... 
* Proposition : 최악의 경우 3x+1 increment 일 때 O(N^2/3) 이다 
* 정확한 증가 모델을 찾지 못했다. 
* 배열의 사이즈가 아주 크지 않는 이상 매우 빠르고, 코드의 양이 적어서 embeded system 에서 많이 사용된다. 

    
  