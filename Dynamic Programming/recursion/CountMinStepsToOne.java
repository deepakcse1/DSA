package recursion;

public class CountMinStepsToOne {
  public static void main(String[] args) {
    System.out.println(countMinStepsToOne(10));
  }
  public static int countMinStepsToOne(int n){
    //base case
    if(n == 1) return 0;

    //choices
    int op1 = countMinStepsToOne(n-1);
    int op2 = Integer.MAX_VALUE, op3 = Integer.MAX_VALUE;
    if(n % 2 == 0) op2 = countMinStepsToOne(n/2);
    if(n % 3 == 0) op3 = countMinStepsToOne(n/3);

    //optimal
    return 1 + Math.min(op1, Math.min(op2, op3));

  }
}
