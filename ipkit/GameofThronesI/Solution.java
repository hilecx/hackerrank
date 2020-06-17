package GameofThronesI;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int[] c = new int[128];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)]++;
        }
        int m=0;
        if(s.length()%2==1){
            m=1;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i]%2==1 && m==1){
                m=0;
            }else if(c[i]%2==1){
                return "NO";
            }
        }
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        System.out.println(result);

        scanner.close();
    }
}
