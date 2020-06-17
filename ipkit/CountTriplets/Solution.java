package CountTriplets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets2(List<Long> arr, long r) {
        int[] a = new int[100000];
        for (int i = 0; i < arr.size(); i++) {
            int s = kpf(arr.get(i), r);
            a[s]++;
        }
        long ans = 0;
        if (r > 1) {
            for (int i = 0; i < a.length - 2; i++) {
                ans += a[i] * a[i + 1] * a[i + 2];
            }
        }
        if (r == 1) {
            for (int i = 0; i < a.length; i++) {
                ans += c(a[i], a[i] - 3);
            }
        }
        return ans;
    }

    static long c(long n, long m) {
        if (m < 0) {
            return 0;
        }
        return factorial(n).divide(factorial(m)).divide(factorial(n - m)).longValue();
    }

    static Map<Long, BigDecimal> fmap = new HashMap<>();

    public static BigDecimal factorial(long n) {
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

    static int kpf(Long o, long r) {
        if (o == 1) {
            return 0;
        }
        if (r == 1) {
            return o.intValue();
        }
        int a = 1;
        while (o != r) {
            o = o / r;
            a++;
        }
        return a;
    }

//   v2 is a store of the numbers that would serve as the second number in a triplet. For example, if the ratio is 3, if we came across a 9, then 27 could serve as the second number.
//   v3 is, of course, the number that is being searched for to serve as the third number in a triplet.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> v2 = new HashMap<>();
        Map<Long, Long> v3 = new HashMap<>();
        Long count = 0L;
        for (Long k : arr) {
            count += v3.get(k) == null ? 0 : v3.get(k);
            System.out.printf("k: %d   count: %d \n",k,count);
            if (v2.get(k) != null) {
                v3.compute(k * r, (key, value) -> value != null ? value + v2.get(k) : v2.get(k));
            }
            v2.compute(k * r, (key, value) -> value == null ? 1 : value + 1);

            v3.forEach((key, value) -> System.out.printf("v3 key: %s value: %s \n",key ,value));
            v2.forEach((key, value) -> System.out.printf("v2 key: %s value: %s \n",key ,value));

        }
        return count;

    }



    public static void main(String[] args) throws IOException {
//        System.out.println(Math.pow(64, 1.0 / 4));
//        System.out.println(Math.pow(64, 1.0 / 3));
//        System.out.println(Math.pow(64, 1.0 / 2));
//        System.out.println(Math.pow(64, 2));
//        System.out.println(Solution.kpf(64l, 4l));
//        System.out.println(Solution.kpf(125l, 5l));
//        System.out.println(Solution.kpf(81l, 3l));
//        System.out.println(Solution.kpf(80l, 3l));


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));

        bufferedReader.close();
    }
}
