package CodeForces_Template;
import java.io.*;
import java.util.*;

public class Main{
    static long mod = 1000000007;
    private static long bin_pow(long base, long exp){
        long res = 1;
        while(exp > 0){
            if((exp & 1) == 1) res = (base * res) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long total = bin_pow(27, n) % mod;
        long bad = bin_pow(7, n) % mod;
        System.out.println(((total - bad) % mod + mod) % mod) ;
        sc.close();
    }
}