import java.util.*;
public class UnionOfSortedArray {
  public static int[] unionArray(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int i = 0, j = 0;
    List<Integer> list = new ArrayList<>();
    while(i < m && j < n){
      int value;
      if(nums1[i] < nums2[j]){
        value = nums1[i++];
      }else if(nums1[i] > nums2[j]){
        value = nums2[j++];
      }else{
        value = nums1[i++];
        j++;
      }
      if(list.isEmpty() || list.get(list.size() - 1) != value) list.add(value);
    }
    while(i < m){
      if(list.isEmpty() || list.get(list.size() - 1) != nums1[i]) list.add(nums1[i]);
      i++;
    }
    while(j < n){
      if(list.isEmpty() || list.get(list.size() - 1) != nums2[j]) list.add(nums2[j]);
      j++;
    }
    int[] arr = new int[list.size()];
    i = 0;
    for(int x : list){
      arr[i++] = x;
    }
    return arr;
  }
  // public static int[] unionArray(int[] nums1, int[] nums2) {
  //       Set<Integer> set = new HashSet<>();
  //       for(int i : nums1){
  //           set.add(i);
  //       }
  //       for(int i : nums2){
  //           set.add(i);
  //       }
  //       int[] arr = new int[set.size()];
  //       int i = 0;
  //       for(int el : set){
  //           arr[i++] = el;
  //       }
  //       Arrays.sort(arr);
  //       return arr;
  //   }
  public static void main(String[] args) {
    int[] nums1 = {3, 4, 6, 7, 9, 9};
    int[] nums2 = {1, 5, 7, 8, 8};
    int[] arr = unionArray(nums1, nums2);
    System.out.println(Arrays.toString(arr));
  }
}
