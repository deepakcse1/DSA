package CodeForces_Template;
import java.io.*;
import java.util.*;

class Main{
    private static long bin_pow_itr(long base, long exponent, long mod){
        long res = 1;
        base %= mod;
        while(exponent > 0){
        if((exponent & 1) == 1) res = (base * res) % mod; //check whether current bit is 1
        base = (base * base) % mod;
        exponent >>= 1;//exponent /= 2; exponent >>= 1 → move to the next bit
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = bin_pow_itr(1378, n, 10);
        System.out.println(res);
        sc.close();
    }
}