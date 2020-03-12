package com.gahee.algorithms.heap;

public class Heap {

    //index 가 0에서부터 시작한다고 가정한다.
    //heap length 의 1/2 만큼 for loop 을 돌면서 호출된다.
    public void maxHeapifyRecur(int[] arr, int parentIdx, int heapSize){
        int left = parentIdx*2;
        int right = parentIdx*2 + 1;
        int largest;

        if(left <= heapSize && arr[left] > arr[parentIdx]){
            largest = left;
        }else{
            largest = parentIdx;
        }

        if(right <= heapSize && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != parentIdx){
            int temp = arr[parentIdx];
            arr[parentIdx] = arr[largest];
            arr[largest] = temp;

            maxHeapifyRecur(arr, largest, heapSize);
        }
    }

    //재귀호출을 사용하지 않는 max heapify 함수
    public void maxHeapify(int[] arr, int parentIdx){
        int heapSize = arr.length;
        int left = parentIdx*2;
        int right = parentIdx*2 + 1;

        int largest; //부모인덱스가 가장 크다고 가정할 때

        while(parentIdx < heapSize/2){

            if(left < heapSize && arr[left] > arr[parentIdx]){
                largest = left;
            }
            else{
                largest = parentIdx;
            }
            if(right < heapSize && arr[right] > arr[largest]){
                largest = right;
            }
            if(largest != parentIdx){
                int temp = arr[parentIdx];
                arr[parentIdx] = arr[largest];
                arr[largest] = temp; //자식보다 작은 부모를 밑으로 내린다.

                parentIdx = largest;
                left = largest*2;
                right = largest*2 + 1;
            }
        }
    }


    //Max Heap 을 만드는 Build max heap
    public void buildMaxHeap(int [] arr){
        int heapSize = arr.length - 1;
        for(int i = heapSize/2; i >= 1; i--){
            maxHeapifyRecur(arr, i, heapSize);
        }
//        for(int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("\n");
    }


    //Heap Sort
    public int [] heapSort(int [] arr){
        buildMaxHeap(arr);
        int [] retArr = new int[arr.length+1];
        int i;

        for(i = arr.length; i > 1;){
            int temp = arr[1];
            arr[1] = arr[i - 1];

            //맨 마지막 노드를 없애는 방법?
            //heapify 함수에다가 배열의 길이를 같이 넘겨준다.
            retArr[i-1] = temp;
            i--; //decrease array length
            maxHeapifyRecur(arr, 1, i);
        }
        return retArr;
    }


}
