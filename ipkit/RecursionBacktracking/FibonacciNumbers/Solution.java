package RecursionBacktracking.FibonacciNumbers;

import java.util.*;

public class Solution {

    static int[] dp;
    public static int fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        dp= new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        return f(n-1)+f(n-2);

        // Complete the function.
    }

    static int f(int n){
        int a =dp[n-1];
        int b =dp[n-2];
        return (a==-1?f(n-1):a) +(b==-1?f(n-2):b);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}

