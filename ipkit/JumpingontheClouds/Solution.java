package JumpingontheClouds;

import com.sun.xml.internal.ws.api.server.LazyMOMProvider;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int cc0 = 1;
        int sum = 0;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == 0){
                cc0++;
                if(i==c.length-1){
                    sum+=cc0/2;
                }
            }else if(c[i] ==1){
                sum+=cc0/2;
                cc0=0;
                sum++;

            }
        }
        return sum;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);


        scanner.close();
    }
}
