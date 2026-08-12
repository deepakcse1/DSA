package Pattern;

public class Main {
  private static void printPattern(int n) {
    // for(int i = 1; i <= n; i++){
    //         for(int j = 1; j <= i; j++){
    //             System.out.print((char)(64 + i)+" ");
    //         }
    //         System.out.println();
    //     }
   
    // //-----------patern 17-----------------------------------
    // for (int i = 1; i <= n; i++) {
    //   for (int j = 1; j <= n - i; j++) {
    //     System.out.print(" ");
    //   }
    //   for (int j = 1; j <= 2 * i - 1; j++) {
    //     System.out.print((char) (64 + (i - Math.abs(i-j))));
    //   }
    //   for (int j = 1; j <= n - i; j++) {
    //     System.out.print(" ");
    //   }
    //   System.out.println();
    // }
    //-----------patern 18-----------------------------------
    // for (int i = n; i >= 1; i--) {
    //   for (int j = i; j <= n ; j++) {
    //     System.out.print((char)(64 + j));
    //   }
    //   System.out.println();
    // }
    //-----------patern 19-----------------------------------
    // for (int i = n; i >= 1; i--) {
    //   for (int j = i; j <= n ; j++) {
    //     System.out.print((char)(64 + j));
    //   }
    //   System.out.println();
    // }
    //-----------patern 19-----------------------------------
    // for (int i = n; i >= 1; i--) {
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   for (int j = 1; j <= 2 * (n - i) ; j++) {
    //     System.out.print(" ");
    //   }
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   System.out.println();
    // }

    // for (int i = 1; i <= n; i++) {
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   for (int j = 1; j <= 2 * (n - i) ; j++) {
    //     System.out.print(" ");
    //   }
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   System.out.println();
    // }

    //-----------patern 20-----------------------------------
    // for (int i = 1; i <= n; i++) {
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   for (int j = 1; j <= 2 * (n - i) ; j++) {
    //     System.out.print(" ");
    //   }
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   System.out.println();
    // }
    // for (int i = n-1; i >= 1; i--) {
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   for (int j = 1; j <= 2 * (n - i) ; j++) {
    //     System.out.print(" ");
    //   }
    //   for (int j = 1; j <= i ; j++) {
    //     System.out.print("*");
    //   }
    //   System.out.println();
    // }

  //   //-----------patern 21-----------------------------------
  //   for(int i = 1; i <= n; i++){
  //     for(int j = 1; j <= n; j++){
  //       if(i == 1 || i == n || j == 1 || j == n)
  //       System.out.print("*"+" ");
  //       else
  //       System.out.print(" "+" ");
  //     }
  //     System.out.println();
  //   }
  // }
  //-----------patern 22-----------------------------------
  
    for(int i = n; i >= 1; i--){
      for(int j = n; j >= 1; j--){
        if(i == 1 || i == n || j == 1 || j == n) System.out.print(n);
        else System.out.print(i-1);
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    printPattern(6);
  }
}
