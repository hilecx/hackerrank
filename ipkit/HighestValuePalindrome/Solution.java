package HighestValuePalindrome;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        char[] c = s.toCharArray();
        int[] u = new int[n];
        for (int i = 0; i < (n+1)/2; i++) {
            if(c[i] != c[n-i-1]){
                char max = (char) Math.max(c[i],c[n-i-1]);
                if(c[i] != max) {
                    c[i] = max;
                    u[i]=1;
                }else if(c[n-i-1] != max) {
                    c[n-i-1] = max;
                    u[n-i-1]=1;
                }
                k--;
            }
        }
        if(k<0){
            return "-1";
        }
        int m=0;
        while (k>=1 && m<(n+1)/2){
            if(c[m]<'9'){
                int d = 0;
                if(u[m]==0){
                    d++;
                }
                if(u[n-m-1]==0 && m!=n-m-1){
                    d++;
                }
                if(k-d<0){
                    m++;
                    continue;
                }
                k-=d;
                c[m]='9';
                c[n-m-1]='9';
            }
            m++;
        }
        return new String(c);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        System.out.println(result);

        scanner.close();
    }
}
