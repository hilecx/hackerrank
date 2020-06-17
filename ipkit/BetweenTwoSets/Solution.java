package BetweenTwoSets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//Greatest Common Divisor (GCD) or Highest Common Factor (HCF) of two positive integers is the largest positive integer that divides both numbers without remainder.
//It is useful for reducing fractions to be in its lowest terms. See below on methods to find GCD.
//
//Least Common Multiple (LCM) of two integers is the smallest integer that is a multiple of both numbers. See below on methods to find LCM.
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }

        int f = lcm(a);
        int l = gcd(b);
        int count = 0;
        for (int i = f, j = 2; i <= l; i = f * j, j++) {
            if (l % i == 0) {
                System.out.printf("%d %d %d %d \n",i,j,f,l);
                count++;
            }
        }
        System.out.println(count);
    }


    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static int gcd(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }
        return result;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static int lcm(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }
        return result;
    }
}
