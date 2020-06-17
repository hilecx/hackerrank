package StringsMakingAnagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[][] r = new int[26][2];
        for (int i = 0; i < a.length(); i++) {
            r[a.charAt(i)-97][0]++;
        }
        for (int i = 0; i < b.length(); i++) {
            r[b.charAt(i)-97][1]++;
        }
        int ans=0;
        for (int i = 0; i < r.length; i++) {
            ans+=Math.abs(r[i][0]-r[i][1]);
        }
        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(String.valueOf(res));

        scanner.close();
    }
}
