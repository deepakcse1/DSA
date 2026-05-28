package recursion;

import java.util.ArrayList;
import java.util.List;

//how to find contiguous subarrays of an array using recursion 
/* 
arr = [1, 2, 3]
Subarrays:
[1]
[1,2]
[1,2,3]
[2]
[2,3]
[3]
*/

//NOTE : It is not actuall solution of MaximumProduct sub array
public class MaximumProduct {
  public static void main(String[] args) {
    int[] arr = { 3, 5, -2, -4 };
    List<List<Integer>> result = new ArrayList<>();
    generateSubarrays1(arr, 0, arr.length, result);
    generateSubarrays2(arr,0,0,new ArrayList<>(), result);
    // Print result
    for (List<Integer> sub : result) {
      System.out.println(sub);
    }
  }
  //Method - 1 ( Recursion + For loop)
  private static void generateSubarrays1(int[] arr, int start, int n, List<List<Integer>> result){
     if(start == n) return;
     List<Integer> curr = new ArrayList<>();
     for(int end = start; end < n; end++){
        curr.add(arr[end]);
        result.add(new ArrayList<>(curr));
     }
     generateSubarrays1(arr, start+1, n, result);
  }

  //Method - 2 (Only Recursion)
  private static void generateSubarrays2(int[] arr, int start, int end, List<Integer> curr, List<List<Integer>> result){
     if(start == arr.length) return;
     if(end == arr.length){
      generateSubarrays2(arr, start + 1, start + 1, new ArrayList<>(), result);
      return;
     }
     curr.add(arr[end]);
     result.add(new ArrayList<>(curr));
     generateSubarrays2(arr, start, end + 1, curr, result);
  }
}
