package CommonChild;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[][] dp;

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                    dp[i][j] = -1;
//            }
//        }
        int r = lcs3(s1, s2, s1.length(), s2.length());
        return r;
    }

//dynamic programming
    static int lcs3(String s1, String s2, int n1, int n2) {
        for (int i = 0; i < n1+1; i++) {
            for (int j = 0; j < n2+1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }


    //    recursion with dynamic programming
    static int lcs(String s1, String s2, int n1, int n2) {
        if (dp[n1][n2] >= 0) {
//            System.out.printf("直接返回dp[%d][%d]=%d \n", n1, n2, dp[n1][n2]);
            return dp[n1][n2];
        }

        if (n1 == 0 || n2 == 0) {
//            System.out.printf("直接返回0 \n");
            dp[n1][n2] = 0;
        }else if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
//            System.out.printf("同时减1，s1.charAt(%d) == s2.charAt(%d)  %s==%s \n", n1 - 1, n2 - 2, s1.charAt(n1 - 1), s2.charAt(n2 - 1));
            dp[n1][n2] =  lcs(s1, s2, n1 - 1, n2 - 1) + 1;
//            System.out.printf("同时减1，计算后返回dp[%d][%d]=%d \n", n1 - 1, n2 - 1, dp[n1 - 1][n2 - 1]);
        } else {
//            dp[n1 - 1][n2] =  lcs(s1, s2, n1 - 1, n2);
//            dp[n1][n2 - 1] =  lcs(s1, s2, n1, n2 - 1);
            dp[n1 ][n2] = Math.max(lcs(s1, s2, n1 - 1, n2),lcs(s1, s2, n1, n2 - 1));
//            System.out.printf("分别减1，计算后返回max:%d  dp[%d][%d]=%d dp[%d][%d]=%d\n", 0, n1 - 1, n2, dp[n1 - 1][n2], n1, n2 - 1, dp[n1][n2 - 1]);
        }
        return dp[n1][n2];
    }

    //    recursion without storage
    static int lcs2(String s1, String s2, int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return lcs2(s1, s2, n1 - 1, n2 - 1) + 1;
        } else {
            return Math.max(lcs2(s1, s2, n1 - 1, n2), lcs2(s1, s2, n1, n2 - 1));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
