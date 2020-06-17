package search.Pairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int c = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.printf("%d %d %d\n",i,j,arr[i]-arr[j]);
                if(Math.abs(arr[i]-arr[j])==k){
                    c++;
                }else if(Math.abs(arr[i]-arr[j])>k) {
                    break;
                }
            }
        }
        return c;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);
        System.out.println(result);

        scanner.close();
    }
}
