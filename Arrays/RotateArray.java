public class RotateArray {
  public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateHelper(0, n-1, nums);
        rotateHelper(0, k-1, nums);
        rotateHelper(k, n-1, nums);
    }
    public void rotateHelper(int st, int end, int[] nums){
        while(st <= end){
            int temp = nums[end];
            nums[end--] = nums[st];
            nums[st++] = temp;
        }
    }
    //-------------------------------------------------------
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     k %= n;
    //     int[] temp = new int[n];
    //     for(int i = 0; i < n; i++){
    //         temp[(i + k) % n] = nums[i];
    //     }
    //     for(int i = 0; i < n; i++){
    //         nums[i] = temp[i];
    //     }
    // }
    //--------------------------------------------------
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] newArr = new int[n];
    //     int count = 0;
    //     k = k%n;
    //     for(int i = n - k; i < n; i++){
    //         newArr[count] = nums[i];
    //         count++;
    //     }
    //     for(int i = 0; i < n - k ; i++){
    //         newArr[count] = nums[i];
    //         count++;
    //     }
    //     for(int i = 0; i < n; i++){
    //         nums[i] = newArr[i];
    //     }
    // }
    //-------------------------------------------------
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     for(int i = 0; i < k; i++){
    //         int last = nums[n-1];
    //         for(int j = n - 2; j >= 0; j--){
    //             nums[j+1] = nums[j];
    //         }
    //         nums[0] = last;
    //     }
    // }
}
