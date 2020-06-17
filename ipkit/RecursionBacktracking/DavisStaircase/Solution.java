package RecursionBacktracking.DavisStaircase;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stepPerms function below.
    static Long[] dp = null;

    static int stepPerms(int n) {
        dp = new Long[n + 1];
        dp[0] = 0L;
        Long c = f(n);
        return new Long(c % 10000000007L).intValue();
    }

    static Long f(int n) {
        if (n == 0) {
            return 1L;
        }
        if (dp[n] != null) {
            return dp[n];
        } else {
            Long sum = 0L;
            if (n - 1 >= 0) {
                dp[n - 1] = f(n - 1);
                sum+=dp[n - 1];
            }
            if (n - 2 >= 0) {
                dp[n - 2] = f(n - 2);
                sum+=dp[n - 2];
            }
            if (n - 3 >= 0) {
                dp[n - 3] = f(n - 3);
                sum+=dp[n - 3];
            }
            return sum;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int res = stepPerms(n);

            System.out.println(res);
        }


        scanner.close();
    }
}
