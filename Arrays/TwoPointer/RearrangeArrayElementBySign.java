package TwoPointer;

public class RearrangeArrayElementBySign {
  public int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] ansArr = new int[n];
    int posIdx = 0;
    int negIdx = 1;
    for (int el : nums) {
      if (el > 0) {
        ansArr[posIdx] = el;
        posIdx += 2;
      } else if (el < 0) {
        ansArr[negIdx] = el;
        negIdx += 2;
      }
    }
    return ansArr;
  }
    // public int[] rearrangeArray(int[] nums) {
    //     int n = nums.length;
    //     int[] ansArr = new int[n];
    //     int k = 0;
    //     int posIdx = -1;
    //     int negIdx = -1;
    //     for(int i = 0; i < n; i++){
    //         if(nums[i] > 0 && posIdx == -1) posIdx = i;
    //         if(nums[i] < 0 && negIdx == -1) negIdx = i;
    //         if(posIdx != -1 && negIdx != -1) break;
    //     }
    //     while(k < n){
    //         ansArr[k++] = nums[posIdx++];
    //         ansArr[k++] = nums[negIdx++];
    //         while(posIdx < n && nums[posIdx] < 0) posIdx++;
    //         while(negIdx < n && nums[negIdx] > 0) negIdx++;
    //     }
    //     return ansArr;
    // }
}
