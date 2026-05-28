import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12}};
    List<Integer> list = spiralOrder(matrix);
    for(int i : list){
      System.out.print(i+" ");
    }
    System.out.println();
  }
  public static  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m-1;
        int top = 0, bottom = n-1;
        while(top <= bottom && left <= right ){
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
