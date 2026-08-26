package Modulo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


// Description : You are given four integers -  A, B, C, and P. P is a prime number. Find  A^(B^C) % P.


public class Exponentiation {
  private static long bin_pow(long Base, long Exp, long Mod) {
    long res = 1;
    Base = Base % Mod;
    while (Exp > 0) {
      if ((Exp & 1) == 1) res = (res * Base) % Mod;
      Base = (Base * Base) % Mod;
      Exp >>= 1;
    }
    return res;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());

      if (B == 0 && C != 0) out.println(1);
      else if (A % P == 0 || A == 0) out.println(0);
      else {
        long res = bin_pow((long) B, (long) C, (long) P - 1);
        res = bin_pow((long) A, res, (long) P);
        out.println(res);
      }
    }
    out.flush();
    out.close();
  }
}
