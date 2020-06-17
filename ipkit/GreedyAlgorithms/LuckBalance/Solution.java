package GreedyAlgorithms.LuckBalance;

import com.sun.corba.se.spi.ior.MakeImmutable;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int r = 0;
        int sum0 = 0;
        int sum1 = 0;
        int[] new1 = new int[contests.length];
        Arrays.fill(new1, -1);
        for (int i = 0; i < contests.length; i++) {
            int v = contests[i][0];

            if (contests[i][1] == 0) {
                sum0 += v;
            } else if (contests[i][1] == 1) {
                new1[i] = v;
                sum1 += v;
            }
        }
        Arrays.sort(new1);
        int maxksum =0;
        for (int i = new1.length-1; i >= new1.length-k; i--) {
            if(new1[i]!=-1) {
                maxksum += new1[i];
            }
        }
        r = maxksum*2-sum1+sum0;
        return r;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);

        scanner.close();
    }
}
