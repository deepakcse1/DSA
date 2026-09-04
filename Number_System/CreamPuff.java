package Number_System;

import java.util.ArrayList;
import java.util.List;

import Number_System.PairedCube.FastScanner;

public class CreamPuff {
  private static List<Long> all_divisors(long n) {
    List<Long> res = new ArrayList<>();
    List<Long> revRes = new ArrayList<>();
    for(long i = 1; i*i <= n; i++){
      if(n % i == 0){
        res.add(i);
        if(i*i != n){
          revRes.add((n/i));
        }
      } 
      
    }
    for(int i = revRes.size()-1; i >= 0; i--){
      res.add(revRes.get(i));
    }
    return res;
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    long n = fs.nextLong();
    List<Long> list = all_divisors(n);
    for(long i : list){
      System.out.println(i);
    }
  }
}
