public class SubsetArray {

  public static int[][] subsetArray(int arr[], int startIndex) {
    if (startIndex == arr.length) {
      int output[][] = new int[1][0];
      return output;
    }
    int[][] smallOutput = subsetArray(arr, startIndex + 1);
    int[][] output = new int[smallOutput.length * 2][];
    int k = 0;
    for (int i = 0; i < smallOutput.length; i++) {
      output[k] = new int[smallOutput[i].length];
      for (int j = 0; j < smallOutput[i].length; j++) {
        output[i][j] = smallOutput[i][j];
      }
      k++;
    }
    for(int i = 0; i < smallOutput.length;i++){
      output[k] = new int[smallOutput[i].length+1];
      output[k][0] = arr[startIndex];
      for(int j = 0; j < smallOutput[i].length; j++){
        output[k][j+1] = smallOutput[i][j];
      }
      k++;
    }
    return output;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3};
    int a[][] = subsetArray(arr,0);
    for(int i = 0; i < a.length; i++){
      for(int j = 0; j < a[i].length; j++){
        System.out.print(a[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
