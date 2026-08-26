package Sorting;

public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {3,5,2,0,1,4};
    selectionSort(arr);
    System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
  }

  private static void selectionSort(int[] arr){
    int n = arr.length;
    for(int i = 0; i < n - 1; i++){
      int minIdx = i;
      for(int j = i+1; j < n; j++){
        if(arr[minIdx] > arr[j]){
          minIdx = j;
        }
      }
      // int temp = arr[minIdx];
      // arr[minIdx] = arr[i];
      // arr[i] = temp;
      
      if(minIdx != i) {
        arr[minIdx] = arr[minIdx] + arr[i];
        arr[i] = arr[minIdx] - arr[i];
        arr[minIdx] = arr[minIdx] - arr[i];
        // arr[minIdx] = arr[minIdx] ^ arr[i];
        // arr[i] = arr[minIdx] ^ arr[i];
        // arr[minIdx] = arr[minIdx] ^ arr[i];
      }
    }
  }
}
