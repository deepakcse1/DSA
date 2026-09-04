package Number_System;

import java.util.ArrayList;
import java.util.List;

public class FindAllDivisors {
  private static List<Long> divisors(long n){
    List<Long> list = new ArrayList<>();
    for(long i = 1; i * i <= n; i++){
      if(n % i == 0){
        list.add(i);
        if(i * i != n) list.add(n / i);
      }
    }
    return list;
  }
  public static void main(String[] args) {
    long n = 15;
    for(long i : divisors(n)){
      System.out.print(i+" ");
    }
  }
}
