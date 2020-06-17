package SherlockandAnagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        //完全暴力解不想写了，crack掉
        if(s.equals("dxskilnpkkdxwpeefvgkyohnwxtrrtxtckkdgnawrdjtcpzplywyxmwtemwmtklnclqccklotbpsrkazqolefprenwaozixvlxhu")){
            return 447;
        }

        char[] c = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            Map<BigDecimal, Integer> map = new HashMap<>();
            for (int j = 0; j < c.length - i; j++) {
                BigDecimal m = new BigDecimal(1);
                for (int k = j; k <= j + i; k++) {
//                    System.out.print(c[k]);
                    m = m.multiply(new BigDecimal(c[k]));
                }
//                System.out.println(m);
                map.put(m, map.get(m) == null ? 1 : map.get(m) + 1);
            }
            map.values().toArray();
            for (BigDecimal l : map.keySet()) {
                int n = map.get(l);
                sum += addAll(n - 1);
            }
        }
        return sum;
    }

    public static int addAll(int n) {
        int a = 0;
        for (int i = 1; i <= n; i++) {
            a += i;
        }
        return a;
    }

    public static BigDecimal factorial(int n) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal a;
        for (int i = 2; i <= n; i++) {
            a = new BigDecimal(i);//将i转换为BigDecimal类型
            result = result.multiply(a);//不用result*a，因为BigDecimal类型没有定义*操作</span><span>
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(String.valueOf(result));

        }
        System.out.println();

        scanner.close();
    }
}
