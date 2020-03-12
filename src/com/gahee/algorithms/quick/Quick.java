package com.gahee.algorithms.quick;

public class Quick {

    //p..q, q+1..r 배열의 일부분을 나누는 작업
    public int partition(int [] arr, int p, int r){
        //pivot 을 선택한다.
        int pivot = arr[r]; //배열의 가장 뒤
        //피봇을 배열 내에서 배치시키기 위해 자리를 잡을 때 사용하는 변수 i
        int i = p-1; //시작은 배열의 가장 앞 부분 - 1

        /*배열의 가장 앞 부분부터 피봇과 비교하며 순회한다.
        만약 피봇보다 arr[j]가 작거나 같으면 i 를 한 칸 앞으로 보낸 후
        arr[j] 와 한 칸 이동한 arr[i] 와 swap 한다.
        피봇보다 크다면 그대로 넘어간다.*/

        for(int j = p; j < arr.length; j++){
            if(arr[j] <= pivot){
                i += 1;
                int temp = arr[i];
                arr[i] = arr[j]; //피봇보다 작은 숫자인 arr[j]가 앞으로 온다.
                arr[j] = temp; //피봇보다 큰 숫자가 뒤로 간다.
                //i 의 자리 바로 다음부터는 항상 pivot 보다 큰 숫자만이 남게 된다.
            }
        }//분할의 복잡도는 O(n) 이다.

        /*순회가 끝나면 i 부터 인덱스 0 까지의 숫자들은 항상 피봇보다 작거나 같다.
        따라서 i+1 번째 원소와 피봇을 swap 해주면 pivot 을 기준으로 왼쪽, 오른쪽
        원소들이 pivot 보다 작은 상태 vs pivot 보다 큰 상태로 나뉘게 된다.*/

        int temp = arr[i+1];
        arr[i+1] = pivot;
        pivot = temp;

        //i+1 인덱스를 기준으로 partition 되었다.
        return i + 1;
    }

    //partition 을 계속해서 하면서 p < r 를 만족할 때 까지 이를 반복한다.
    public void quickSort(int [] arr, int p, int r){
        if(p < r){
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }
}
