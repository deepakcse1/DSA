public class InPlaceHeapSort {
  public static void downHeapify(int[] arr, int startIndex, int endIndex){
    int parentIndex = startIndex;
    int leftChildIndex = (parentIndex*2) + 1;
    int rightChildIndex = (parentIndex*2) + 2;
    while (leftChildIndex < endIndex) {
      int minIndex = parentIndex;
      if(arr[leftChildIndex] <  arr[minIndex]){
         minIndex = leftChildIndex;
      }
      if(rightChildIndex < endIndex && (arr[rightChildIndex] < arr[minIndex])){
        minIndex = rightChildIndex;
      }
      if(minIndex == parentIndex){
        return;
      }
      int temp = arr[parentIndex];
      arr[parentIndex] = arr[minIndex];
      arr[minIndex] = temp;
      parentIndex = minIndex;
      leftChildIndex = (parentIndex*2) + 1;
      rightChildIndex = (parentIndex*2) + 2;
    }
  }

  public static void heapSort(int[] arr){
    int n = arr.length;
    //Build the Heap
    for(int i = (n/2)-1; i >= 0 ; i--){
       downHeapify(arr, i, n);
    }

    //Remove element from starting one by one and put them at respective last position in Array(remove element form end and place at top in heap)
    for(int i = n-1; i >= 0; i--){
       int temp = arr[i];
       arr[i] = arr[0];
       arr[0] = temp;
       downHeapify(arr, 0, i);
    }
  }

  public static void main(String[] args) {
    int[] arr = {3,5,1,2,9,8,6,4,7};
    heapSort(arr);
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
}
