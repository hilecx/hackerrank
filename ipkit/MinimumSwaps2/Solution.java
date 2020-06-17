package MinimumSwaps2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int count = 0;
        boolean isSwitched =false;
        for (int j = 0; j < a.length; j++) {
            isSwitched=false;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] != i+1){
                    switchArray(a,i,a[i]-1);
                    isSwitched=true;
                    count++;
                }
                System.out.println(isSwitched+"--"+i+"---"+j+Arrays.toString(a));
            }
            if(!isSwitched){
                break;
            }
        }
        return count;

    }
    private static void switchArray(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
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

        int res = minimumSwaps(arr);

        System.out.println(res);

        scanner.close();
    }
}
