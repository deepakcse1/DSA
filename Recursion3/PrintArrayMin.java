public class PrintArrayMin {

  public static void printArrayMin(int[] arr){
    printArrayMinHelper(arr, 0, Integer.MAX_VALUE);
  }

  public static void printArrayMinHelper(int[] arr, int startIndex, int minSoFar){
    if(startIndex == arr.length){
      System.out.println(minSoFar);
      return;
    }
    int newMinSoFar = Math.min(arr[startIndex], minSoFar);
    printArrayMinHelper(arr, startIndex+1, newMinSoFar);
  }

  public static void main(String[] args) {
    int[] arr = {5,2,7,3,-2,1,8,-5,9};
    printArrayMin(arr);
  }
}
