import java.util.ArrayList;

public class PintSubsets {
  public static void main(String[] args) {
    int[] arr = {1,2,3};
    ArrayList<Integer> list = new ArrayList<>();
    printSubsets(arr, 0, list);
  }

  public static void printSubsets(int input[], int index, ArrayList<Integer> list) {
    if(index == input.length){
      for(int i : list) System.out.print(i+" ");
      System.out.println();
      return;
    }

    list.add(input[index]);
    printSubsets(input, index+1, list);
    list.remove(list.size()-1);

    while(index+1 < input.length && input[index+1] == input[index]){
      index++;
    }
    printSubsets(input, index+1, list);

	}
}

