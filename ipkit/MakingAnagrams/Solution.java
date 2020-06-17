package MakingAnagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        int[] a1 = new int[128];
        int[] a2 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            a2[s2.charAt(i)]++;
        }
        int dc = 0;
        for (int i = 0; i < 128; i++) {
            dc+=Math.abs(a1[i]-a2[i]);
        }
        return dc;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        System.out.println(String.valueOf(result));


        scanner.close();
    }
}
