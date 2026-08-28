package Modulo;

import java.io.*;
// Description : You are given an equation of the form (a op1 b op2 c) mod p, where op1 and op2 are operators which can be +,−,∗,/+,−,∗,/. 
// It is guaranteed that (a,p)=(b,p)=(c,p)=1 and p is a prime number. 

public class SolveTheEquation {
    static long mod;
    static long bin_pow(long base, long exp){
        long res = 1;
        base = base % mod;
        while(exp > 0){
            if((exp & 1) == 1) res = (base * res) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
    static long calculate(long x, long y, char op){
        if(op == '+') return (x + y) % mod;
        else if(op == '-') return ((x - y) % mod + mod) % mod;
        else if(op == '*') return (x * y) % mod;
        else return (x * bin_pow(y, mod - 2)) % mod;
    }
    static int precedence(char op){
        return (op == '*' || op == '/') ? 2 : 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] tokens = br.readLine().trim().split("\\s+");
            long a = Long.parseLong(tokens[0].substring(1));
            char op1 = tokens[1].charAt(0);
            long b = Long.parseLong(tokens[2]);
            char op2 = tokens[3].charAt(0);
            long c = Long.parseLong(tokens[4].substring(0, tokens[4].length() - 1));
            mod = Long.parseLong(tokens[6]);
            long ans;
            if(precedence(op1) >= precedence(op2)){
                ans = calculate(a, b, op1);
                ans = calculate(ans, c, op2);
            }else{
                ans = calculate(b, c, op2);
                ans = calculate(a, ans, op1);
            }
            out.println(ans);
        }
        out.flush();
        out.close();
    }
}
