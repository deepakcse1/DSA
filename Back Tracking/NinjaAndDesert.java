import java.util.ArrayList;

public class NinjaAndDesert {
  public static void main(String[] args) {
    ArrayList<Integer> baseCosts = new ArrayList<>();
    baseCosts.add(21);
    baseCosts.add(12);
    baseCosts.add(3);

    int n = baseCosts.size();
    ArrayList<Integer> toppings = new ArrayList<>();
    toppings.add(18);
    toppings.add(14);
    toppings.add(2);
    toppings.add(12);
    toppings.add(24);
    toppings.add(21);
    int m = toppings.size();
    int target = 5;
    System.out.println(closestCost(n, m, baseCosts, toppings, target));
  }
  public static int closestCost(int n, int m, ArrayList<Integer> baseCosts, ArrayList<Integer> toppings, int target){
	    // Write your code here.
		int max = -1;
    for(int i : baseCosts){
      if(i <= target){
        int x = closestCostHelper(baseCosts,toppings,target,i,i,0);
        if(x > max) max = x;
      }
    }
    if(max == -1){
      int min = Integer.MAX_VALUE;
      for(int i : baseCosts){
        if(i < min) min = i;
      }
      return min;
    }
    return max;
	}
  private static int closestCostHelper(ArrayList<Integer> baseCosts, ArrayList<Integer> toppings, int target, int max, int tillNow, int index) {
     if(index == toppings.size()){
        if(tillNow <= target && tillNow > max) max = tillNow;
        return max;
     }
     int x = closestCostHelper(baseCosts, toppings, target, max, tillNow, index+1);
     int y = closestCostHelper(baseCosts, toppings, target, max, tillNow + toppings.get(index) , index+1);
     int z = closestCostHelper(baseCosts, toppings, target, max, tillNow + 2*toppings.get(index) , index+1);
     int a = Math.max(x, y);
     return Math.max(a, z);
  }
}
