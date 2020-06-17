package DynamicProgramming.MaxArraySum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        dp[1]=Math.max(dp[0],arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(Math.max(dp[i-1],arr[i]),dp[i-2]+arr[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length-1];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        System.out.println(String.valueOf(res));

        scanner.close();
    }
}
