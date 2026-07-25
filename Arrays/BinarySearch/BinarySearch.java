package BinarySearch;

public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9};
    int target = 10;
    System.out.println("index of target is :"+binarySearch(arr, target));
  }
  // Two Pointer Approach
  public static int binarySearch(int[] arr, int target){
      int left = 0, right = arr.length-1;
      while (left <= right) {
        int mid = left + (right-left)/2;
        int curr = arr[mid];
        if(curr == target) return mid;
        else if(curr < target) left = mid+1;
        else right = mid -1; 
      }
      return -1;
  }
}
