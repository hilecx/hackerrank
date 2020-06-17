package RecursionBacktracking.RecursiveDigitSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < k; i++) {
//            sb.append(n);
//        }
        String r1 = f(n);
        Integer a = Integer.valueOf(r1)*k;
        String r2 = f(String.valueOf(a));
        return Integer.valueOf(r2);
    }

    static String f(String n) {
        if (n.length() == 1) {
            return n;
        } else {
            BigInteger sum = BigInteger.valueOf(0);

            for (int i = 0; i < n.length(); i++) {
                sum=sum.add(BigInteger.valueOf(Integer.valueOf(n.substring(i,i+1))));
            }
            return f(sum.toString());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println(Character.getNumericValue(49));
        System.out.println(Character.getNumericValue(108));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(result);

        scanner.close();
    }
}
