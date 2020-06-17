package DynamicProgramming.Abbreviation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static Boolean[][] dp;
    static int firstUpperIndex = -1;

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        dp = new Boolean[a.length()][b.length()];
//        boolean[] isUpper0toi = new boolean[a.length()];
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)<=90){
                firstUpperIndex=i;
                break;
            }
        }
        return f(a,b,ai,bi)?"YES":"NO";

    }

    static Boolean f(String a, String b, int ai, int bi) {
        if(ai<0 && bi>=0){
            return false;
        }
        if(bi<0){
            return ai>firstUpperIndex?false:true;
        }

        Boolean r = dp[ai][bi];
        if(r!=null){
            return r;
        }
        if (a.charAt(ai) == b.charAt(bi)) {
            dp[ai][bi]=f(a, b, ai - 1, bi - 1);
        } else if (a.charAt(ai) - b.charAt(bi) == 32) {
            dp[ai][bi]=f(a, b, ai - 1, bi ) || f(a, b, ai-1 , bi - 1);
        }else {
            if(a.charAt(ai)<=90){
                dp[ai][bi]=false;
            }else {
                dp[ai][bi] = f(a, b, ai - 1, bi);
            }
        }
        return dp[ai][bi];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            System.out.println(result);
        }


        scanner.close();
    }
}
