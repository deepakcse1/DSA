// import java.io.*;
import java.util.*;

public class Pond {
  private static boolean isValid(long[][] matrix, int n, int k, long mid){
    long[][] prefixSum = new long[n+1][n+1];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        long value = matrix[i][j] <= mid ? 1L : 0L;
        prefixSum[i+1][j+1] = value + prefixSum[i+1][j] + prefixSum[i][j+1] - prefixSum[i][j];
      }
    }
    
    long thresold = (((long) k * k + 1) / 2); // upper bound for even length
    for(int i = 0; i <= n-k; i++){
      for(int j = 0; j <= n-k; j++){
        long count = prefixSum[i+k][j+k] - prefixSum[i+k][j] - prefixSum[i][j+k] + prefixSum[i][j];
        if(count >= thresold) return true;
      }
    }
    return false;
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    long max = 0L;
    long min = Long.MAX_VALUE;
    long[][] matrix = new long[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        matrix[i][j] = sc.nextLong();
        min = Math.min(min, matrix[i][j]);
        max = Math.max(max, matrix[i][j]);
      }
    }
    
    long lo = min;
    long hi = max;
    long ans = 0;
    while(lo <= hi){
      long mid = lo + (hi - lo) / 2;
      if(isValid(matrix, n, k, mid)){
        ans = mid;
        hi = mid - 1;
      }
      else lo = mid + 1;
    }
    System.out.println(ans);
    
    // Brute Force-----------------------------------------
    // int rank = (k * k) / 2 + 1;
    // int medianIndex = (k * k) - rank; //1 based index
    
    // long min = Long.MAX_VALUE;
    // for(int i = 0; i <= n - k; i++){
    //   for(int j = 0; j <= n-k; j++){
        
    //     List<Long> list = new ArrayList<>();
    //     for(int l = 0; l < k; l++){
    //       for(int m = 0; m < k; m++){
    //         list.add(matrix[i+l][j+m]);
    //       }
    //     }
    //     Collections.sort(list);
    //     long median = list.get(medianIndex);
    //     min = Math.min(min, median);
    //   }
    // }
    
    // System.out.println(min);
    sc.close();
  }
}