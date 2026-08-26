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
  
    // for(int i = n; i >= 1; i--){
    //   for(int j = n; j >= 1; j--){
    //     if(i == 1 || i == n || j == 1 || j == n) System.out.print(n);
    //     else System.out.print(i-1);
    //   }
    //   System.out.println();
    // }

    // for(int i = 0; i < 5; i++){
    //   for(int j = 0; j < 26; j++){
    //     System.out.print(getZizgaz(i, j, 5, 9));
    //   }
    //   System.out.println();
    // }

    for(int i = 0; i < 18; i++){
      for(int j = 0; j < 15; j++){
        System.out.print(getTree(i, j, 15, 9));
      }
      System.out.println();
    }
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 11; j++){
        System.out.print(getWood(i, j, 6, 11));
      }
      System.out.println();
    }
  }
  private static char getWood(int i, int j, int rows, int cols){
    if(j > 4 && j < 8) return '.';
    else return ' '; 
  }
  private static char getTree(int i, int j, int rows, int cols){
    if(i%6 >= j - 6 && i%6 + j >= 6) return '*';
    // if() return '*';
    else return ' '; 
  }

  private static char getZizgaz(int i, int j, int rows, int cols){
    if(i == j%(cols-1) || i + j%(cols-1) == (cols-1)) return (char) (j + 'a');
    else return ' '; 
  }
  public static void main(String[] args) {
    printPattern(6);
  }


}
