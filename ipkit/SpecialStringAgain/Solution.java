package SpecialStringAgain;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        char pre = s.charAt(0);
        long sum = 0;
        List<Character> chars = new ArrayList<>();
        chars.add(pre);
        List<Integer> charCount = new ArrayList<>();
        charCount.add(1);
        char[] c = s.toCharArray();
        for (int i = 1; i < c.length; i++) {
            if(c[i]==pre){
                int lastIndex=charCount.size()-1;
                charCount.set(lastIndex,charCount.get(lastIndex)+1);
            }else if(c[i]!=pre){
                chars.add(c[i]);
                charCount.add(1);
                pre=c[i];
            }
        }

        for (int i = 0; i < chars.size(); i++) {
            sum+=leijiahe(0,charCount.get(i));

            if(i<chars.size()-2 && charCount.get(i+1)==1&& chars.get(i).equals(chars.get(i+2))){
                sum+=Math.min(charCount.get(i+2),charCount.get(i));
            }


        }
        return sum ;

    }

//    (首项+末项)*项数/2
    static long leijiahe(long start, long end){
        return (end+start)*(end-start+1)/2;
    }


    static Map<Integer, BigDecimal> fmap = new HashMap<>();

    public static BigDecimal factorial(int n) {
        BigDecimal b = fmap.get(n);
        if (b == null) {
            BigDecimal result = new BigDecimal(1);
            BigDecimal a;
            for (int i = 2; i <= n; i++) {
                a = new BigDecimal(i);
                result = result.multiply(a);
            }
            fmap.put(n, result);
            return result;
        } else {
            return b;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
