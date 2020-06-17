package search.Triplesum;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        a = removeDupliction(a);
        b = removeDupliction(b);
        c = removeDupliction(c);
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        a = Arrays.stream(a).sorted().distinct().toArray();
        b = Arrays.stream(b).sorted().distinct().toArray();
        c = Arrays.stream(c).sorted().distinct().toArray();

        int ai = 0;
        int bi = 0;
        int ci = 0;
        long s = 0;

        while (bi < b.length && ai < a.length && ci < c.length) {
            if (b[bi] >= a[ai] && b[bi] >= c[ci]) {
                s += multiply(ai, ci);

                while (ai + 1 <= a.length - 1 && a[ai + 1] <= b[bi]) {
                    ai++;
                    s += multiply(0, ci);
                }
                while (ci + 1 <= c.length - 1 && c[ci + 1] <= b[bi]) {
                    ci++;
                    s += multiply(ai, 0);
                }
            }
            bi++;
//            System.out.printf("%d %d %d %d\n",ai,bi,ci,s);
        }
        return s;
    }

    private static long multiply(Integer a, Integer b) {
        return (a.longValue() + 1l) * (b.longValue() + 1l);
    }

    private static int[] removeDupliction(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int[] r = new int[set.size()];
        Iterator iterator = set.iterator();
        int i=0;
        while (iterator.hasNext()){
            r[i]=(int)iterator.next();
            i++;
        }
        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);
        System.out.println(ans);

        scanner.close();
    }
}
