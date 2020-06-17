package DynamicProgramming.Candies;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long x = 0;//down start index - 1
        long preCandyNumber = 1;// pre candy number
        long sum = 1; //result
        long lastPeak = 1; //last peak number, eg:  5123432, at index 6, lastPeak is 4
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) { //always set arr[i] to 1
                sum += 1;
                preCandyNumber = 1;
                x = i;
                lastPeak = 1;
            } else if (arr[i] > arr[i - 1]) {//set arr[i] to pre candy number + 1
                preCandyNumber++;
                sum += preCandyNumber;
                x = i;
                lastPeak = preCandyNumber;
            } else if (arr[i] < arr[i - 1]) {//every indices from x to i need to plus 1
                sum = sum + i - x;
                if (i - x >= lastPeak) {//check if lastpeak need to plus 1
                    sum++;
                }
                preCandyNumber = 1;
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
